package com.solvd;

import com.solvd.pageObjects.HomePageObject;
import com.solvd.pageObjects.SearchResultsPageObject;
import com.solvd.utils.SessionPool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTests extends BaseTest {
    WebDriver driver = SessionPool.getInstance().getDriver();
    HomePageObject homePage = new HomePageObject(driver);
    SearchResultsPageObject searchResultsPage = new SearchResultsPageObject(driver);

    @Test
    public void mockTest() {
        homePage.typeInSearchBar("iPhone 14");
        homePage.clickSearchButton();
        int amountOfProducts = searchResultsPage.getAmountOfProducts();
        Assert.assertTrue(amountOfProducts > 5, "Error: 'Search result page' should display at least 5 products. Actual: " + amountOfProducts);
    }
}
