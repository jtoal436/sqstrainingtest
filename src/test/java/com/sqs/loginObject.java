package com.sqs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginObject {


    WebDriver driver;


    private By emailLocator = By.name("email");
    private By passwordLocator = By.name("password");

    private By loginButtonLocator = By.xpath("/html/body/div/form/button");
    private By bodyTextLocator = By.tagName("body");

    private String cloud9LoginHeader = "Cloud9 - Sign in";
    private String loginSuccessful = "Welcome James";



    public loginObject(WebDriver driver) {

        this.driver = driver;
    }



    public void clickLogin(WebDriver driver){

        //System.out.println("Click Login Button");
        driver.findElement(loginButtonLocator).click();
    }



    public void assertLoginHeader(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(cloud9LoginHeader));
    }


    public void assertLoginSuccessful(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(loginSuccessful));
    }


    public void populateLogin(String emailAddress, String password){

        assertLoginHeader();
        driver.findElement(emailLocator).sendKeys(emailAddress);
        driver.findElement(passwordLocator).sendKeys(password);
        clickLogin(driver);
        assertLoginSuccessful();
    }




}
