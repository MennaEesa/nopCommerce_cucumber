package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class D05_hoverCategoriesStepDef {
    WebElement randomItems;
    String Title;
    homePage home = new homePage();
    int randomNum = new Random().nextInt(home.categories().size());


    @When("user hover over random main category")
    public void randomMainCategory()
    {
        Actions action = new Actions(Hooks.driver);

        randomItems = home.categories().get(randomNum);
        String categoryName = randomItems.getText();
        System.out.println(categoryName);
        action.moveToElement(randomItems).perform();

    }



    @Then("click on random sub category")
    public void randomSubCategory()
    {

        if (home.subCategories(randomNum).size()>0){
            int randomSubNum = new Random().nextInt(home.subCategories(randomNum).size());
            randomItems = home.subCategories(randomNum).get(randomSubNum);
            Title = randomItems.getText();
            randomItems.click();
            System.out.println(Title);
            Assert.assertTrue(home.pageTitle().getText().toLowerCase().trim().contains(Title.toLowerCase().trim()),"Page title doesn't match selected category");

        }
        else {
           Title = randomItems.getText();
            randomItems.click();
            System.out.println(Title);
            Assert.assertTrue(home.pageTitle().getText().toLowerCase().trim().contains(Title.toLowerCase().trim()),"Page title doesn't match selected category");

        }

    }
}
