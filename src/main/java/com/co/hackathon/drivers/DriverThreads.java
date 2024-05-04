package com.co.hackathon.drivers;

import com.epam.healenium.SelfHealingDriver;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import static com.co.hackathon.drivers.DriversFactory.createWebDriver;

public class DriverThreads {

    public static WebDriver driver;
    private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setTheDriver(WebDriver driver) {
        DriverThreads.WEB_DRIVER_THREAD_LOCAL.set(driver);
    }

    public static void setDriverForScreenshots(WebDriver driver) {
        setTheDriver(driver);
        Serenity.getWebdriverManager().setCurrentDriver(driver);
    }

    public static WebDriver selfHealerInstance(String browser) {
        WebDriver reportsDriver = createWebDriver(browser);
        setDriverForScreenshots(reportsDriver);
        return SelfHealingDriver.create(reportsDriver);
    }

//    public static WebDriver selfHealingDriver() throws URISyntaxException, MalformedURLException {
//        String nodeURL = "http://localhost:4444";
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//
//        WebDriver driver = new RemoteWebDriver(new URL(nodeURL), options);
//
//        return SelfHealingDriver.create(driver);
//    }


}
