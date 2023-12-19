package com.solvd;

import com.solvd.utils.ConfigHelper;
import com.solvd.utils.SessionPool;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        this.driver = SessionPool.getInstance().getDriver();
        driver.get(ConfigHelper.getValue("URL"));
    }

    @AfterMethod
    public void closeSession() {
        SessionPool.getInstance().releaseDriver(this.driver);
    }
}
