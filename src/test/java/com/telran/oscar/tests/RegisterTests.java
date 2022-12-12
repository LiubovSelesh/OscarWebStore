package com.telran.oscar.tests;

import com.telran.oscar.data.UserData;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.RegisterPage;
import com.telran.oscar.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTests extends TestBase {


    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginAndRegisterLink();

    }
//smoky
    @Test
    public void registrationUserWithValidDataTest() {
        new RegisterPage(driver).registrationUserWithValidData();
        Assert.assertTrue(new RegisterPage(driver).isRegisterDisplayed());
    }

//smoky
    @Test
    public void newUserRegistrationWithValidDataTest() {
        new RegisterPage(driver).fillRegisterFormWithValidData(UserData.USER_REG_PASSWORD, UserData.USER_REG_PASSWORD);
        Assert.assertTrue(new RegisterPage(driver).isRegisterDisplayed());
    }
//smoky

}
