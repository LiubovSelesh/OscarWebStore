package com.telran.oscar.pages;

import com.telran.oscar.data.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class ProductPage extends PageBase{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".page-header")
    WebElement titleAllProducts;

    public String isProductPage() {
        return titleAllProducts.getText();
    }

    @FindBy(css = ".page section .row li:nth-child(1) img")
    WebElement titleBook;

    @FindBy(css = "[value='Add to basket']")
    WebElement addToBasketBtn;

    @FindBy(css = "#messages .btn.btn-info:nth-child(1)")
    WebElement viewBasketButton;

    public ProductPage clickOnBook() {
        click(titleBook);
        click(addToBasketBtn);
        pause(500);
        click(viewBasketButton);
        return this;
    }



    @FindBy(css = "section li:nth-child(1) .btn")
    WebElement btnSubmit;

    public ProductPage clickOnBtnAddToBasket() {
        click(btnSubmit);
        clickWithAction(viewBasketButton);
        return this;
    }

    @FindBy(css = ".side_categories .nav.nav-list > li:nth-child(2) > a")
    WebElement bookLink;

    @FindBy(css = ".row.list-unstyled li:nth-child(1) img")
    WebElement firstImgOfBook;

    @FindBy(id = "write_review")
    WebElement btnWriteAReview;

    @FindBy(id = "id_title")
    WebElement titleReview;

    @FindBy(css = ".reviewrating .star-rating i:nth-child(5)")
    WebElement scoreWithStars;

    @FindBy(xpath = "//textarea[@id='id_body']")
    WebElement bodyField;

    @FindBy(id = "id_name")
    WebElement nameField;

    @FindBy(id = "id_email")
    WebElement emailField;

    @FindBy(xpath = "//button[contains(text(),'Save review')]")
    WebElement btnSaveReview;



    public ProductPage addReviewToBook() {
        click(bookLink);
        click(firstImgOfBook);
        click(btnWriteAReview);
        click(titleReview);
        titleReview.sendKeys("Nice book");
        click(scoreWithStars);
        click(bodyField);
        bodyField.sendKeys("I really like this book");
//        click(nameField);
//        nameField.sendKeys("Tina");
//        click(emailField);
//        emailField.sendKeys("bornTina58@gmail.com");
        click(btnSaveReview);
        return this;
    }


    @FindBy(css = ".alertinner.wicon")
    WebElement alertThanksForReview;

    public String   takeAlertDisplayed() {
        return alertThanksForReview.getText();

    }


    public ProductPage addReviewToBookWithRegistrationUser() {
        click(bookLink);
        click(firstImgOfBook);
        click(btnWriteAReview);
        click(titleReview);
        titleReview.sendKeys("Nice book");
        click(scoreWithStars);
        click(bodyField);
        bodyField.sendKeys("I really like this book");
        click(nameField);
        nameField.sendKeys("Tina");
        click(emailField);
        emailField.sendKeys("bornTina58@gmail.com");
        click(btnSaveReview);
        return this;
    }




    @FindBy(css = ".row.list-unstyled li:nth-child(3) img")
    WebElement thirdImgOfBook;

    @FindBy(xpath = "//button[contains(text(),'Add to basket')]")
    WebElement btnAddToBasket;

    @FindBy(css = ".btn.btn-outline-secondary.dropdown-toggle")
    WebElement dropDownArrow;

    @FindBy(css = ".dropdown-menu.dropdown-menu-right.show")
    WebElement dropDownMenu;


    public ProductPage addBookToBasket() {
        click(bookLink);
        click(thirdImgOfBook);
        click(btnAddToBasket);
        click(dropDownArrow);
        return null;
    }

    public boolean takeDropDownMenuDisplayed() {
        return dropDownMenu.isDisplayed();
    }


}








//    @FindBy(xpath = "//li[3] //button[contains(text(),'Add to basket')]")
//    WebElement threeBtnAddToBasket;