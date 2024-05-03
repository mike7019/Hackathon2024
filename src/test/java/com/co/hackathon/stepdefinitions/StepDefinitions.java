package com.co.hackathon.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.hackathon.utils.Utils.ACTOR;

public class StepDefinitions {
    @Given("I am on the demo page")
    public void iAmOnTheDemoPage() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url("http://127.0.0.1:5500/index.html"));;
    }
    @When("I choose to register a new account")
    public void iChooseToRegisterANewAccount() {

    }
    @When("I provide the necessary registration information")
    public void iProvideTheNecessaryRegistrationInformation() {

    }
    @Then("I should receive a clear confirmation that my account has been successfully created")
    public void iShouldReceiveAClearConfirmationThatMyAccountHasBeenSuccessfullyCreated() {

    }
}
