package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase {

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

    public RegisterPage fillRegisterFormWithValidData() {
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        type(emailField, "bornTina" + i + "@gmail.com");
        type(passwordField, "BPRno1456$");
        type(confirmPasswordField, "BPRno1456$");
        click(registrationSubmit);
        return this;
    }

    public RegisterPage fillRegisterFormWithAllValidData(String email, String password, String confirm) {
        type(emailField, email );
        type(passwordField, password);
        type(confirmPasswordField, confirm);
        click(registrationSubmit);
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

    @FindBy(xpath = "//h2[contains(text(),'Welcome!')]")
    WebElement welcome;

    public boolean isRegisterDisplayed() {
        return welcome.isDisplayed();
    }

    @FindBy(css = ".error-block")
    WebElement errorBlock;

    public String getConfirmResult() {
        return errorBlock.getText();

    }

    @FindBy(css = ".icon-user")
    WebElement iconUser;

    public ProfilePage clickOnAccount() {
        iconUser.click();
        return new ProfilePage(driver);
    }
}


// //strong[contains(text(),'Oops! We found some errors')]
// .error-block
