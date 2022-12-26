package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
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

//    @FindBy(css = "#messages .btn.btn-info:nth-child(1)")
    @FindBy(css = "#messages > div:nth-child(3) .btn:nth-of-type(1)")
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

    @FindBy(xpath = "//button[contains(text(),'View basket')]")
    WebElement btnViewBasket;


    public ProductPage addBookToBasket() {
        click(bookLink);
        click(thirdImgOfBook);
        click(btnAddToBasket);
        click(dropDownArrow);
        return null;
    }

    public ProductPage addProductToBasket() {
        click(bookLink);
        click(button1AddToBasket);
        click(button5AddToBasket);
        click(btnViewBasket);
        return null;
    }

    public boolean takeDropDownMenuDisplayed() {
        return dropDownMenu.isDisplayed();
    }

    @FindBy(css = ".col-sm-6.product_main .price_color")
    WebElement priceOfBookOnPage;

    @FindBy(css = ".dropdown-menu li:nth-child(1) .price_color")
    WebElement priceOfBookOnDropDownMenu;

    @FindBy(css = ".dropdown-menu li.form-group .text-right")
    WebElement priceOfBookOnDropDownMenuTotal;


    public boolean priceComparison() {
        String generalPrice = priceOfBookOnPage.getText();
        String priceOnDropMenu = priceOfBookOnDropDownMenu.getText();
        String priceOnDropMenuTotal = priceOfBookOnDropDownMenuTotal.getText().replace("Total: ", "");

        if (generalPrice.equals(priceOnDropMenu) && priceOnDropMenu.equals(priceOnDropMenuTotal)) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }

    @FindBy(css = ".ml-0 li:nth-child(1) .btn")
    WebElement button1AddToBasket;

    @FindBy(css = ".ml-0 li:nth-child(5) .btn")
    WebElement button5AddToBasket;

    @FindBy(css = "section .col-sm-6:nth-child(1) .price_color")
    WebElement priceProduct1;

    @FindBy(css = "section .col-sm-6:nth-child(5) .price_color")
    WebElement priceProduct5;


    @FindBy(css = "#messages div:nth-child(3) strong")
    WebElement totalBasket;


    public ProductPage checkSumProductsToBasket() {
        click(button1AddToBasket);
        click(button5AddToBasket);
        checkSumAddedProducts();

        return this;
    }

    public ProductPage checkSumAddedProducts() {
        String price1 = priceProduct1.getText().replaceAll("[^\\d.]", "");
        String price5 = priceProduct5.getText().replaceAll("[^\\d.]", "");
        double priceNum1 = Double.parseDouble(price1);
        double priceNum5 = Double.parseDouble(price5);
        double totalSum = priceNum1  + priceNum5;

        String basketTotal = totalBasket.getText().replaceAll("[^\\d.]", "");

        double priceTotalBasket = Double.parseDouble(basketTotal);

        if (priceTotalBasket == totalSum  ) {
            System.out.println("true");

        } else {
            System.out.println("false");
        }
        return this;
    }
}





// .ml-0 li:nth-child(5) .btn


//    @FindBy(xpath = "//li[3] //button[contains(text(),'Add to basket')]")
//    WebElement threeBtnAddToBasket;