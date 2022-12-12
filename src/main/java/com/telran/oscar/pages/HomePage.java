package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login_link")
    WebElement loginLink;

    public RegisterPage clickOnLoginAndRegisterLink() {

        click(loginLink);
        return new RegisterPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'All products')]")
    WebElement allProducts;



    public ProductPage selectCategory() {
        click(allProducts);
        return new ProductPage(driver);
    }
}




// //h2[contains(text(),'Welcome!')]
