package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/"; // Assigning the URL

    @Before
    public void setUp() { // Opening the browser
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Locating the Username element and sending the value to it
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        // Locating the Password element and sending the value to it
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        // Locating the Login button and applying the click operation on it
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedMessage = "Dashboard";
        WebElement actualTextElement = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage); // Comparing both messages
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        // Locating the Forgot password element and applying the click operation on it
        driver.findElement(By.xpath("//p[text()='Forgot your password? ']")).click();
        // Verifying Upon clicking on the "Forgot your password" link, the "Reset Password" text is displayed or not
        String expectedMessage = "Reset Password";
        // Locating the actual message
        WebElement actualTextElement = driver.findElement(By.xpath("//h6[text()='Reset Password']"));
        // Storing the actual message into String type variable
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage); // Comparing the messages
    }

    @After
    public void cutOff() { // Closing the browser
        closeBrowser();
    }
}
