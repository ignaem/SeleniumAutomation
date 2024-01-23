package com.solvd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPage {
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        LOG.info("Clicking element: " + element.toString());
        element.click();
    }

    public void type(WebElement element, String input) {
        LOG.info("Typing: '" + input + "' on element: " + element.toString());
        element.sendKeys(input);
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void scrollToElement(WebElement element) {
        Actions actionsAux = new Actions(driver);
        actionsAux.scrollToElement(element).perform();
    }

    public void switchToLastOpenedTab() {
        String currentTab = driver.getWindowHandle();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        tabs.remove(currentTab);
        driver.switchTo().window(tabs.get(0));
    }

    public void hoverOnElement(WebElement element) {
        Actions actionsAux = new Actions(driver);
        actionsAux.moveToElement(element).perform();
    }
}
