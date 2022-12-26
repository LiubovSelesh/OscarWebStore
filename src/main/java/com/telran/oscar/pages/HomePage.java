package com.telran.oscar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class HomePage extends BasePage {
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

    @FindBy(css = ".form-group.mb-0")
    WebElement languageSelect;




    public boolean isLanguageDisplayed() {
        System.out.println("DropDown British");
        return languageSelect.isDisplayed();
    }
    @FindBy(css = ".btn.btn-outline-secondary.ml-2")
    WebElement btnGo;

    public boolean isBtnGoDisplayed() {
        System.out.println("Button Go is present: " + btnGo.getText());
        return btnGo.isDisplayed();
    }
    @FindBy(xpath = "//a[contains(text(),'Oscar')]")
    WebElement logo;

    public boolean isLogoOscarDisplayed() {
        System.out.println("Logo is present " + logo.getText());
        return logo.isDisplayed();
    }

    @FindBy(xpath = "//small[contains(text(),'Sandbox')]")
    WebElement logoSandBox;

    public boolean isLogoSandboxDisplayed() {
        System.out.println("Logo is present " + logoSandBox.getText());
        return logoSandBox.isDisplayed();
    }

    @FindBy(xpath = "//strong[contains(text(),'Basket total:')]")
    WebElement logoBasketTotal;

    public boolean isLogoBasketTotalDisplayed() {
        System.out.println("Logo Basket total is present " + logoBasketTotal.getText());
        return logoBasketTotal.isDisplayed();
    }

//    @FindBy(xpath = "//button[contains(text(),'View basket')]")
    @FindBy(css = ".btn-group .btn.btn-outline-secondary:nth-child(1)")
    WebElement viewBasketBtn;

    public boolean isBtnViewBasketDisplayed() {
        System.out.println("Button view basket total is present: " + viewBasketBtn.getText());
        return viewBasketBtn.isDisplayed();
    }

    @FindBy(css = ".nav.nav-list.flex-column")
    WebElement navList;

    public boolean isSidePanelDisplayed() {
        System.out.println("Side panel is present: " + navList.getText());
        return navList.isEnabled();
    }


    @FindBy(css = ".row.list-unstyled.ml-0.pl-0")
    WebElement listWithProduct;

    public boolean isListWithProductDisplayed() {
        System.out.println("List with product is present: " + listWithProduct.isDisplayed());
        return listWithProduct.isEnabled();
    }

    @FindBy(css = ".row.list-unstyled li:nth-child(1) img")
    WebElement firstImgOfBook;

    @FindBy(css = ".row.list-unstyled li:nth-child(6) img")
    WebElement sixImgOfBook;

    @FindBy(css = ".row.list-unstyled li:nth-child(20) img")
    WebElement twentyImgOfBook;

    public boolean isBookDisplayed() {
        System.out.println("is element Present: " + firstImgOfBook.isDisplayed());
        System.out.println("is element Present: " + sixImgOfBook.isDisplayed());
        System.out.println("is element Present: " + twentyImgOfBook.isDisplayed());

        return firstImgOfBook.isDisplayed() && sixImgOfBook.isDisplayed() && twentyImgOfBook.isDisplayed();
    }

    @FindBy(css = ".row.list-unstyled li:nth-child(1) .star-rating ")
    WebElement firstStars;

    @FindBy(css = ".row.list-unstyled li:nth-child(7) .star-rating ")
    WebElement sevenStars;

    @FindBy(css = ".row.list-unstyled li:nth-child(18) .star-rating ")
    WebElement eighteenStars;

    public boolean isStarsDisplayed() {
        System.out.println("is element Present: " + firstStars.isDisplayed());
        System.out.println("is element Present: " + sevenStars.isDisplayed());
        System.out.println("is element Present: " + eighteenStars.isDisplayed());
        return firstStars.isDisplayed() && sevenStars.isDisplayed() && eighteenStars.isDisplayed();
    }

    @FindBy(xpath = "//li[1] //button[contains(text(),'Add to basket')]")
    WebElement firstBtnAddToBasket;

    @FindBy(xpath = "//li[6] //button[contains(text(),'Add to basket')]")
    WebElement sixBtnAddToBasket;

    @FindBy(xpath = "//li[20] //button[contains(text(),'Add to basket')]")
    WebElement twentyBtnAddToBasket;

    public boolean isAddToBasketDisplayed() {
        System.out.println("is element Present: " + firstBtnAddToBasket.isDisplayed());
        System.out.println("is element Present: " + sixBtnAddToBasket.isDisplayed());
        System.out.println("is element Present: " + twentyBtnAddToBasket.isDisplayed());
        return firstBtnAddToBasket.isDisplayed() && sixBtnAddToBasket.isDisplayed() && twentyBtnAddToBasket.isDisplayed();
    }

    public HomePage addItemToBasket(int number) {
        driver.findElement(By.cssSelector(".col-sm-6:nth-child(" +  number + ") .btn")).click();
        return this;
    }

    public BasketPage clickOnViewBasketButton() {
        click(viewBasketBtn);
        return new BasketPage(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> links;

    public HomePage checkAllLinks() {
        System.out.println("Total links on the WebPage: " + links.size());
        String url = "";
        Iterator<WebElement> iterator = links.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println("url " + url);
        }
        return this;
    }

    @FindBy(tagName = "a")
    List<WebElement> brokenLinks;
    public HomePage checkBrokenLinks() {
            for (int i = 0; i < brokenLinks.size(); i++) {
                WebElement element = brokenLinks.get(i);
                String url = element.getAttribute("href");
                verifyLinks(url);
            }
            return this;
        }

    public void verifyLinks(String urlLink) {
        URL url = null;
        try {
            url = new URL(urlLink);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            httpURLConnection.setConnectTimeout(2000);
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode() >= 400) {
                System.out.println(urlLink + " - " + httpURLConnection.getResponseMessage() + "is broken link");
            } else {
                System.out.println(urlLink + " - " + httpURLConnection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(urlLink + " - " + e.getMessage() + "is broken link");
        }
    }
}



