package com.solvd;

import com.solvd.utils.ConfigHelper;
import com.solvd.utils.SessionPool;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTest {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        this.driver.set(SessionPool.getInstance().getDriver());
        this.driver.get().get(ConfigHelper.getValue("URL"));
    }

    @AfterMethod
    public void closeSession() {
        SessionPool.getInstance().releaseDriver(this.driver.get());
    }
}
