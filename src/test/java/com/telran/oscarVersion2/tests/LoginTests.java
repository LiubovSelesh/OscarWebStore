package com.telran.oscarVersion2.tests;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginPage;
import com.telran.oscar.pages.ProductPage;
import com.telran.oscar.pages.RegisterPage;
import com.telran.oscar.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{


    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginAndRegisterLink();

    }


//    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginWithValidData")
//    public void loginWithValidDataPositiveTest(String email, String password) {
//        new LoginPage(driver).fillLoginFormWithValidData(email, password);
//        new LoginPage(driver).clickOnLogout();
//      Assert.assertTrue(new ProductPage(driver).isProductPage().contains("All products"));
//
//    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginWithInvalidEmail")
    public void loginWithInvalidEmailNegativeTest(String email) {
        new LoginPage(driver).fillLoginFormInvalidData(email, "Borno1985$");

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginWithInvalidPassword")
    public void loginWithInvalidPasswordNegativeTest(String password) {
        new LoginPage(driver).fillLoginFormInvalidData("bornTina@gmail.com", password);
    }

    @Test
    public void loginDeleteTest() {
        new LoginPage(driver).fillLoginFormInvalidData("bornTina@gmail.com", "Borno1985#");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


