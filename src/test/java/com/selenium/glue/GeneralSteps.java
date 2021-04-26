package com.selenium.glue;

import com.selenium.modules.GeneralModule.DesktopGeneralModule;
import io.cucumber.java.en.Given;



public class GeneralSteps {

    private DesktopGeneralModule desktopGeneralModule;

    public GeneralSteps(DesktopGeneralModule desktopGeneralModule) {
        this.desktopGeneralModule = desktopGeneralModule;
    }

    @Given("Navigate to {string}")
    public void navigateTo(String url) {
        desktopGeneralModule.navigateToUrl(url);
    }
}
