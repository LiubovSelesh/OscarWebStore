package com.telran.oscar.tests;

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
        new RegisterPage(driver).fillRegisterFormWithValidData();
        Assert.assertTrue(new RegisterPage(driver).isRegisterDisplayed());
    }
//smoky
    @Test(dataProviderClass = DataProviders.class, dataProvider = "registrationFormWithValidData")
    public void registrationWithValidDataTest(String email, String password, String confirm) {
        new RegisterPage(driver).fillRegisterFormWithAllValidData(email, password, confirm);
        Assert.assertTrue(new RegisterPage(driver).isAccountDisplayed());
    }
// negativeTests
    @Test(dataProviderClass = DataProviders.class, dataProvider = "registrationWithInvalidEmail")
    public void registrationWithInvalidEmailNegativeTest(String email) {
        new HomePage(driver).clickOnLoginAndRegisterLink();
        new RegisterPage(driver).fillRegisterFormInvalidEmail(email, "Borno1985$", "Borno1985$");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registrationWithInvalidPassword")
    public void registrationWithInvalidPasswordNegativeTest(String password, String confirm) {
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        String email = "kara" + i + "@gmail.com";
        new RegisterPage(driver).fillRegisterFormInvalidPassword(email, password, confirm);
    }
    @Test(dataProviderClass = DataProviders.class, dataProvider = "registrationWithInvalidConfirm")
    public void registrationWithInvalidConfirmNegativeTest(String password, String confirm) {
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        String email = "kara" + i + "@gmail.com";
        new RegisterPage(driver).fillRegisterFormInvalidPassword(email, password, confirm);
        Assert.assertTrue(new RegisterPage(driver).getConfirmResult().contains("password fields didn't match."));
    }



}
