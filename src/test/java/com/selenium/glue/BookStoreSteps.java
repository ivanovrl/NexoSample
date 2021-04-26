package com.selenium.glue;

import com.selenium.modules.BookstoreModule.BookStoreModule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookStoreSteps {
    private BookStoreModule bookStoreModule;


    @And("^Open Book store page$")
    public void userOpensBookStorePage(){
        bookStoreModule.userNavigatesToBookStorePage();
    }

    @When("Search for {string}")
    public void searchFor(String searchTerm) {
        bookStoreModule.userSearchForBook(searchTerm);
    }

    @Then("Results contain {string} title")
    public void resultsContainTitle(String bookTitle) {
        bookStoreModule.userVerifiesTheSearchResult(bookTitle);
    }
}
