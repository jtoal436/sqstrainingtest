package com.sqs;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.xml.ws.handler.LogicalHandler;

/**
 * Unit test for simple App.
 */
public class AppTestA
{
    static WebDriver driver;
    private String registrationSuccessful = "Registration Successful";
    private By bodyTextLocator = By.tagName("body");
    private String cloud9RegisterHeader = "Cloud9 - Register";



    @Before
    public void testSetup()
    {
        System.out.println("In testSetup ");
        //System.setProperty("ChromeDriver", "C:\\Drivers\\chromedriver");
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseUrl = "http://10.9.10.39:81/sqlite/Main/login.html";
        String expectedTitle = "Cloud9 Airlines";
        driver.get(baseUrl);
        String actualTitle = driver.getTitle();
        System.out.println("Actual title is: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);


    }

    @BeforeClass
    public static void browserSetup()
    {



    }


    @Test
    public void shouldRegisterNewCustomer() {

        driver.findElement(By.linkText("Register")).click();

        registrationObject registrationPage;
        registrationPage = new registrationObject(driver);
        registrationPage.populateRegistration("James", "Toal", "jtoal4361@sqs.com", "Password123");

    }


    @Test
    public void shouldLoginCustomer() throws InterruptedException {

       //driver.findElement(By.linkText("Sign in")).click();

        loginObject loginPage;
        loginPage = new loginObject(driver);
        loginPage.populateLogin("jtoal436@sqs.com", "Password123");
    Thread.sleep(10000);


    }


    @Test
    public void bookFlight() throws InterruptedException {


        loginObject loginPage;
        loginPage = new loginObject(driver);
        loginPage.populateLogin("jtoal436@sqs.com", "Password123");

        driver.findElement(By.linkText("Homepage")).click();

        driver.findElement(By.linkText("Book Flight")).click();

        bookingObject bookPage;
        bookPage = new bookingObject(driver);
        bookPage.populateBook("Durban", "London", "c23", "First");

        Thread.sleep(5000);

    }

    public void itinerary() throws InterruptedException {

        loginObject loginPage;
        loginPage = new loginObject(driver);
        loginPage.populateLogin("jtoal436@sqs.com", "Password123");

        driver.findElement(By.linkText("Homepage")).click();

        driver.findElement(By.linkText("Itinerary")).click();


        itineraryObject itineraryPage;
        itineraryPage = new itineraryObject(driver);
        itineraryPage.scanBookingsAndClickUpdate("22");

        Thread.sleep(5000);


    }

    @After
    public void tearDown()
    {
       driver.close();
    }


}
