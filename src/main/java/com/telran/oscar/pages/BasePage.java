package com.telran.oscar.pages;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text){
        if (text != null) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void clickWithAction(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element.click();
    }

    public void shouldHaveText(WebElement element, String text, int time) {
        new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshot(String pathToFile) {
        File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(pathToFile);

        try {
            Files.copy(tmp, screenshot);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean isElementPresent(List<WebElement> element) {
        return element.size() > 0;
    }

    public void should(WebElement element, int time) {
        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
    }

    @FindBy(css = ".nav-link.mt-2.mt-lg-0")
    WebElement logoAccount;

    public boolean isAccountDisplayed() {
        return logoAccount.isDisplayed();
    }


}
