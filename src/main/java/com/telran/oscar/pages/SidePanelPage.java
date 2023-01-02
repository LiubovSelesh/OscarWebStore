package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends BasePage{
    public SidePanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".nav-item:nth-child(3)")
    WebElement addressBook;


    @FindBy(css = ".btn-group .btn.btn-secondary:nth-child(1)")
    WebElement editBtn;

    @FindBy(id = "id_line1")
    WebElement address;

    @FindBy(css = ".offset-sm-4 .btn ")
    WebElement saveBtn;

    public SidePanelPage changeAddressBook() {
        click(addressBook);
        click(editBtn);
        click(address);
        address.clear();
        type(address, "Frankfurter Allee" );
        click(saveBtn);
        return this;
    }

    @FindBy(css = ".alertinner")
    WebElement updateAddressMessage;

    public boolean isAlertDisplayed() {
        System.out.println(updateAddressMessage.getText());
        return updateAddressMessage.isDisplayed();
    }


    @FindBy(css = ".btn.btn-secondary.dropdown-toggle")
    WebElement arrow;

    @FindBy(css = ".table .dropdown-menu a:nth-child(1)")
    WebElement deleteSelect;

    @FindBy(css = ".btn.btn-danger")
    WebElement deleteBtn;


    public SidePanelPage deleteAddressBook() {
        click(arrow);
        click(deleteSelect);
        click(deleteBtn);
        return this;
    }

    @FindBy(css = ".table .dropdown-menu a:nth-child(2)")
    WebElement setAsDefaultShippingAddress;


    public SidePanelPage newSetShippingAddress() {
        click(arrow);
        click(setAsDefaultShippingAddress);
        return this;
    }

    @FindBy(css = ".badge")
    WebElement badge;

    public boolean isBadgeDisplayed() {
        System.out.println(badge.getText());
        return badge.isDisplayed();
    }

    @FindBy(css = ".nav-item a.nav-link.active")
    WebElement profileLink;

    @FindBy(css = ".btn-primary:nth-child(4)")
    WebElement changePasswordBtn;

    @FindBy(id = "id_old_password")
    WebElement oldPassword;

    @FindBy(id = "id_new_password1")
    WebElement newPassword;

    @FindBy(id = "id_new_password2")
    WebElement newConfirm;

    @FindBy(css = ".btn.btn-lg")
    WebElement BtnSave;

    public SidePanelPage changeAPasswordInProfile(String password, String passwordNew, String confirmNew) {
        click(profileLink);
        click(changePasswordBtn);
        type(oldPassword, password);
        type(newPassword, passwordNew);
        type(newConfirm, confirmNew);
        click(BtnSave);
        return this;
    }

    @FindBy(css = ".alertinner")
    WebElement passwordUpdate;

    public boolean isAlertPasswordDisplayed() {
        System.out.println(passwordUpdate.getText());
        return passwordUpdate.isDisplayed();
    }

    @FindBy(css = ".btn-primary:nth-child(5)")
    WebElement editProfile;

    @FindBy(id = "id_first_name")
    WebElement firstName;

    @FindBy(id = "id_last_name")
    WebElement lastName;

    public SidePanelPage editProfile(String name, String surName) {
        click(editProfile);
        type(firstName, name);
        type(lastName, surName);
        click(BtnSave);
        return this;
    }

    @FindBy(css = "tr:nth-child(1) > td")
    WebElement newName;

    public boolean isNewNameDisplayed() {
        System.out.println(newName.getText());
        return newName.isDisplayed();
    }

    @FindBy(css = ".nav-item:nth-child(7) > .nav-link")
    WebElement wishListLink;

    @FindBy(css = ".btn-primary:nth-child(1)")
    WebElement creteNewWishList;

    @FindBy(id = "id_name")
    WebElement nameWishList;

    public SidePanelPage createNewWishList() {
        click(wishListLink);
        click(creteNewWishList);
        nameWishList.clear();
        type(nameWishList, "My Wish List");
        click(BtnSave);
        return this;
    }
}
