package com.solvd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DealsResultPage extends AbstractPage{

    @FindBy(css = ".dne-itemtile")
    private List<WebElement> productsList;

    @FindBy(css = ".dne-itemtile-title")
    private List<WebElement> productTitles;

    public DealsResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickFirstProduct() {
        click(productTitles.get(0));
    }

    public String getFirstProductTitle() {
        return getTextFromElement(productTitles.get(0));
    }
}
