package com.telran.oscarVersion2.tests;

import com.telran.oscar.data.UserData;
import com.telran.oscar.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsTests extends TestBase{


    @BeforeMethod
    public void ensurePrecondition() {


    }

    @Test
    public void writeReviewToBookWithRegistrationUserTest() {
        new HomePage(driver).clickOnLoginAndRegisterLink();
        new RegisterPage(driver).fillRegisterFormWithValidData(UserData.USER_REG_PASSWORD, UserData.USER_REG_PASSWORD);
        new ProductPage(driver).addReviewToBook();
        Assert.assertTrue(new ProductPage(driver).takeAlertDisplayed().contains("Thank you for reviewing this product"));
    }

    @Test
    public void writeReviewToBookWithNotRegistrationUserTest() {
        new ProductPage(driver).addReviewToBookWithRegistrationUser();
        Assert.assertTrue(new ProductPage(driver).takeAlertDisplayed().contains("Thank you for reviewing this product"));
    }


    @Test
    public void addBookToBasketWithRegistrationUserTest() {
        new HomePage(driver).clickOnLoginAndRegisterLink();
        new RegisterPage(driver).fillRegisterFormWithValidData(UserData.USER_REG_PASSWORD, UserData.USER_REG_PASSWORD);
        new ProductPage(driver).addBookToBasket();
        Assert.assertTrue(new ProductPage(driver).takeDropDownMenuDisplayed());
    }

    @Test
    public void addShippingWithRegistrationUserTest() {
        new HomePage(driver).clickOnLoginAndRegisterLink();
        new RegisterPage(driver).fillRegisterFormWithValidData(UserData.USER_REG_PASSWORD, UserData.USER_REG_PASSWORD);
        new ProductPage(driver).addBookToBasket();
        new BasketPage(driver).checkoutBasket();
        new ShippingPage(driver).fillFormForShipping();
        new RegisterPage(driver).clickOnAccount();
        new ProfilePage(driver).clickOnDeleteProfile();
        new ProfilePage(driver).fillTheFieldPassword();
        Assert.assertTrue(new ProductPage(driver).isProductPage().contains("All products"));
;
    }
}

