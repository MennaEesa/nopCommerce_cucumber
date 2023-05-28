package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class registerPage {
    public WebElement registerlink()
    {
        return Hooks.driver.findElement(By.className("ico-register"));
    }

    public WebElement selectGender()
    {
        return Hooks.driver.findElement(By.id("gender-female"));
    }

    public WebElement getFirstName()
    {
        return Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement getLastName()
    {
        return Hooks.driver.findElement(By.id("LastName"));
    }

    public WebElement getDay()
    {
        return Hooks.driver.findElement(By.name("DateOfBirthDay"));
    }

    public WebElement getMonth()
    {
        return Hooks.driver.findElement(By.name("DateOfBirthMonth"));
    }

    public WebElement getYear()
    {
        return Hooks.driver.findElement(By.name("DateOfBirthYear"));
    }

    public WebElement getEmail()
    {
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement clickRegister()
    {
        return Hooks.driver.findElement(By.id("register-button"));
    }

    public WebElement getPassword()
    {
        return Hooks.driver.findElement(By.cssSelector("input[type=\"password\"]"));
    }
    public WebElement getConfirmPassword()
    {
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }
}
