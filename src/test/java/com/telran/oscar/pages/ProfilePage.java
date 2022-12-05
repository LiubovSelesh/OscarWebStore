package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "delete_profile")
    WebElement deleteProfile;

    public ProfilePage clickOnDeleteProfile() {
        deleteProfile.click();
        return this;
    }


    @FindBy(id = "id_password")
    WebElement passwordField;

    @FindBy(css = "[data-loading-text='Deleting...']")
    WebElement deleteButton;


    public ProfilePage fillTheFieldPassword() {
        type(passwordField, "Borno1985$");
        click(deleteButton);
        return this;
    }
}

//#
//#id_password
//  [data-loading-text='Deleting...']