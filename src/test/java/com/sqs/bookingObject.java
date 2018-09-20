package com.sqs;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sun.security.krb5.internal.crypto.Des;

import javax.print.attribute.standard.Destination;

public class bookingObject {

    WebDriver driver;

    private By OriginLocator = By.name("Origin");
    private By DestinationLocator = By.name("Destination");
    private By SeatLocator = By.name("seat");
    private By FlightClassLocator = By.name("Flightclass");

    //private By emailLocator = By.name("email");
    //private By passwordLocator = By.name("password");

    private By bookButtonLocator = By.xpath("/html/body/div/div/div[2]/form/button");

    private By bodyTextLocator = By.tagName("body");

    private String cloud9BookHeader = "Book Flight";
    private String bookSuccessful = "Flight booked successfully";


    public bookingObject(WebDriver driver) {

        this.driver = driver;
    }



    public void clickBook(WebDriver driver){

        //System.out.println("Click Login Button");
        driver.findElement(bookButtonLocator).click();
    }


    public void assertBookHeader(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(cloud9BookHeader));
    }


    public void assertBookSuccessful(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(bookSuccessful));
    }


    public void populateBook(String Origin, String Destination, String Seat, String FlightClass){


        assertBookHeader();
        driver.findElement(OriginLocator).sendKeys(Origin);
        driver.findElement(DestinationLocator).sendKeys(Destination);
        driver.findElement(SeatLocator).sendKeys(Seat);
        driver.findElement(FlightClassLocator).sendKeys(FlightClass);
        clickBook(driver);
        assertBookSuccessful();

    }


}
