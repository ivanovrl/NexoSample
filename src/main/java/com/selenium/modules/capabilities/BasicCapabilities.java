package com.selenium.modules.capabilities;

import com.selenium.modules.WebDriverInstance;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;


import java.sql.Driver;
import java.util.HashMap;
import java.util.Map;


public class BasicCapabilities {
    private static final Map<String, DesiredCapabilities> DRIVERS;

    static {
        // Load list of supported browsers
        DRIVERS = new HashMap<>();
        DRIVERS.put("chrome", DesiredCapabilities.chrome());
    }
    public ChromeDriver = ;

    private DesiredCapabilities configureChrome(DesiredCapabilities chrome) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--disable-notifications");
        options.setCapability("goog:loggingPrefs", WebDriverInstance.getLogPreference());
        }
        chrome.setCapability(ChromeOptions.CAPABILITY, options);
        return chrome;
    }
}
