package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class D07_followUsStepDef {
    homePage home = new homePage();

    @When("user opens facebook link")
    public void checkFacebook()
    {
//click on facebook link

        home.faceBookLink().click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

    }

    @And("user switches to new tab")
    public void switchTabs()
    {
//2- get window list inside array
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        System.out.println(tabs.size());
        if (tabs.size()>1){
            Hooks.driver.switchTo().window(tabs.get(1));
        }

    }

    @When("user opens twitter link")
    public void checkTwitter()
    {
        home.twitterLink().click();
    }

    @When("user opens rss link")
    public void checkRss()
    {
        home.rssLink().click();
    }

    @When("user opens youtube link")
    public void checkYoutube()
    {
        home.youtubeLink().click();
    }

    @Then("^\"(.*)\" is opened in new tab$")
    public void urlISOpened(String url)
    {
        Assert.assertTrue( Hooks.driver.getCurrentUrl().contains(url) );
    }
}
