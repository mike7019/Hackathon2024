package com.co.hackathon.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HackathonDemoUI {
    public static final Target TXT_EMAIL = Target.the("EMAIL")
            .located(By.xpath("//input[@type='email']"));
    public static final Target TXT_CARD_NUMBER = Target.the("CARD NUMBER")
            .located(By.xpath("//input[@placeholder='numero de tarjeta']"));
    public static final Target TXT_MONTH_YEAR = Target.the("MONTH/YEAR")
            .located(By.xpath("//input[@placeholder='MM/YY']"));
    public static final Target TXT_CCV = Target.the("CCV")
            .located(By.xpath("//input[@placeholder='CVV']"));
    public static final Target TXT_CARDHOLDER = Target.the("CARDHOLDER")
            .located(By.xpath("//input[@placeholder='titular']"));
    public static final Target BTN_COUNTRY = Target.the("COUNTRY")
            .located(By.xpath("//select[@class='form-select']"));
    public static final Target TXT_ZIP = Target.the("ZIP")
            .located(By.xpath("//input[@placeholder='ZIP']"));
    public static final Target TXT_STATE = Target.the("STATE")
            .located(By.xpath("//input[@placeholder='State']"));
    public static final Target TXT_VAT_NUMBER = Target.the("VAT NUMBER")
            .located(By.xpath("//div[3]/div[2]/div/input"));
    public static final Target TXT_DISCOUNT_CODE = Target.the("DISCOUNT CODE")
            .located(By.id("discount"));
    public static final Target BTN_PAY = Target.the("PAY BUTTON")
            .located(By.id("payButton"));
    public static final Target TXT_VALIDATE_PAYMENT = Target.the("VALIDATE PAYMENT")
            .located(By.xpath("//div[3]/div[2]/div/input"));
}
