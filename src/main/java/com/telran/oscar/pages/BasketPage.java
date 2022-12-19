package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class BasketPage extends ShippingPage {

    private int numOfOrder;

    public int getNumOfOrder() {
        return numOfOrder;
    }


    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".basket-items .row .col-sm-4")
    WebElement nameOfBook;

    public String  takeNameOfBook() {
        return nameOfBook.getText();

    }

    @FindBy(css = ".page_inner .sub-header h1")
    WebElement confirmOrder;

    public String takeNumberOfOrder() {
        return confirmOrder.getText();
    }

    @FindBy(xpath = ".//a[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheck;

    public BasketPage clickOnProceedToCheckOut() {
        click(proceedToCheck);
        return this;
    }

    @FindBy(css = ".btn.btn-primary.btn-sm")
    WebElement checkOutBtn;


    public BasketPage checkoutBasket() {
        click(checkOutBtn);
        return this;
    }

    @FindBy(xpath = "//a[contains(text(),'Continue shopping')]")
    WebElement continueShopping;

    @FindBy(css = ".nav-link.mt-2.mt-lg-0")
    WebElement logoAccount;

    @FindBy(xpath = "//a[contains(text(),'Order History')]")
    WebElement linkOrderHistory;

    @FindBy(css = "tbody tr:nth-child(2) td:nth-child(1) a")
    WebElement ordersNum;

    public BasketPage clickOnContinueShopping() {
        click(continueShopping);
        click(logoAccount);
        click(linkOrderHistory);
        ordersNum.isDisplayed();
        String conOrder = ordersNum.getText().replaceAll("[^\\d.]", "");
        numOfOrder = Integer.parseInt(conOrder);
//        System.out.println("numOfOrder " + numOfOrder);

        compareOrdersNumber();
        return this;
    }

    public boolean compareOrdersNumber() {
        ShippingPage shippingPage = new ShippingPage(driver);

//        System.out.println("shippingPage.getOrderNumber " + getOrderNumber());
        System.out.println("basketPage.getNumOfOrder " + getNumOfOrder());
        int receivedOrderNumber = shippingPage.getOrderNumber();
        int receivedNumOfOrder = getNumOfOrder();
        if (receivedOrderNumber == receivedNumOfOrder) {
            System.out.println(receivedOrderNumber + " = " + receivedNumOfOrder);
            return true;
        } else {
            return false;
        }
    }
}



