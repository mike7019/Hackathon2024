package com.co.hackathon.tasks;

import com.github.javafaker.Faker;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.hackathon.userInterfaces.HackathonDemoUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegisterTheUser implements Task {

    protected Faker faker = new Faker();
    public static String validatePayment;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_EMAIL, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(faker.internet().emailAddress()).into(TXT_EMAIL),
                Enter.theValue(faker.number().digits(15)).into(TXT_CARD_NUMBER),
                Enter.theValue(faker.number().digits(2) + "/" + faker.number().digits(2)).into(TXT_MONTH_YEAR),
                Enter.theValue(faker.number().digits(3)).into(TXT_CCV),
                Enter.theValue(faker.address().firstName()).into(TXT_CARDHOLDER),
                Click.on(BTN_COUNTRY),
                Click.on(SEL_COUNTRY),
                Enter.theValue(faker.address().zipCode()).into(TXT_ZIP),
                Enter.theValue(faker.address().state()).into(TXT_STATE),
                Enter.theValue(faker.number().digits(8)).into(TXT_VAT_NUMBER),
                Enter.theValue(faker.lordOfTheRings().character()).into(TXT_DISCOUNT_CODE),
                Click.on(BTN_PAY),
                WaitUntil.the(TXT_VALIDATE_PAYMENT, isVisible()).forNoMoreThan(10).seconds()
                );
        validatePayment = TXT_VALIDATE_PAYMENT.resolveFor(actor).getText();
        actor.remember("validatePayment", validatePayment);
    }

    public static RegisterTheUser on() {
        return Instrumented.instanceOf(RegisterTheUser.class).withProperties();
    }
}
