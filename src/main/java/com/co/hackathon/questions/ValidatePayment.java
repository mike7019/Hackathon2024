package com.co.hackathon.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;

public class ValidatePayment implements Question<Boolean>{

    protected Target element;

    public ValidatePayment(Target element) {
        this.element = element;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return element.resolveFor(actor).isDisplayed();
    }

    public static Question<Boolean> on(Target element){
        return new ValidatePayment(element);
    }
}
