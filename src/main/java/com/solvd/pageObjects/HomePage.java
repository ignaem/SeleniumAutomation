package com.solvd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {
    @FindBy(id = "gh-ac")
    private WebElement searchBar;
    @FindBy(id = "gh-btn")
    private WebElement searchButton;
    @FindBy(id = "gh-shop-a")
    private WebElement shopByCategoryButton;
    @FindBy(xpath = "//*[contains(text(),'Tecnología')]")
    private WebElement technologyCategoryButton;
    @FindBy(css = ".vl-popular-destinations--evo-v1__name")
    private List<WebElement> cardItems;
    @FindBy(xpath = "//*[contains(text(), 'Ofertas de hoy')]")
    private WebElement dailyDealsCardTitle;
    @FindBy(css = ".vlp-merch-item-title")
    private WebElement dailyDealsProductTitles;
    @FindBy(xpath = "(//*[@class = 'vl-card-header align-end'])[2]")
    private WebElement ourRecommendationsCardTitle;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void typeInSearchBar(String input) {
        type(searchBar, input);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    public void clickShopByCategoryButton() {
        click(shopByCategoryButton);
    }

    public void clickTechnologyCategoryButton() {
        click(technologyCategoryButton);
    }

    public void clickTheseWillGetYourAttentionFifthItem() {
        click(cardItems.get(4));
    }

    public void scrollToDailyDealsCard() {
        scrollToElement(dailyDealsCardTitle);
    }

    public void clickFirstProductFromDailyDeals() {
        click(dailyDealsProductTitles);
    }

    public String getTextFromFirstProductFromDailyDeals() {
        return getTextFromElement(dailyDealsProductTitles);
    }

    public void scrollToOurRecommendationsCard() {
        scrollToElement(ourRecommendationsCardTitle);
    }

    public void clickOurRecommendationsCardFirstItem() {
        click(cardItems.get(7));
    }
}
