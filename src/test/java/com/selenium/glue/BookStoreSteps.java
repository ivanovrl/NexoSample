package com.selenium.glue;

import com.selenium.modules.GeneralModule.DesktopGeneralModule;
import io.cucumber.java.en.And;

public class BookStoreSteps {
    private DesktopGeneralModule desktopGeneralModule;


    @And("^Open Book store page$")
    public void userOpensBookStorePage(){
        desktopGeneralModule.userNavigatesToBookStorePage();
    }
}
