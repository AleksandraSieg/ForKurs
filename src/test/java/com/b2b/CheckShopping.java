package com.b2b;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckShopping {

    private static WebDriver webDriver;
    private LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);

    @BeforeClass
    public static void init(){
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void test(){
        webDriver.get("http://automationpractice.com/index.php");
        loginPage.clickButtonSignIn();
        loginPage.enterLogin();
        loginPage.enterPassword();
        loginPage.clickSignIn();

        Assert.assertEquals("jestes gupi", "http://automationpractice.com/index.php?controller=my-account",
        webDriver.getCurrentUrl());
    }

    @Test
    public void test2(){
        webDriver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
        int i = loginPage.expectedNumberOfElements();
        int j = loginPage.countPictures();

        Assert.assertEquals("jestes gupi", i, j);
    }




}
