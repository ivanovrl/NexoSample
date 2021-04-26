package com.selenium.glue;

import com.selenium.modules.GeneralModule.HomePageModule;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;


public class GeneralSteps {

    private WebDriver webDriver;
    private HomePageModule homePageModule;


    public void HomePageModule(WebDriver webDriver) {
        homePageModule = new HomePageModule(webDriver);
    }


    @Given("Navigate to {string}")
    public void navigateTo(String url) {
        homePageModule.navigateToUrl(url);
    }
}
