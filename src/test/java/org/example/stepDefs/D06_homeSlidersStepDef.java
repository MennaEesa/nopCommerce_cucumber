package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D06_homeSlidersStepDef {
    homePage home = new homePage();

    @When("user click on iphone slider")
    public void iphoneSlider() throws InterruptedException {
        Thread.sleep(2000);
        home.iphone().click();
        WebElement iphone =home.iphone();
        System.out.println("element ="+iphone);
        home.clickimage().click();
        Thread.sleep(2000);
    }


    @When("user click on nokia slider")
    public void nokiaSlider() throws InterruptedException {
        home.iphone().click();
        home.clickimage().click();
        Thread.sleep(2000);
    }

    @Then("^user should be directed to \"(.*)\"$")
    public void nokiaURL(String url)
    {
        SoftAssert soft = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.urlContains(url));
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains(url));

        soft.assertAll();
    }






}
