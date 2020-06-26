package com.bestbuy.pages;

import com.bestbuy.base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends PageBase {

    // Page Factory or Object Repository

    @FindBy(xpath = "//span[text()=\"Account\"]")
    WebElement accountButton;

    @FindBy(xpath = "//button[text()=\"Sign In\"]")
    WebElement signInFirstButton;

    @FindBy(id = "fld-e")
    WebElement emailField;

    @FindBy(id = "fld-p1")
    WebElement passwordField;

    @FindBy(xpath = "//button[text()=\"Sign In\"]")
    WebElement signInButton;

    @FindBy(xpath = "//img[@class=\"logo\"]")
    WebElement logo;

    @FindBy(xpath = "//span[@ class=\"flyBtn logged_user_name\"]")
    WebElement signInMessage;

    // Initialization the Page Object
    public AccountPage(){
        PageFactory.initElements(driver, this);
    }


    // Actions
    public boolean validateLogo(){
        return logo.isDisplayed();
    }

    public String validatePageTitle(){
        return  driver.getTitle();

    }

    public HomePage signIn(String un, String pwd){
        accountButton.click();
        signInFirstButton.click();
        emailField.sendKeys(un);
        passwordField.sendKeys(pwd);
        signInButton.click();

        return new HomePage();
    }


    public String readSignInMessage(){
        return signInMessage.getText();
    }

}
