package com.co.hackathon.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.hackathon.drivers.DriverThreads.reportsDriver;
import static com.co.hackathon.drivers.DriverThreads.selfHealerInstance;
import static com.co.hackathon.utils.Utils.CHROME;

public class Hooks {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(selfHealerInstance(CHROME))));
    }

    @After
    public void tearDown() {
        if (reportsDriver != null) {
            reportsDriver.quit();
        }
    }

}
