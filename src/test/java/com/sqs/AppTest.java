package com.sqs;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest
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
    public void shouldRegisterNewCustomer() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/form/center/a")).click();
        driver.findElement(By.name("firstname")).sendKeys("James");
        driver.findElement(By.name("lastname")).sendKeys("Toal");
        driver.findElement(By.name("email")).sendKeys("jtoal4368@sqs.com");
        driver.findElement(By.name("password")).sendKeys("Password123");
        driver.findElement(By.xpath("html/body/div/form/button")).click();

        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(registrationSuccessful));

        Thread.sleep(10000);

    }


    @Test
    public void shouldLoginCustomer() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys("jtoal@sqs.com");
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Password123");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        Thread.sleep(5000);

    }


    @After
    public void tearDown()
    {
       driver.close();
    }

}
