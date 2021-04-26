package com.selenium.glue;

import com.selenium.modules.GeneralModule.DesktopGeneralModule;
import com.selenium.modules.LoginModule.LoginModule;
import io.cucumber.java.en.And;

public class LoginSteps {
    private DesktopGeneralModule desktopGeneralModule;
    private LoginModule loginModule;

    @And("Login successfully")
    public void loginSuccessfully() {
        loginModule.userNavigateToLogin();
        loginModule.userLogsInSuccessfully();
    }
}
