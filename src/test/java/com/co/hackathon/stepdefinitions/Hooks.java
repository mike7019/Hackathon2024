package com.co.hackathon.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import static com.co.hackathon.drivers.DriverThreads.driver;

public class Hooks {

    @Before
    public void setTheStage() throws MalformedURLException, URISyntaxException {
        String nodeURL = "http://localhost:8085";
        DesiredCapabilities options = new DesiredCapabilities();
        options.setBrowserName("chrome");
        WebDriver driver = new RemoteWebDriver(new URL(nodeURL), options);
        //WebDriver driver = new RemoteWebDriver(new URL(nodeURL), options);
        //OnStage.setTheStage(new OnlineCast());
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(driver)));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
