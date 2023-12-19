package com.solvd.utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;

public class SessionPool {
    private static ThreadLocal<SessionPool> instance = new ThreadLocal<>();
    private static Capabilities browserCapabilities = new ChromeOptions();
    private List<WebDriver> driversList = new ArrayList<>();

    private SessionPool() {
    }

    public static synchronized SessionPool getInstance() {
        if (instance.get() == null) {
            instance.set(new SessionPool());
        }
        return instance.get();
    }

    public synchronized WebDriver getDriver() {
        WebDriver driver = new RemoteWebDriver(browserCapabilities);
        driversList.add(driver);
        return driver;
    }

    public synchronized void releaseDriver(WebDriver driver) {
        driversList.remove(driver);
        driver.quit();
    }
}
