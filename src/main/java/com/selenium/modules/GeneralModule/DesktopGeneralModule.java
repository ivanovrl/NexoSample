package com.selenium.modules.GeneralModule;

import com.selenium.modules.WebDriverModule;
import com.selenium.pages.BookStorePage;
import com.selenium.pages.HomePage;
import org.openqa.selenium.WebDriver;


public class DesktopGeneralModule extends WebDriverModule {
    private HomePage homePage = null;

    private BookStorePage bookStore = null;

    public DesktopGeneralModule(WebDriver webDriver) {

        super(webDriver);
        this.homePage = new HomePage(webDriver);
        this.bookStore = new BookStorePage(webDriver);

    }

    public void navigateToUrl(String url) {
        homePage.navigateUserToHomePage(url);
    }



    public void userNavigatesToBookStorePage() {
        bookStore.userNavigatesToBookStore();
    }
}
