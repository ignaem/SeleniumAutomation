package com.solvd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage{
    @FindBy(css = ".x-item-title__mainTitle")
    private WebElement productTitle;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle() {
        return getTextFromElement(productTitle);
    }
}
