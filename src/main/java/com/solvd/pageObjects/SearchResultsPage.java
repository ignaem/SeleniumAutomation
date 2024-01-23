package com.solvd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends AbstractPage {
    @FindBy(css = ".s-item__wrapper")
    private List<WebElement> productsList;
    @FindBy(css = ".s-item__title")
    private List<WebElement> productTitlesList;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getAmountOfProducts() {
        return productsList.size();
    }

    public void clickFirstProduct() {
        click(productTitlesList.get(1));
    }

    public String getFirstProductTitle() {
        return getTextFromElement(productTitlesList.get(1));
    }
    public List<WebElement> getProductTitlesList() {
        return productTitlesList;
    }
}
