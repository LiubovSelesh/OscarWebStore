package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
        System.out.println(updateAddressMessage);
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

//        Select select = new Select(deleteSelect);
//        select.selectByVisibleText(text);
//        System.out.println(select.getFirstSelectedOption().getText() + " <----It is first");

//        List<WebElement> options = select.getOptions();
//        for (int i = 0; i < options.size(); i++){
//            System.out.println(options.get(i).getText());
//        }
//        return this;

        return this;
    }
}
