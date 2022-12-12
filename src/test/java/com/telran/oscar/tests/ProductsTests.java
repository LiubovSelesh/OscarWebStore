package com.telran.oscar.tests;

import com.telran.oscar.data.UserData;
import com.telran.oscar.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginAndRegisterLink();
//        new LoginPage(driver).fillLoginWithValidData();
        new RegisterPage(driver).fillRegisterFormWithValidData(UserData.USER_REG_PASSWORD, UserData.USER_REG_PASSWORD);
        new HomePage(driver).selectCategory();
    }
//smoky
    @Test
    public void chooseBookForLoginUser(){
        new ProductPage(driver).clickOnBook();
        Assert.assertTrue(new BasketPage(driver).takeNameOfBook().contains("The shellcoder's handbook"));

    }
//smoky
    @Test
    public void chooseBookForLoginUserPushButton(){
        new ProductPage(driver).clickOnBtnAddToBasket();
        new BasketPage(driver).clickOnProceedToCheckOut();
        new ShippingPage(driver).fillFormForShipping();
        Assert.assertTrue(new BasketPage(driver).isAccountDisplayed());

    }
}
