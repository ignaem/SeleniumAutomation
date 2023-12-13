package com.solvd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        System.out.println("Clicking element: " + element.toString());
        element.click();
    }

    public void type(WebElement element, String input) {
        System.out.println("Typing: '" + input + "' on element: " + element.toString());
        element.sendKeys(input);
    }
}
