package com.solvd;

import com.solvd.pageObjects.HomePage;
import com.solvd.pageObjects.SearchResultsPage;
import com.solvd.utils.ConfigHelper;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTests extends AbstractTest {

    @Test
    public void mockTest() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        homePage.typeInSearchBar(ConfigHelper.getValue("SEARCH_STRING"));
        homePage.clickSearchButton();
        int amountOfProducts = searchResultsPage.getAmountOfProducts();
        Assert.assertTrue(amountOfProducts > 5, "Error: 'Search result page' should display at least 5 products. Actual: " + amountOfProducts);
    }

    @Test
    public void mockTestTheSecond() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        homePage.typeInSearchBar(ConfigHelper.getValue("SEARCH_STRING"));
        homePage.clickSearchButton();
        int amountOfProducts = searchResultsPage.getAmountOfProducts();
        Assert.assertTrue(amountOfProducts > 5, "Error: 'Search result page' should display at least 5 products. Actual: " + amountOfProducts);
    }
}
