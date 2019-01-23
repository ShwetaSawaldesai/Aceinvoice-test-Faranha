package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

 public class SignUpPageTest {

     WebDriver driver = new ChromeDriver();

     @BeforeTest

     public void before() {
         driver.get("http://staging.aceinvoice.com/sign_up");
        }

     @Test
     public void verifySignUpPageElements() {

         //Email Textbox
         boolean emailTextbox = driver.findElement(By.xpath("//input[@name=\"email\"]")).isDisplayed();
         assertTrue(emailTextbox);

         //Get Start button 
         WebElement getStartButton = driver.findElement(By.name("get_started"));
         assertTrue(getStartButton.isDisplayed());
         assertEquals(getStartButton.getAttribute("value"),"Get Started");

         //Enter Email Id 
         driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("test+" + Math.random() + "@example.com");
         driver.findElement(By.name("get_started")).click();

         //Password Label
         String password = driver.findElement(By.xpath("//div[@class=\"form-wrap\"]//div//div//div//label[@class=\"control-label email required\"]")).getText();
         assertEquals(password,"* Password");

         //Password Textbox
         boolean passwordTextbox = driver.findElement(By.xpath("//input[@name=\"password\"]")).isDisplayed();
         assertTrue(passwordTextbox);

         //Confirm Password Label
         String confirmPassword = driver.findElement(By.xpath("//div[@class=\"form-group password_confirmation required user_email\"]//label[@class=\"control-label password_confirmation required\"]")).getText();
         assertEquals(confirmPassword,"* Password Confirmation");

         //Confirm Password Textbox
         boolean confirmPasswordTextbox = driver.findElement(By.xpath("//input[@name=\"password_confirmation\"]")).isDisplayed();
         assertTrue(confirmPasswordTextbox);

         //Continue button
         WebElement continueButton = driver.findElement(By.name("continue"));
         assertTrue(continueButton.isDisplayed());
         assertEquals(continueButton.getAttribute("value"), "Continue");
    }

     @AfterTest
     public void after() {
     driver.close();
    }
}