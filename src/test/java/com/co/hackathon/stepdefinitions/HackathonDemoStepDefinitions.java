package com.co.hackathon.stepdefinitions;

import com.co.hackathon.tasks.RegisterTheUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.hackathon.utils.Utils.ACTOR;
import static com.co.hackathon.utils.Utils.URL;

public class HackathonDemoStepDefinitions {

    @Given("the user is on the demo page")
    public void theUserIsOnTheDemoPage() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));;
    }

    @When("he attempts to register the user")
    public void heAttemptsToRegisterTheUser() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegisterTheUser.on()
        );
    }

    @Then("I should receive a clear confirmation that my account has been successfully created")
    public void iShouldReceiveAClearConfirmationThatMyAccountHasBeenSuccessfullyCreated() {

    }


}
