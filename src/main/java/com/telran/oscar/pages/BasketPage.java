package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends PageBase {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".basket-items .row .col-sm-4")
    WebElement nameOfBook;


    public String  takeNameOfBook() {
        return nameOfBook.getText();

    }

    @FindBy(xpath = ".//a[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheck;

    public BasketPage clickOnProceedToCheckOut() {
        click(proceedToCheck);
        return new ShippingPage(driver);
    }

    @FindBy(css = ".btn.btn-primary.btn-sm")
    WebElement checkOutBtn;

    public BasketPage checkoutBasket() {
        click(checkOutBtn);
        return new ShippingPage(driver);
    }
}



