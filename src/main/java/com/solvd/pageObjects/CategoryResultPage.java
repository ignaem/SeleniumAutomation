package com.solvd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryResultPage extends AbstractPage{
    @FindBy(css = ".b-visualnav__title")
    List<WebElement> resultList;

    @FindBy(css = ".srp-main--isLarge")
    WebElement pageMainContainer;

    @FindBy(css = ".b-promobanner__info-btn")
    WebElement seeAllButton;

    public CategoryResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickFirstResult() {
        click(resultList.get(0));
    }

    public boolean isCategoryResultPageDisplayed() {
        return isElementDisplayed(pageMainContainer);
    }

    public void clickSeeAllButton() {
        click(seeAllButton);
    }
}
