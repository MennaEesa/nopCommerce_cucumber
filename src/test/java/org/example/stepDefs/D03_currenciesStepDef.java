package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.homePage;
import org.example.pages.loginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D03_currenciesStepDef {
    homePage home =new homePage();


    @Given("navigate to home page")
    public void login()
    {
        home.homePageLink().click();
    }

    @When("select Euro currency from dropdown list")
    public void selectEuro() throws InterruptedException
    {
        Select selectEuro = new Select(home.currencyList());
     selectEuro.selectByVisibleText("Euro");
        Thread.sleep(4000);
    }

    @Then("Euro Symbol is shown on the 4 products displayed in Home page")
    public void euroSymbol()
    {
        SoftAssert soft=new SoftAssert();
        List<WebElement> elements = home.items();
        for (WebElement product : elements) {
            String price = home.itemPrice(product).getText();
            String title = product.findElement(By.className("product-title")).getText();
//            System.out.println(title);
            soft.assertTrue(price.contains("€"));
        }
        soft.assertAll();

    }
}
