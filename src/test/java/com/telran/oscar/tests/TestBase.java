package com.telran.oscar.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod

    public void init() {
        driver = new ChromeDriver();
        driver.get("http://selenium1py.pythonanywhere.com");
        driver.manage().window().maximize();
        driver.manage().timeouts();
    }


    @AfterMethod(enabled = false)
//    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}