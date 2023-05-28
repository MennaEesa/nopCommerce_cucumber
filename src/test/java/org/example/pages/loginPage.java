package org.example.pages;

import io.cucumber.java.en.Given;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class loginPage {

    public WebElement loginlink()
    {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/login?returnUrl=%2F\"]"));
    }

    public WebElement getEmail()
    {
       return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement getPassword()
    {
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement loginBTN()
    {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));
    }

    public WebElement myAccountTap()
    {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/customer/info\"]"));

    }    public WebElement errorMessage()
    {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\""));
    }

    public void login(String email, String password) {
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        loginBTN().click();
    }
}
