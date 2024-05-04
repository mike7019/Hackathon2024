package com.co.hackathon.questions;

import net.serenitybdd.screenplay.Question;

public class ValidatePayment {
    public static Question<String> on() {
        return actor -> actor.recall("validatePayment");
    }
}
