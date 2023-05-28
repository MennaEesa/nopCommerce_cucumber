package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.registerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {

    registerPage register = new registerPage();

    @Given("user go to register page")
    public void goRegisterPage()
    {
        register.registerlink().click();
    }

    @And("user select gender type")
    public void gender()
    {
        register.selectGender().click();
    }

    @And("^user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void enterNames(String firstname,String lastname)
    {
        register.getFirstName().sendKeys(firstname);
        register.getLastName().sendKeys(lastname);
    }

    @And("user enter date of birth")
    public void date_of_Birth() throws InterruptedException {
        Select daySelect = new Select(register.getDay());
        daySelect.selectByIndex(21);

        Select monthSelect = new Select(register.getMonth());
        monthSelect.selectByVisibleText("February");

        register.getYear().sendKeys("2000");

    }

    @And("^user enter email \"(.*)\" field$")
    public void email(String email)
    {
        register.getEmail().sendKeys(email);
    }

    @And("^user fills Password fields \"(.*)\" \"(.*)\"$")
    public void password(String password,String confirm)
    {
        register.getPassword().sendKeys(password);
        register.getConfirmPassword().sendKeys(confirm);
    }

    @And("user clicks on register button")
    public void clickRegister() throws InterruptedException {
        register.clickRegister().click();
        Thread.sleep(3000);
    }

    @Then("success message is displayed")
    public void success_Regis()
    {
        SoftAssert soft = new SoftAssert();
// First Assertion
        String expectedResult = "Your registration completed";
        String actualResult =Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).getText();
        soft.assertEquals(actualResult.contains(expectedResult),"First assertion");
        System.out.println("First assertion");
// Second Assertion
     String color = Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).getCssValue("color");
        System.out.println("Text color :"+color);

        soft.assertAll();
    }

}
