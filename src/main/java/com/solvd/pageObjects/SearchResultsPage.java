package com.solvd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends AbstractPage {
    @FindBy(css = ".s-item__wrapper")
    private List<WebElement> productsList;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getAmountOfProducts() {
        return productsList.size();
    }
}
