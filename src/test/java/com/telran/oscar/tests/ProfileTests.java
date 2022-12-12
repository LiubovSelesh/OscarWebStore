package com.telran.oscar.tests;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginPage;
import com.telran.oscar.pages.ProfilePage;
import com.telran.oscar.pages.RegisterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginAndRegisterLink();
        new LoginPage(driver).fillLoginWithValidData();
    }
//
//    @Test
//    public void deleteProfileTest() {
//        new RegisterPage(driver).clickOnAccount();
//        new ProfilePage(driver).clickOnDeleteProfile();
//        new ProfilePage(driver).fillTheFieldPassword();
//
//    }
}

