package com.telran.oscar.tests;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginPage;
import com.telran.oscar.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginAndRegisterLink();

    }

    @Test
    public void loginTest() {
        new LoginPage(driver).fillLoginWithValidData();
        Assert.assertTrue(new RegisterPage(driver).isRegisterDisplayed());
    }
}


