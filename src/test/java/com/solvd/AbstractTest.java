package com.solvd;

import com.solvd.utils.ConfigHelper;
import com.solvd.utils.SessionPool;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTest {
    protected WebDriver driver = SessionPool.getInstance().getDriver();

    @BeforeMethod
    public void setUp() {
        driver.get(ConfigHelper.getValue("URL"));
    }

    @AfterSuite
    public void closeSession() {
        driver.close();
    }
}