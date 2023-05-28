package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.homePage;
import org.example.pages.loginPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Locale;

public class D04_searchStepDef {
    SoftAssert soft = new SoftAssert();
    homePage home = new homePage();


    @Given("user navigates to home page")
    public void goHome() {
        home.homePageLink().click();
    }

    @When("^user enter product as \"(.*)\"and enter$")
    public void enterProduct(String name) {
        home.getSearch().sendKeys(name, Keys.ENTER);
    }

    @Then("^search result should contain \"(.*)\"$")
    public void checkResult(String item) {
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
        List<WebElement> elements = home.items();
        int productSize = elements.size();
        System.out.println("product Size =" + productSize);

        for (WebElement element : elements)
        {
            String getName = home.itemName(element).getText();
            System.out.println(getName.toLowerCase());
            soft.assertTrue(getName.toLowerCase().contains(item));
        }

        soft.assertAll();

    }

    @When("^user enter product sku as \"(.*)\"and enter$")
    public void enterSku (String sku)
    {
        home.getSearch().sendKeys(sku,Keys.ENTER);
    }

    @Then("^search result should contain Sku \"(.*)\"$")
    public void checkSku(String sku)
    {
        List<WebElement> products = home.items();
        for (WebElement product:products) {
            product.click();
            String productSKU = home.getSKU(product).getText();
            System.out.println("product SKU ="+productSKU);
            Assert.assertTrue(productSKU.contains(sku));

        }
    }

}
