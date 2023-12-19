package com.solvd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(id = "gh-ac")
    private WebElement searchBar;
    @FindBy(id = "gh-btn")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void typeInSearchBar(String input) {
        type(searchBar, input);
    }

    public void clickSearchButton() {
        click(searchButton);
    }
}
