package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class homePage {

    public WebElement homePageLink()
    {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/\"]"));
    }

    public WebElement currencyList()
    {
      return Hooks.driver.findElement(By.id("customerCurrency"));
    }

    public List<WebElement> items()
    {
    return Hooks.driver.findElements(By.className("product-item"));
    }

    public WebElement itemPrice(WebElement product)
    {
        return product.findElement(By.className("actual-price"));
    }

public WebElement itemName(WebElement product)
{
    return product.findElement(By.className("product-title"));
}



// Search feature //

   public WebElement getSearch()
   {
       return Hooks.driver.findElement(By.id("small-searchterms"));
   }

    public WebElement getSKU(WebElement product) {
        return Hooks.driver.findElement(By.cssSelector(" div[class=\"sku\"] > span[class=\"value\"]"));
    }




// hover //

    public List<WebElement> categories()
    {
        return Hooks.driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li/a"));
    }

    public List<WebElement> subCategories(int num)
    {
        return Hooks.driver.findElements(By.xpath("(//ul[@class='top-menu notmobile']/li/a)["+(num+1)+"]/following-sibling::ul//a"));
    }

    public WebElement pageTitle ()
    {
        return Hooks.driver.findElement(By.tagName("h1"));
    }



// Slider Feature //

     public WebElement clickimage()
     {
        return Hooks.driver.findElement(By.cssSelector("[class=\"nivo-imageLink\"]"));
     }

     public WebElement iphone()
     {
         return Hooks.driver.findElement(By.cssSelector("div[class=\"nivo-controlNav\"]> a[rel=\"0\"]"));
     }

    public WebElement nokia()
    {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"nivo-controlNav\"]> a[rel=\"1\"]"));
    }

//    Follow US //

    public WebElement faceBookLink()
    {
        return Hooks.driver.findElement(By.xpath("//a[@href=\"http://www.facebook.com/nopCommerce\"]"));
    }

    public WebElement twitterLink()
    {
        return Hooks.driver.findElement(By.xpath("//a[@href=\"https://twitter.com/nopCommerce\"]"));
    }

    public WebElement rssLink()
    {
        return Hooks.driver.findElement(By.xpath("//a[@href=\"/news/rss/1\"]"));
    }

    public WebElement youtubeLink()
    {
        return Hooks.driver.findElement(By.xpath("//a[@href=\"http://www.youtube.com/user/nopCommerce\"]"));
    }


//    WishList //

    public WebElement wishlistBTN()
    {
        return Hooks.driver.findElement(By.cssSelector("div[data-productid=\"18\"]")).findElement(By.className("add-to-wishlist-button"));    }

    public WebElement wishlistSuccessMSG()
    {
      return Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }

    public WebElement wishlistPage()
    {
        return Hooks.driver.findElement(By.className("ico-wishlist"));
    }

    public List<WebElement> productList()
    {
        return Hooks.driver.findElements(By.cssSelector("table[class=\"cart\"] > tbody > tr"));
    }

    public WebElement productQTY(WebElement product)
    {
        return product.findElement(By.className("qty-input"));
    }
}
