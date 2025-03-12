package org.cucumber.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.cucumber.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginStepDef {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        driver =new ChromeDriver();
    }
    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
    @Given("Im already in the login page")
    public void im_already_in_the_login_page(){
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }
   @Given("I have entered valid credentials")
    public void i_have_entered_the_valid_credentials(){
        loginPage.enter_username("standard_user");
        loginPage.enter_password("secret_sauce");
   }

   @Given("I have entered an invalid {string} and {string}")
   public void i_have_entered_an_invalid_credentials(String username, String password){
        loginPage.enter_username(username);
        loginPage.enter_password(password);

    }
   @When("I click on the Login button")
    public void i_click_the_login_button(){
        loginPage.click_login();
   }
   @Then("I should see the home page")
    public void i_should_see_the_home_page(){
       Assert.assertEquals(loginPage.checkhomepage_nav(),true);
   }
   @Then("I should see the error message indicating {string}")
    public void i_should_see_the_error_message_indicating_error_message(String error_message){
        Assert.assertEquals(driver.findElement(By.xpath("//button[@class=\"error-button\"]")).isDisplayed(),true);
   }
}
