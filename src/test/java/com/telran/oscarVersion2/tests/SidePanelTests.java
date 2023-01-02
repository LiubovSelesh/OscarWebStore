package com.telran.oscarVersion2.tests;

import com.telran.oscar.data.UserData;
import com.telran.oscar.data.UserDataReg;
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
        new ShippingPage(driver).pushContinueShopping();
        new RegisterPage(driver).clickOnAccount();
    }
//regression
    @Test
    public void changePasswordInProfileTest() {
        new SidePanelPage(driver).changeAPasswordInProfile(UserData.USER_REG_PASSWORD,
                UserDataReg.USER_REG_PASSWORD1, UserDataReg.USER_REG_CONFIRM1);
        Assert.assertTrue(new SidePanelPage(driver).isAlertPasswordDisplayed());
    }
//regression
    @Test
    public void editProfileTest() {
        new SidePanelPage(driver).editProfile(UserData.FIRST_NAME, UserData.LAST_NAME);
        Assert.assertTrue(new SidePanelPage(driver).isNewNameDisplayed());
    }
//regression
    @Test
    public void editAddressInAddressBookTest() {
        new SidePanelPage(driver).changeAddressBook();
        Assert.assertTrue(new SidePanelPage(driver).isAlertDisplayed());
    }
//regression
    @Test
    public void deleteAddressTestInAddressBookTest() {
        new SidePanelPage(driver).changeAddressBook();
        new SidePanelPage(driver).deleteAddressBook();
        Assert.assertTrue(new SidePanelPage(driver).isAlertDisplayed());
    }
//regression
    @Test
    public void setDefaultShippingInAddressBookTest() {
        new SidePanelPage(driver).changeAddressBook();
        new SidePanelPage(driver).newSetShippingAddress();
        Assert.assertTrue(new SidePanelPage(driver).isBadgeDisplayed());
    }
//regression
    @Test
    public void wishListTest() {
        new SidePanelPage(driver).createNewWishList();
        Assert.assertTrue(new SidePanelPage(driver).isAlertDisplayed());
    }
}
