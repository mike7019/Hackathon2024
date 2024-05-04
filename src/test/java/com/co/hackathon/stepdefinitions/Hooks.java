package com.co.hackathon.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.function.Consumer;

import static com.co.hackathon.drivers.DriverThreads.driver;
import static com.co.hackathon.drivers.DriverThreads.selfHealerInstance;
import static com.co.hackathon.utils.Utils.CHROME;

public class Hooks {

    @Before
    public void setTheStage() throws MalformedURLException, URISyntaxException {
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(selfHealerInstance(CHROME))));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
