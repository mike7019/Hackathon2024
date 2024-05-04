package com.co.hackathon.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HackathonDemoUI {
    public static final Target TXT_EMAIL = Target.the("EMAIL")
            .locatedBy("//input[@name='emailAddress']");
    public static final Target TXT_CARD_NUMBER = Target.the("CARD NUMBER")
            .locatedBy("//input[@placeholder='card number']");
    public static final Target TXT_MONTH_YEAR = Target.the("MONTH/YEAR")
            .located(By.name("expiryDate"));
    public static final Target TXT_CCV = Target.the("CCV")
            .located(By.name("cvv"));
    public static final Target TXT_CARDHOLDER = Target.the("CARDHOLDER")
            .located(By.id("cardtest"));
    public static final Target BTN_COUNTRY = Target.the("COUNTRY")
            .located(By.id("billingAddress"));
    public static final Target SEL_COUNTRY = Target.the("SELECT COUNTRY")
            .located(By.xpath("//option[@value='2']"));
    public static final Target TXT_ZIP = Target.the("ZIP")
            .located(By.id("zipCode"));
    public static final Target TXT_STATE = Target.the("STATE")
            .located(By.id("state"));
    public static final Target TXT_VAT_NUMBER = Target.the("VAT NUMBER")
            .located(By.id("vatNumber"));
    public static final Target TXT_DISCOUNT_CODE = Target.the("DISCOUNT CODE")
            .located(By.id("discountCode"));
    public static final Target BTN_PAY = Target.the("PAY BUTTON")
            .located(By.id("payButton"));
    public static final Target TXT_VALIDATE_PAYMENT = Target.the("VALIDATE PAYMENT")
            .located(By.xpath("//div[contains(text(),'Data saved successfully.!')]"));
}
