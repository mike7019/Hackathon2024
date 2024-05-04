package com.co.hackathon.drivers;

import com.epam.healenium.SelfHealingDriver;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;

import static com.co.hackathon.drivers.DriversFactory.createWebDriver;

public class DriverThreads {

    public static WebDriver reportsDriver;
    private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setTheDriver(WebDriver driver) {
        DriverThreads.WEB_DRIVER_THREAD_LOCAL.set(driver);
    }

    public static void setDriverForScreenshots(WebDriver driver) {
        setTheDriver(driver);
        Serenity.getWebdriverManager().setCurrentDriver(driver);
    }

    public static WebDriver selfHealerInstance(String browser) {
        reportsDriver = createWebDriver(browser);
        setDriverForScreenshots(reportsDriver);
        return SelfHealingDriver.create(reportsDriver);
    }

}
