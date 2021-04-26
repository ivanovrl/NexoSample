package com.selenium.modules.BookstoreModule;

import com.selenium.modules.WebDriverModule;
import com.selenium.pages.BookStorePage;
import org.openqa.selenium.WebDriver;

public class BookStoreModule extends WebDriverModule {
    private BookStorePage bookStorPage;

    public BookStoreModule(WebDriver webDriver) {
        super(webDriver);
    }
    public void userNavigatesToBookStorePage() {
        bookStorPage.userNavigatesToBookStore();
    }

    public void userSearchForBook(String bookTitle) {
        bookStorPage.searchForBook(bookTitle);
    }

    public void userVerifiesTheSearchResult(String bookTitle) {
        bookStorPage.verifySearchResult(bookTitle);
    }
}
