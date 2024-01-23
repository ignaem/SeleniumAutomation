package com.solvd;

import com.solvd.pageObjects.components.NavBar;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTests extends AbstractTest{

    @Test(testName = "HM1")
    public void validateNavigationBarHover() {
        NavBar navBar = new NavBar(driver.get());
        navBar.hoverOnHomeButton();
        navBar.hoverOnDealsButton();
        navBar.hoverOnSavedButton();
        List<WebElement> navBarItems = navBar.getNavBarItems();
        for (WebElement navBarItem : navBarItems) {
            navBar.hoverOnElement(navBarItem);
        }
    }
}
