package com.telran.oscar.tests;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.ProductPage;
import com.telran.oscar.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {


    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginAndRegisterLink();
        new RegisterPage(driver).fillRegisterFormWithValidData();

    }
    //smoky
    @Test
    public void openHomePage() {
        System.out.println("Opened home page");
    }
    //smoky
    @Test
    public void userCanSelectItemMenu() {
        new HomePage(driver).selectCategory();
        Assert.assertTrue(new ProductPage(driver).isProductPage().contains("All products"));
    }

}
