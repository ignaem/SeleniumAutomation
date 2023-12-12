package com.solvd.utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SessionPool {
    private static SessionPool INSTANCE = new SessionPool();
    private static Capabilities browserCapabilities = new ChromeOptions();
    private static WebDriver driver = new RemoteWebDriver(browserCapabilities);

    private SessionPool(){
    }

    public static SessionPool getInstance(){
        return INSTANCE;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
