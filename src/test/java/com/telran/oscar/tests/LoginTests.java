package com.telran.oscar.tests;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginPage;
import com.telran.oscar.pages.RegisterPage;
import com.telran.oscar.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginAndRegisterLink();

    }

    @Test
    public void loginTest() {
        new LoginPage(driver).fillLoginWithValidData();
//        Assert.assertTrue(new RegisterPage(driver).isRegisterDisplayed());
        Assert.assertTrue(new LoginPage(driver).isLoginDisplayed());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginWithValidData")
    public void loginWithValidDataTest(String email, String password) {
        new LoginPage(driver).fillLoginFormWithValidData(email, password);
        Assert.assertTrue(new RegisterPage(driver).isRegisterDisplayed());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginWithInvalidEmail")
    public void loginWithInvalidEmailTest(String email) {
        new LoginPage(driver).fillLoginFormInvalidData(email, "Borno1985$");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginWithInvalidPassword")
    public void loginWithInvalidPasswordTest(String password) {
        new LoginPage(driver).fillLoginFormInvalidData("bornTina@gmail.com", password);
    }

    @Test
    public void loginDeleteTest(String password) {
        new LoginPage(driver).fillLoginFormInvalidData("bornTina@gmail.com", "Borno1985#");
    }
}
