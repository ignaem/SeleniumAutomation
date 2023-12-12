package com.solvd;

import com.solvd.utils.SessionPool;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver = SessionPool.getInstance().getDriver();

    @BeforeMethod
    public void setUp() {
        driver.get("https://www.ebay.com/");
    }

    @AfterSuite
    public void closeSession() {
        driver.close();
    }
}
