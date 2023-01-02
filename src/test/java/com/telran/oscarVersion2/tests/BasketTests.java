package com.telran.oscarVersion2.tests;

import com.telran.oscar.data.UserData;
import com.telran.oscar.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasketTests extends TestBase{


    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginAndRegisterLink();
        new RegisterPage(driver).fillRegisterFormWithValidData(UserData.USER_REG_PASSWORD, UserData.USER_REG_PASSWORD);

    }

//    @Test
//    public void compareNumberOfOrder() {
//        new ProductPage(driver).addProductToBasket();
//        new BasketPage(driver).clickOnProceedToCheckOut();
//        new ShippingPage(driver).fillFormForShipping();
//        new BasketPage(driver).clickOnContinueShopping();
//    }
//regression
    @Test
    public void compareItemWithTotalPriceTests() {
        int amountBooks = 2;
        new HomePage(driver).addItemToBasket(1).clickOnViewBasketButton();
        double price = new BasketPage(driver).getPriceForOne();
        new BasketPage(driver).enterQuantity("2").pause(1000);
        double priceForSeveral = new BasketPage(driver).getPriceForSeveral();
        double priceTotal = new BasketPage(driver).getTotalPrice();
        Assert.assertEquals(priceForSeveral, price * amountBooks);
        Assert.assertEquals(priceForSeveral, priceTotal);

    }
//regression
    @Test
    public void removeItemFromQuantity() {
        new HomePage(driver).addItemToBasket(1).clickOnViewBasketButton();
        new BasketPage(driver).clickOnLinkRemove();
        Assert.assertTrue(new BasketPage(driver).isMessageDisplayed());
    }
//regression
    @Test
    public void saveItemForLaterFromQuantity() {
        new HomePage(driver).addItemToBasket(1).clickOnViewBasketButton();
        new BasketPage(driver).clickOnLinkSaveForLater();
        Assert.assertTrue(new BasketPage(driver).isMessageDisplayed());
    }
}

