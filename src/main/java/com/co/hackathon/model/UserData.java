package com.co.hackathon.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserData {
    private String email;
    private String cardNumber;
    private String monthYear;
    private String ccv;
    private String zip;
    private String state;
    private String vatNumber;
    private String discountCode;

    public static List<UserData> setData(DataTable dataTable) {
        List<UserData> data = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            data.add(new ObjectMapper().convertValue(map, UserData.class));
        }
        return data;
    }

    public UserData(String email, String cardNumber, String monthYear, String ccv, String zip, String state, String vatNumber, String discountCode) {
        this.email = email;
        this.cardNumber = cardNumber;
        this.monthYear = monthYear;
        this.ccv = ccv;
        this.zip = zip;
        this.state = state;
        this.vatNumber = vatNumber;
        this.discountCode = discountCode;
    }

    public String getEmail() {
        return email;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCcv() {
        return ccv;
    }

    public String getZip() {
        return zip;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public String getState() {
        return state;
    }
}
