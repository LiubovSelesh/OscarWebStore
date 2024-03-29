package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_registration-email")
    WebElement emailField;

    @FindBy(id = "id_registration-password1")
    WebElement passwordField;

    @FindBy(id = "id_registration-password2")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//button[contains(text(),'Register')]")
    WebElement registrationSubmit;

    public RegisterPage registrationUserWithValidData() {
        type(emailField, "bornTina24@gmail.com");
        type(passwordField, "Borno1985$");
        type(confirmPasswordField, "Borno1985$");
        click(registrationSubmit);
        return this;
    }

    public RegisterPage fillRegisterFormWithValidData(String password, String confirm) {
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        type(emailField, "bornTina" + i + "@gmail.com");
        type(passwordField, password);
        type(confirmPasswordField, confirm);
        click(registrationSubmit);
        return this;
    }

    public RegisterPage fillRegisterFormWithAllValidData(String email, String password, String confirm) {
        type(emailField, email );
        type(passwordField, password);
        type(confirmPasswordField, confirm);
        click(registrationSubmit);
        clickOnAccount();
        return this;
    }

      public RegisterPage fillRegisterFormInvalidEmail(String email, String password, String confirm) {
        type(emailField, email );
        type(passwordField, password);
        type(confirmPasswordField, confirm);
        click(registrationSubmit);
        return this;
    }
      public RegisterPage fillRegisterFormInvalidPassword(String email, String password, String confirm) {
        type(emailField, email );
        type(passwordField, password);
        type(confirmPasswordField, confirm);
        click(registrationSubmit);
        return this;
    }

//    @FindBy(xpath = "//h2[contains(text(),'Welcome!')]")
    @FindBy(xpath = "//h1[contains(text(),'All products')]")
    WebElement welcome;

    public boolean isRegisterDisplayed() {
        return welcome.isDisplayed();
    }

    @FindBy(id = "login_link")
    WebElement loginAndRegister;

    public boolean isLoginAndRegisterDisplayed() {
        return welcome.isDisplayed();
    }

//    @FindBy(css = ".error-block")
    @FindBy(xpath = "//strong[contains(text(),'Oops! We found some errors')]")
    WebElement errorBlock;

    public String getMessageResult() {
        return errorBlock.getText();

    }

//    @FindBy(css = ".icon-user")
    @FindBy(css = ".nav-link.mt-2")
    WebElement iconUser;

    public ProfilePage clickOnAccount() {
        iconUser.click();
        return new ProfilePage(driver);
    }
}


// //strong[contains(text(),'Oops! We found some errors')]
// .error-block
