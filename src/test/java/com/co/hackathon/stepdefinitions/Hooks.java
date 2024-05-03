package com.co.hackathon.stepdefinitions;

import com.co.hackathon.drivers.DriverThreads;
import com.co.hackathon.drivers.DriversFactory;
import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.WebDriver;

import static com.co.hackathon.utils.Utils.CHROME;

public class Hooks {
    @Before
    public void setTheStage(){
        WebDriver driver = DriversFactory.createWebDriver(CHROME);
        DriverThreads.setWebDriverScreenshoots(driver);
        WebDriver healerDriver = SelfHealingDriver.create(driver);
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(healerDriver)));
    }
}
