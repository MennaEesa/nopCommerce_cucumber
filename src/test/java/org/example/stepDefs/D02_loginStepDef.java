package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.loginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {

    SoftAssert soft = new SoftAssert();
    loginPage login = new loginPage();

    @Given("user go to login page")
    public void navigate_login() {
        login.loginlink().click();
    }
    @When("^user login \"(.*)\" and \"(.*)\"$")
    public void validData (String username, String password) throws InterruptedException {
        login.getEmail().sendKeys(username);
        login.getPassword().sendKeys(password);
        Thread.sleep(3000);
    }

    @And("user press on login button")
    public void clickLogin() throws InterruptedException
    {
        login.loginBTN().click();
        Thread.sleep(3000);
    }

    @Then("user could login to the system")
    public void successLogin()
    {
//First Assertion
        soft.assertTrue(login.myAccountTap().isDisplayed());
// Second Assertion
        soft.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        soft.assertAll();

    }

    @Then("user could not login to the system")
    public void failedLogin()
    {
//First Assertion
        String expectedResult = "Login was unsuccessful.";
        String actualResult = login.errorMessage().getText();
        soft.assertTrue(actualResult.contains(expectedResult),"Text is wrong");

// Second Assertion
       soft.assertEquals(Color.fromString(login.errorMessage().getCssValue("color")).asHex(),"#e4434b");

        soft.assertAll();

    }
}
