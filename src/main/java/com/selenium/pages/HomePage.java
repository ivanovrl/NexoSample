package com.selenium.pages;

import com.selenium.modules.WebDriverModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends WebDriverModule {

    public HomePage(WebDriver webDriver) {
        super(webDriver);

    }

    public void navigateUserToHomePage(String url) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        worldUrl = url;
    }
}
