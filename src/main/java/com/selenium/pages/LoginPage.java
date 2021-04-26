package com.selenium.pages;

import com.selenium.modules.WebDriverModule;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class LoginPage extends WebDriverModule {
    public final String homePageUrl = "";
    //list page selectors
    private final static By userNameField = By.cssSelector("input[id='userName']");
    private final static By passField = By.cssSelector("input[id='password']");
    private final static By pageHeader = By.cssSelector("div[class='main-header']");
    private final static By profilePageAllButtons = By.cssSelector("button[id='submit']");
    //end list page selectors
    private final static String profilePageHeader = "Profile";
    private final static String defaultUsername = "rlto";
    private final static String defaultPassword = "LaR7fB2qtFA7hPP@3";
    private final static String logout = "Log out";


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void userNavigateToLogin() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(worldUrl+"/login");
    }

    public boolean userLogsInSuccessfully() {
        userTypesInUsername();
        userTypesInPassword();
        verifyTrue(webDriver.findElement(pageHeader).getText().contains(profilePageHeader), "User is not on Profile page");
        List<WebElement> buttons = webDriver.findElements(profilePageAllButtons);
        boolean result = false;
        for (WebElement btn: buttons){
            if(webDriver.findElement(profilePageAllButtons).getText().equalsIgnoreCase(logout)){
                result= true;
            }
        }
        return result;
    }

    public void userTypesInUsername() {
        webDriver.findElement(userNameField).sendKeys(defaultUsername);
    }

    public void userTypesInPassword(){
        webDriver.findElement(passField).sendKeys(defaultPassword);
    }
}
