package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ShippingPage extends BasePage {


    private int orderNumber;

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_first_name")
    WebElement firstName;

    @FindBy(id = "id_last_name")
    WebElement lastName;

    @FindBy(id = "id_line1")
    WebElement address;

    @FindBy(id = "id_line4")
    WebElement city;

    @FindBy(id = "id_postcode")
    WebElement postcode;

    @FindBy(id = "id_country")
    WebElement country;

    @FindBy(xpath = " //option[contains(text(),'Germany')]")
    WebElement countryName;

    @FindBy(css = ".btn.btn-lg.btn-primary")
    WebElement continueBtn;

    @FindBy(id = "view_preview")
    WebElement continuePaymentBtn;

    @FindBy(id = "place-order")
    WebElement placeOrderBtn;


    public ShippingPage fillFormForShipping() {
        type(firstName, "Tina");
        type(lastName, "Born");
        type(address, "Schnelstrasse");
        type(city, "Berlin");
        type(postcode, "12439");
        click(country);
        click(countryName);
        click(continueBtn);
        click(continuePaymentBtn);
        click(placeOrderBtn);
        return this;
    }

    @FindBy(css = ".offset-sm-4 .btn ")
    WebElement continueShopping;

    public ShippingPage pushContinueShopping() {
        click(continueShopping);
        return this;
    }

}