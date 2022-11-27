package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }


    public String getTextFromElement(By by){
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }
    /* I have tried registering with valid username and password after completing the register details
     still i am unable to perform test for valid username and password due to some issue and showing error
    An internal error has occurred and has been logged. hence i could not perform the Test for user should
    login with valid user name and password.

    */
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter valid username in user name field using by name method
        sendTextToElement(By.name("username"), "brisbane");
        //Enter valid password in password field using by name method
        sendTextToElement(By.name("password"), "brisbane123");
        // Click on Login button using click method
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        // Verify text Error! is displayed
        // Actual Requirements
        String expectedMessage = "Your account was created successfully. You are now logged in.!";
        // Storing value in string to compare actual message
        String actualMessage = getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        // Validate actual and expected message
        Assert.assertEquals("No Your account was not created successfully. You are not logged in.", expectedMessage, actualMessage);

    }
        @Test

    public void verifyTheErrorMessage(){
        // Enter valid username in user name field using by name method
        sendTextToElement(By.name("username"),"Hello");
        //Enter valid password in password field using by name method
        sendTextToElement(By.name("password"),"Hello123");
        // Click on Login button using click method
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        // Verify text Error! is displayed
        // Actual Requirements
        String expectedMessage1 = "Error!";
        // Storing value in string to compare actual message
        String actualMessage1 = getTextFromElement(By.xpath("//h1[contains(text(),'Error!')]"));
        // Validate actual and expected message
        Assert.assertEquals("Error message was not found",expectedMessage1, actualMessage1);


    }

    @Test
    public void userShouldLogOutSuccessfully(){
        // Enter valid username in user name field using by name method
        sendTextToElement(By.name("username"),"Hello");
        //Enter valid password in password field using by name method
        sendTextToElement(By.name("password"),"Hello123");
        // Click on Login button using click method
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        // Click on Log out using click method
        clickOnElement(By.xpath("//a[text()='Log Out']"));
        // Verify text Customer Login! is displayed
        // Actual Requirements
        String expectedMessage1 = "Customer Login";
        // Storing value in string to compare actual message
        String actualMessage1 = getTextFromElement(By.xpath("//h1[contains(text(),'Error!')]"));
        // Validate actual and expected message
        Assert.assertEquals("Customer Login message was not found",expectedMessage1, actualMessage1);
    }

    @After
    public void testDown(){
        closeBrowser();
    }

}