package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.Random;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }


    public String getTextFromElement(By by){
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }

    @Test
    public void verifyThatSigningUpPageDisplay(){
        // Click on register button using By.xpath method
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        // Actual Requirements
        String expectedMessage = "Signing up is easy!";
        // Storing value in string to compare actual message
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));

    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        // Click on register button using By.xpath method
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //  Send  First name using By.id method
        sendTextToElement(By.id("customer.firstName"),"User");
        // Send Last name using By.id method
        sendTextToElement(By.id("customer.lastName"),"Test");
        // Send Address to address field
        sendTextToElement(By.id("customer.address.street"),"123street");
        // Send city name using By.id
        sendTextToElement(By.id("customer.address.city"),"Brisbane");
        // Send state name using By.id
        sendTextToElement(By.id("customer.address.state"),"QLD");
        // Send zipcode to zip code field
        sendTextToElement(By.id("customer.address.zipCode"),"4122");
        // Send Phone number using By id method
        sendTextToElement(By.id("customer.phoneNumber"),"1234567890");
        //Send SSN using By id method
        sendTextToElement(By.id("customer.ssn"),"123456");
        //Send username using By id method
        sendTextToElement(By.id("customer.username"),"Hello"+ Integer.toString(((new Random().nextInt(10))+1)));
        //Send password using By id method
        sendTextToElement(By.id("customer.password"),"Hello123");
        //Send confirm using By id method
        sendTextToElement(By.id("repeatedPassword"),"Hello123");
        // Click on Register button
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        // Actual Requirements
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        // Storing value in string to compare actual message
        String actualMessage = getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        // Validate actual and expected message
        Assert.assertEquals("Your account was not created",expectedMessage, actualMessage);

    }


    @After
    public void testDown(){
        //closeBrowser();
    }

}