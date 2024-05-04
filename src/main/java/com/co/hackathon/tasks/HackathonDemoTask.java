package com.co.hackathon.tasks;

import com.co.hackathon.model.UserData;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.co.hackathon.userInterfaces.HackathonDemoUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class HackathonDemoTask implements Task {
    private final UserData userData;

    public HackathonDemoTask(UserData userData) {
        this.userData = userData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_EMAIL, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(userData.getEmail()).into(TXT_EMAIL),
                Enter.theValue(userData.getCardNumber()).into(TXT_CARD_NUMBER),
                Enter.theValue(userData.getMonthYear()).into(TXT_MONTH_YEAR),
                Enter.theValue(userData.getCcv()).into(TXT_CCV),
                Enter.theValue(userData.getZip()).into(TXT_ZIP),
                Enter.theValue(userData.getState()).into(TXT_STATE),
                Enter.theValue(userData.getVatNumber()).into(TXT_VAT_NUMBER),
                Enter.theValue(userData.getDiscountCode()).into(TXT_DISCOUNT_CODE),
                Click.on(BTN_PAY)
        );
    }

    public static Performable withUserData(UserData userData) {
        return new HackathonDemoTask(userData);
    }
}
