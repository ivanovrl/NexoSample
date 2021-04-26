package com.selenium.pages;

import com.selenium.modules.WebDriverModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.*;

public class BookStorePage extends WebDriverModule {

    //List book store page selectors
    private final static By bookStoreButton = By.cssSelector("button[id='gotoStore']");
    private final static By bookStorePageHeader = By.cssSelector("div[class='main-header']");
    private final static By bookSearchField = By.cssSelector("input[id='searchBox']");
    //End list book store page selectors
    private final static String bookStorePageHeaderTile = "Book Store";
    private final static By searchResults = By.cssSelector("div[class='action-buttons'] a");

    public BookStorePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void userNavigatesToBookStore() {
        webDriver.findElement(bookStoreButton).click();
        verifyTrue(webDriver.findElement(bookStorePageHeader).getText().contains(bookStorePageHeaderTile),"User is not on book store page");
    }

    public void searchForBook(String bookTitle) {
        webDriver.findElement(bookSearchField).sendKeys(bookTitle);
    }

    public void verifySearchResult(String bookTitle) {
        List<WebElement> searchResultsList = webDriver.findElements(searchResults);
        for (WebElement book:searchResultsList){
            if(book.getText().contains(bookTitle)){
                return;
            }
        }
        fail("The search term was not present in the results");
    }
}
