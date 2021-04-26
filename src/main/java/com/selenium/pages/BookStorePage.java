package com.selenium.pages;

import com.selenium.modules.WebDriverModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookStorePage extends WebDriverModule {

    //List book store page selectors
    private final static By bookStoreButton = By.cssSelector("button[id='gotoStore']");
    private final static By bookStorePageHeader = By.cssSelector("div[class='main-header']");
    //End list book store page selectors
    private final static String bookStorePageHeaderTile = "Book Store";

    public BookStorePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void userNavigatesToBookStore() {
        webDriver.findElement(bookStoreButton).click();
        verifyTrue(webDriver.findElement(bookStorePageHeader).getText().contains(bookStorePageHeaderTile),"User is not on book store page");
    }
}
