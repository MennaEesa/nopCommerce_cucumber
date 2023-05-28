package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class D08_WishlistStepDef {
    homePage home =new homePage();

    @When("user enter on wishlist button")
    public void wishlistBTN()
    {
        home.wishlistBTN().click();
    }

    @Then("Verify success message")
    public void successMSG()
    {
        SoftAssert soft = new SoftAssert();
        String successMG = home.wishlistSuccessMSG().getText();
        System.out.println("success message ="+successMG);

        soft.assertTrue(home.wishlistSuccessMSG().isDisplayed());
        String color = home.wishlistSuccessMSG().getCssValue("background-color");
        System.out.println("msg color ="+color);
        soft.assertEquals(Color.fromString(color).asHex(),"#4bb07a");
        soft.assertAll();

    }

    @And("user wait success message disappear")
    public void msgDisappear()
    {
        WebDriverWait wait =new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class=\"bar-notification success\"]")));

    }

    @And("user opens wishlist page")
    public void openWishlistPage()
    {
        home.wishlistPage().click();
    }

    @Then("user check quantity of the product")
    public void getQTY()
    {
        List<WebElement> product = home.productList();
        Assert.assertTrue(Integer.parseInt(home.productQTY(product.get(0)).getAttribute("value")) > 0) ;
    }

}
