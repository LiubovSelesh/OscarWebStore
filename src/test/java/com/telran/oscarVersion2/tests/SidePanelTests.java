package com.telran.oscarVersion2.tests;

import com.telran.oscar.data.UserData;
import com.telran.oscar.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SidePanelTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginAndRegisterLink();
        new RegisterPage(driver).fillRegisterFormWithValidData(UserData.USER_REG_PASSWORD, UserData.USER_REG_PASSWORD);
        new ProductPage(driver).addBookToBasket();
        new BasketPage(driver).checkoutBasket();
        new ShippingPage(driver).fillFormForShipping();
        new RegisterPage(driver).clickOnAccount();
    }
    @Test
    public void editAddressBookTest() {
        new SidePanelPage(driver).changeAddressBook();
        Assert.assertTrue(new SidePanelPage(driver).isAlertDisplayed());
    }

    @Test
    public void deleteAddressBookTest() {
        new SidePanelPage(driver).changeAddressBook();
        new SidePanelPage(driver).deleteAddressBook();
        Assert.assertTrue(new SidePanelPage(driver).isAlertDisplayed());
    }
}
