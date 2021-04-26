package com.selenium.modules.GeneralModule;

import com.selenium.modules.WebDriverModule;
import org.openqa.selenium.WebDriver;
import com.selenium.pages.HomePage;




public class HomePageModule extends WebDriverModule {
    private HomePage homePage;

    public HomePageModule(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateToUrl(String url) {
        homePage.navigateUserToHomePage(url);
    }


}
