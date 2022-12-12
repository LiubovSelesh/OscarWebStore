package com.telran.oscar.pages;

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
}

