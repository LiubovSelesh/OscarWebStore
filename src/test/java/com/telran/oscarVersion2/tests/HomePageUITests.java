package com.telran.oscarVersion2.tests;

import com.telran.oscar.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class HomePageUITests extends TestBase {

    @Test
    public void elementDropDownWithLanguagePresent() {
        Assert.assertTrue(new HomePage(driver).isLanguageDisplayed());
    }

    @Test
    public void elementButtonGoPresent() {
        Assert.assertTrue(new HomePage(driver).isBtnGoDisplayed());
    }

    @Test
    public void logoOscarPresent() {
        Assert.assertTrue(new HomePage(driver).isLogoOscarDisplayed());
    }

    @Test
    public void logoSandboxPresent() {
        Assert.assertTrue(new HomePage(driver).isLogoSandboxDisplayed());
    }


    @Test
    public void logoBasketTotalPresent() {
        Assert.assertTrue(new HomePage(driver).isLogoBasketTotalDisplayed());
    }

    @Test
    public void BtnViewBasketPresent() {
        Assert.assertTrue(new HomePage(driver).isBtnViewBasketDisplayed());
    }

    @Test
    public void sidePanelPresent() {
        Assert.assertTrue(new HomePage(driver).isSidePanelDisplayed());
    }

    @Test
    public void listWithProductPresent() {
        Assert.assertTrue(new HomePage(driver).isListWithProductDisplayed());
    }


    @Test
    public void elementBookPresent() {
        Assert.assertTrue(new HomePage(driver).isBookDisplayed());
    }

    @Test
    public void elementStarsPresent() {
        Assert.assertTrue(new HomePage(driver).isStarsDisplayed());
    }

    @Test
    public void elementAddToBasketPresent() {
        Assert.assertTrue(new HomePage(driver).isAddToBasketDisplayed());
    }

    @Test
    public void checkLinks() {
//        new HomePage(driver).checkAllLinks(); //.checkBrokenLinks();
        new HomePage(driver).checkAllLinks().checkBrokenLinks();
    }


//    @AfterMethod(enabled = false)
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
