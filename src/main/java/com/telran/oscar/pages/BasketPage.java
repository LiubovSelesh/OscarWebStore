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
        shippingPage.getOrderNumber();

        System.out.println("shippingPage.getOrderNumber " + getOrderNumber());
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

    @FindBy(css = ".basket-items:nth-child(6) :nth-child(4)")
    WebElement priceForOne;

    public double getPriceForOne() {
        double num = getNum(priceForOne);
        return num;
    }

    public double getNum(WebElement element) {
        double num =Double.parseDouble(element.getText().replaceAll("[^\\d.]", ""));
        return num;
    }

    @FindBy(id = "id_form-0-quantity")
    WebElement quantity;

    @FindBy(css = ".input-group-append")
    WebElement updateQuantity;


    public BasketPage enterQuantity(String n) {
        type(quantity, n);
        click(updateQuantity);
        return this;
    }

    @FindBy(css = ".row .col-md-2 .text-right")
    WebElement priceForSeveral;

    public double getPriceForSeveral() {
        double num2 = getNum(priceForSeveral);
        return num2;
    }

    @FindBy(css = ".total .price_color")
    WebElement priceTotal;

    public double getTotalPrice() {
        double num3 = getNum(priceTotal);
        return num3;
    }

    @FindBy(css = ".basket-line-actions a:nth-child(1)")
    WebElement removeLink;

    public BasketPage clickOnLinkRemove() {
        click(removeLink);
        return this;
    }
    @FindBy(id = "content_inner")
    WebElement message;

    public boolean isMessageDisplayed() {
        return message.isDisplayed();
    }

    @FindBy(css = ".basket-line-actions a:nth-child(2)")
    WebElement savaForLaterLink;

    public BasketPage clickOnLinkSaveForLater() {
        click(savaForLaterLink);
        return this;
    }
}



//