package com.telran.oscarVersion2.tests;

import com.telran.oscar.data.UserData;
import com.telran.oscar.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasketTests extends TestBase{


    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginAndRegisterLink();
        new RegisterPage(driver).fillRegisterFormWithValidData(UserData.USER_REG_PASSWORD, UserData.USER_REG_PASSWORD);

    }

    @Test
    public void compareNumberOfOrder() {
        new ProductPage(driver).addProductToBasket();
        new BasketPage(driver).clickOnProceedToCheckOut();
        new ShippingPage(driver).fillFormForShipping();
        new BasketPage(driver).clickOnContinueShopping();
    }
}

