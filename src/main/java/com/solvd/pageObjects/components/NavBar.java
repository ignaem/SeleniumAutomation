package com.solvd.pageObjects.components;

import com.solvd.pageObjects.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavBar extends AbstractPage {
    @FindBy(css = ".vl-flyout-nav__active")
    private WebElement homeButton;
    @FindBy(css = ".saved")
    private WebElement savedButton;
    @FindBy(css = ".vl-flyout-nav__js-tab.vl-flyout-nav__no-sub")
    private WebElement dealsButton;
    @FindBy(xpath = "//*[@class = '.vl-flyout-nav__js-tab']")
    private List<WebElement> navBarItems;

    public NavBar(WebDriver driver) {
        super(driver);
    }

    public void hoverOnHomeButton() {
        hoverOnElement(homeButton);
    }

    public void hoverOnSavedButton() {
        hoverOnElement(savedButton);
    }

    public void hoverOnDealsButton() {
        hoverOnElement(dealsButton);
    }

    public List<WebElement> getNavBarItems() {
        return navBarItems;
    }

}
