package com.co.hackathon.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.hackathon.drivers.DriverThreads.driver;
import static com.co.hackathon.drivers.DriverThreads.selfHealingDriver;
import static com.co.hackathon.utils.Utils.CHROME;

public class Hooks {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(selfHealingDriver(CHROME))));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
