package com.co.hackathon.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import static net.serenitybdd.core.Serenity.getDriver;

public class DriversFactory {

    public static WebDriver createWebDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome" -> {
                return createChromeDriver();
            }
            case "chrome-headless" -> {
                return createChromeDriverHeadless();
            }
            case "firefox" -> {
                return createFirefoxDriver();
            }
            case "edge" -> {
                return createEdgeDriver();
            }
            default -> {
            }
        }
        return getDriver();
    }

    private static WebDriver createEdgeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximixed");
        WebDriverManager.edgedriver().setup();

        return new ChromeDriver(chromeOptions);
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriverHeadless() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--allow-running-insecure-content --disable-popup-blocking --disable-dev-shm-usage");
        options.addArguments("--disable-infobars --test-type --disable-extensions --disable-translate");
        options.addArguments("--ignore-certificate-errors --no-sandbox --disable-download-notification");
        options.addArguments("use-fake-ui-for-media-stream");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }
}
