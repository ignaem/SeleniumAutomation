package com.solvd;

import com.google.common.io.Files;
import com.solvd.utils.ConfigHelper;
import com.solvd.utils.SessionPool;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public abstract class AbstractTest {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        this.driver.set(SessionPool.getInstance().getDriver());
        this.driver.get().get(ConfigHelper.getValue("URL"));
    }

    @AfterMethod
    public void takeFailureScreenShoot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()){
            TakesScreenshot camera = (TakesScreenshot) driver.get();
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File ("src/test/resources/testFailuresScreenShoots/" + testResult.getName() + ".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @AfterSuite
    public void closeSession() {
        SessionPool.getInstance().releaseDriver(this.driver.get());
    }
}
