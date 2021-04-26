package com.selenium.modules;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class WebDriverModule {
    private static final long TIMEOUT = 30;
    protected WebDriver webDriver;
    protected JavascriptExecutor jsExecutor;
    protected Actions actions;
    private Map<String,Integer> browserWindowViewportConstants;
    private String chrome = "chrome";
    public static String worldUrl = "";
    private static final Log LOG= LogFactory.getLog(WebDriverModule.class);
    private static final String ERROR_LOGGED = "Error logged: ";

    public WebDriverModule(WebDriver webDriver){
        this.webDriver = webDriver;
        this.jsExecutor = (JavascriptExecutor) webDriver;
        this.actions = new Actions(this.webDriver);
        this.browserWindowViewportConstants = new HashMap<>();
        browserWindowViewportConstants.put(chrome,17);
    }

    public void click(By locator){
        clickAndHandleStaleElementReferenceException(locator);
    }

    private void clickAndHandleStaleElementReferenceException(By locator){
        waitForElementToBePresent(locator, TIMEOUT);
        try{
            findAndClickElement(webDriver.findElement(locator));
        } catch (StaleElementReferenceException e1){
            LOG.debug(ERROR_LOGGED,e1);
            try {
                findAndClickElement(webDriver.findElement(locator));
            }catch (StaleElementReferenceException e2) {
                LOG.debug(ERROR_LOGGED, e2);
                findAndClickElement(webDriver.findElement(locator));
            }
        }
    }

    public void findAndClickElement(WebElement element) {
        clickElement(element);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public boolean waitForElementToBePresent(By locator, long timeOutInSeconds) {
        boolean result = true;
        try{
            new WebDriverWait(webDriver, timeOutInSeconds).until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (TimeoutException e){
            result = false;
        }
        return result;
    }

    public void typeByLocatorAndPressEnter(By locator, String txt) {
        webDriver.findElement(locator).sendKeys(txt,Keys.RETURN);
    }

    public String getTextFromLocator(By locator) {
        String text = "";

        try {
            text = webDriver.findElement(locator).getText();
        }catch (StaleElementReferenceException e) {
            LOG.debug(ERROR_LOGGED, e);
            try {
                text = webDriver.findElement(locator).getText();
            }catch (StaleElementReferenceException e2) {
                LOG.debug(ERROR_LOGGED, e2);
                text=webDriver.findElement(locator).getText();
            }
        }
        return text;
    }

    public void verifyTrue(boolean expected, String message) {assertTrue(expected, message); }

}
