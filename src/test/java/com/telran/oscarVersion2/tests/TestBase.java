package com.telran.oscarVersion2.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod

    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x800");
        driver = new ChromeDriver(options);
//        driver = new ChromeDriver();
        driver.get("https://latest.oscarcommerce.com");
        driver.manage().window().maximize();
        driver.manage().timeouts();
    }


    @AfterMethod(enabled = false)
//    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}