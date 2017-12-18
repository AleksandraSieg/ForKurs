package com.b2b;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement signIn;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement enterLogin;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement enterPassword;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
    private WebElement signIn2;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul")
    private WebElement clothes;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[3]/div[2]/div[2]")
    private WebElement numberOfElements;

    public void clickButtonSignIn(){
        signIn.click();
    }

    public void enterLogin(){
        enterLogin.sendKeys("b2bnetworkwarszawa@gmail.com");
    }

    public void enterPassword(){
        enterPassword.sendKeys("n3tw0rk2017");
    }

    public void clickSignIn(){
        signIn2.click();
    }

    public int countPictures(){

        int count = 0;

        for (WebElement li : clothes.findElements(By.tagName("li"))) {
            if(li.getCssValue("display").equals("list-item")){
                count++;
            }
        }

        return count;
    }

    public int expectedNumberOfElements(){
        String text = numberOfElements.getText();

        String[] tab = text.split(" ");

        int expected = Integer.parseInt(tab[tab.length-2]);

        return expected;

    }
}
