package com.selenium.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebDriverInstance {
    private static final Logger LOGGER = Logger.getLogger(WebDriverInstance.class.getName());

    protected WebDriver webDriver;

    protected void startSelenium(String browser, String browserVersion, String url, String scenarioName) throws MalformedURLException {

        DesiredCapabilities capabilities = null;

        capabilities = new LocalCapabilities(browser, false).getCapabilities();


        Reporter.log("RemoteWebDriver connecting to " + url);
        Reporter.log("Browser: " + capabilities.getBrowserName());
        Reporter.log("Platform: " + capabilities.getPlatform());


        createDriver(url, capabilities);
    }

    public WebDriver createDriver(String url, DesiredCapabilities caps) throws MalformedURLException {
        caps.setCapability(CapabilityType.LOGGING_PREFS, getLogPreference());

        this.webDriver = new RemoteWebDriver(new URL(url), caps);

        this.webDriver.manage().timeouts().setScriptTimeout(180, TimeUnit.SECONDS);

        this.webDriver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

        return webDriver;
    }

    public static LoggingPreferences getLogPreference() {
        LOGGER.log(Level.INFO, "Trying to enable logging prefs");
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
        LOGGER.log(Level.INFO, "Logging preferences enabled");
        return logPrefs;
    }

}
