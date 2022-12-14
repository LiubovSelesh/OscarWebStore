package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_login-username")
    WebElement loginUsername;

    @FindBy(id = "id_login-password")
    WebElement loginPassword;

    @FindBy(xpath = "//button[contains(text(),'Log In')]")
    WebElement buttonLogIn;

    public LoginPage fillLoginWithValidData() {
        type(loginUsername,"bornTina24@gmail.com");
        type(loginPassword, "Borno1985$");
        click(buttonLogIn);
        return this;
    }


    @FindBy(xpath = "//h2[contains(text(),'Welcome!')]")
    WebElement welcome;

    public boolean isLoginDisplayed() {
        return welcome.isDisplayed();
    }

    public LoginPage fillLoginFormWithValidData(String email, String password) {
        type(loginUsername,email);
        type(loginPassword, password);
        click(buttonLogIn);
        return this;
    }


    public LoginPage fillLoginFormInvalidData(String email, String password) {
        type(loginUsername, email );
        type(loginPassword, password);
        click(buttonLogIn);
        return this;
    }

    @FindBy(id = "logout_link")
    WebElement logOut;

    public LoginPage clickOnLogout() {
        click(logOut);
        return this;
    }
}


