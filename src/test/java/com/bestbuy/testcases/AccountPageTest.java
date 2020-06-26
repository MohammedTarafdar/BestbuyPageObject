package com.bestbuy.testcases;

import com.bestbuy.base.PageBase;
import com.bestbuy.pages.AccountPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountPageTest extends PageBase {

    AccountPage accountPage;

    public AccountPageTest(){
        super();
    }


    @BeforeMethod
    public void setUp(){
        initialization();

        accountPage = new AccountPage();
    }


    @Test(priority = 1)
    public void validateLogoTest(){
        boolean status = accountPage.validateLogo();
        Assert.assertTrue(status);
    }

    @Test(priority = 2)
    public void validatePageTitleTest() {
        String title =accountPage.validatePageTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Best Buy | Official Online Store | Shop Now & Save");

    }

    @Test(priority = 3)
    public void signInTest(){
        accountPage.signIn(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test(priority = 4)
    public void readSignInMessageTest(){
        accountPage.signIn(prop.getProperty("email"), prop.getProperty("password"));
        String message = accountPage.readSignInMessage();
        System.out.println(message);
       Assert.assertEquals(message, "Hi, Mohammed");
    }

        @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
