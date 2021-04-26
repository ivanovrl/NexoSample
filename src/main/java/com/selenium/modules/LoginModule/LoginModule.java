package com.selenium.modules.LoginModule;

import com.selenium.modules.WebDriverModule;
import com.selenium.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginModule extends WebDriverModule {
    private LoginPage loginPage = null;

    public LoginModule(WebDriver webDriver) {
        super(webDriver);
    }
    public void userNavigateToLogin() {
        loginPage.userNavigateToLogin();
    }

    public void userLogsInSuccessfully() {
        loginPage.userLogsInSuccessfully();
    }
}
