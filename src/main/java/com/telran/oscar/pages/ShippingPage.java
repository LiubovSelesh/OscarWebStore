package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ShippingPage extends PageBase {


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

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueBtn;

    @FindBy(id = "view_preview")
    WebElement continuePaymentBtn;

    @FindBy(id = "place-order")
    WebElement placeOrderBtn;

    @FindBy(xpath = "//a[contains(text(),'Oscar')]")
    WebElement logo;

    @FindBy(css = ".page_inner .sub-header h1")
    WebElement confirmationOrder ;

    public ShippingPage fillFormForShipping() {
        type(firstName, "Tina");
        type(lastName, "Born");
        type(address,"Schnelstrasse");
        type(city, "Berlin");
        type(postcode, "12439");
        click(country);
        click(countryName);
        click(continueBtn);
        click(continuePaymentBtn);
        click(placeOrderBtn);
        confirmationOrder.isDisplayed();
        String conNum = confirmationOrder.getText().replaceAll("[^\\d.]", "");
        orderNumber = Integer.parseInt(conNum);
        System.out.println("orderNumber " + orderNumber);
//        System.out.println("getOrderNumber " + getOrderNumber());
        return this;
    }



//
}
