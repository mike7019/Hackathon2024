package com.co.hackathon.drivers;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;

public class DriverThreads {

    private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setTheDriver(WebDriver driver){
        DriverThreads.WEB_DRIVER_THREAD_LOCAL.set(driver);
    }

    public static void setWebDriverScreenshoots(WebDriver driver){
        setTheDriver(driver);
        Serenity.getWebdriverManager().setCurrentDriver(driver);
    }
}
