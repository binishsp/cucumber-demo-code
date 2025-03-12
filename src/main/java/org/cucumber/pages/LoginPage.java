package org.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    //By Locators

    private By username_input_loc = By.xpath("//input[@id=\"user-name\"]");
    private By password_input_loc = By.xpath("//input[@id=\"password\"]");
    private By login_button_loc = By.xpath("//input[@id=\"login-button\"]");
    private By app_title_loc = By.xpath("//div[@class=\"app_logo\"]");

    //Constructor

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Methods

    public void enter_username(String username){
        WebElement input_username = driver.findElement(username_input_loc);
        input_username.sendKeys(username);
    }
    public void enter_password(String password){
        WebElement input_password = driver.findElement(password_input_loc);
        input_password.sendKeys(password);
    }
    public void click_login(){
        WebElement login_button =driver.findElement(login_button_loc);
        login_button.click();
    }
    public boolean checkhomepage_nav(){
        return driver.findElement(app_title_loc).isDisplayed();
    }
    public void login(String username, String password){
      enter_username(username);
      enter_password(password);
      click_login();
    }
    public String getHomepageUrl(){
       String HomepageUrl = driver.getCurrentUrl();
       return HomepageUrl;
    }
}
