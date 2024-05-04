package com.co.hackathon.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.hackathon.userInterfaces.HackathonDemoUI.TXT_EMAIL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class HackathonDemoTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_EMAIL, isVisible()).forNoMoreThan(30).seconds()
           /*     Enter.theValue(NOMBRES).into(TXT_EMAIL),
                Click.on(BTN_REGISTRARSE)
                );*/
        );
    }
}
