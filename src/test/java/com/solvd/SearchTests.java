package com.solvd;

import com.solvd.pageObjects.*;
import com.solvd.utils.ConfigHelper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class SearchTests extends AbstractTest {
    private final String SEARCH_STRING = ConfigHelper.getValue("SEARCH_STRING");

    @Test
    public void mockTest() {
        HomePage homePage = new HomePage(driver.get());
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver.get());
        homePage.typeInSearchBar(SEARCH_STRING);
        homePage.clickSearchButton();
        int amountOfProducts = searchResultsPage.getAmountOfProducts();
        Assert.assertTrue(amountOfProducts > 5, "Error: 'Search result page' should display at least 5 products. Actual: " + amountOfProducts);
    }

    @Test
    public void mockTestTheSecond() {
        HomePage homePage = new HomePage(driver.get());
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver.get());
        homePage.typeInSearchBar(SEARCH_STRING);
        homePage.clickSearchButton();
        int amountOfProducts = searchResultsPage.getAmountOfProducts();
        Assert.assertTrue(amountOfProducts > 5, "Error: 'Search result page' should display at least 5 products. Actual: " + amountOfProducts);
    }

    @Test(testName = "SR1")
    public void searchProductByName() {
        HomePage homePage = new HomePage(driver.get());
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver.get());
        ProductPage productPage = new ProductPage(driver.get());
        homePage.typeInSearchBar(SEARCH_STRING);
        homePage.clickSearchButton();
        List<WebElement> productTitlesList = searchResultsPage.getProductTitlesList();
        //Need to start index in 1 because first product title element is used as a header of the full products list and does not contain any text.
        for (int i = 1; i < productTitlesList.size(); i++) {
            String productTitle = searchResultsPage.getTextFromElement(productTitlesList.get(i)).toLowerCase();
            Assert.assertTrue(productTitle.contains("iphone"),
                    "Error: product title '" + productTitle + "' does not contain search string: iphone");
        }
        String firstProductTitle = searchResultsPage.getFirstProductTitle();
        searchResultsPage.clickFirstProduct();
        //Product page is opened in a new tab, new to switch to most recent opened tab.
        productPage.switchToLastOpenedTab();
        Assert.assertEquals(firstProductTitle, productPage.getProductTitle());
    }

    @Test(testName = "SR2")
    public void searchProductByCategory() {
        HomePage homePage = new HomePage(driver.get());
        CategoryResultPage categoryResultPage = new CategoryResultPage(driver.get());
        DealsResultPage dealsResultPage = new DealsResultPage(driver.get());
        ProductPage productPage = new ProductPage(driver.get());
        homePage.clickShopByCategoryButton();
        homePage.clickTechnologyCategoryButton();
        Assert.assertTrue(categoryResultPage.isCategoryResultPageDisplayed(),
                "Error: After selecting a category from the drop down category result page should be displayed");
        categoryResultPage.clickFirstResult();
        String firstProductTitle = dealsResultPage.getFirstProductTitle();
        dealsResultPage.clickFirstProduct();
        Assert.assertTrue(productPage.getProductTitle().contains(firstProductTitle));
    }

    @Test(testName = "SR3")
    public void searchProductByTheseWillGetYourAttentionCard() {
        HomePage homePage = new HomePage(driver.get());
        CategoryResultPage categoryResultPage = new CategoryResultPage(driver.get());
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver.get());
        ProductPage productPage = new ProductPage(driver.get());
        homePage.clickTheseWillGetYourAttentionFifthItem();
        categoryResultPage.clickSeeAllButton();
        String firstProductTitle = searchResultsPage.getFirstProductTitle();
        searchResultsPage.clickFirstProduct();
        Assert.assertTrue(productPage.getProductTitle().contains(firstProductTitle));
    }

    @Test(testName = "SR4")
    public void searchProductByDailyDealsCard() {
        HomePage homePage = new HomePage(driver.get());
        ProductPage productPage = new ProductPage(driver.get());
        homePage.scrollToDailyDealsCard();
        String dailyDealsFirstProductTitle = homePage.getTextFromFirstProductFromDailyDeals();
        homePage.clickFirstProductFromDailyDeals();
        productPage.switchToLastOpenedTab();
        Assert.assertTrue(productPage.getProductTitle().contains(dailyDealsFirstProductTitle));
    }

    @Test(testName = "SR5")
    public void searchProductByOurRecommendationsCard() {
        HomePage homePage = new HomePage(driver.get());
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver.get());
        ProductPage productPage = new ProductPage(driver.get());
        homePage.scrollToOurRecommendationsCard();
        homePage.clickOurRecommendationsCardFirstItem();
        String firstProductTitle = searchResultsPage.getFirstProductTitle();
        searchResultsPage.clickFirstProduct();
        productPage.switchToLastOpenedTab();
        Assert.assertTrue(productPage.getProductTitle().contains(firstProductTitle));
    }
}
