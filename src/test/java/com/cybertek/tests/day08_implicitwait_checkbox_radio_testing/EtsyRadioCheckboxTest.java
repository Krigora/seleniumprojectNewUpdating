package com.cybertek.tests.day08_implicitwait_checkbox_radio_testing;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;
/*
Launch Browser and goto etsy homepage
search for wooden spoon
click on filters
Select free shipping, on sale
select under $25
Click on apply filters
Print count of results
 */

public class EtsyRadioCheckboxTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://www.etsy.com";

        //implicit wait command. wait upto 10 seconds while finding element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        //search for wooden spoon
        // <input id="global-enhancements-search-query" data-id="search-query" data-search-input="" type="text" name="search_query" class="wt-input wt-input-btn-group__input global-enhancements-search-input-btn-group__input wt-pr-xs-7
        //                        " placeholder="Search for anything" value="" autocomplete="off" autocorrect="off" autocapitalize="off">
        WebElement searchField = driver.findElement(By.name("search_query"));
        searchField.sendKeys("wooden spoon" + Keys.ENTER);

        // click all filter
        // <button id="search-filter-button" class="wt-btn wt-btn--small wt-btn--secondary wt-display-flex-xs wt-align-items-center" aria-controls="search-filters-overlay">

     WebElement allFilter = driver.findElement(By.id("search-filter-button"));
     allFilter.click();

 // Select free shipping, on sale , select under $25 , /Click on apply filters
        //<input type="checkbox" id="special-offers-free-shipping" name="free_shipping" value="true">  - dont worjking
        //<label for="special-offers-free-shipping" class="wt-checkbox__label wt-display-inline">

WebElement freeShip = driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']"));
freeShip.click();

// <label for="special-offers-on-sale" class="wt-checkbox__label wt-display-inline">

        WebElement onSale= driver.findElement(By.xpath("//label[@for='special-offers-on-sale']"));
        onSale.click();
 // <label for="price-input-1" class="wt-radio__label wt-display-inline">

        WebElement under$25 = driver.findElement(By.xpath("//label[@for='price-input-1']"));
        under$25.click();

        //<button class="wt-btn wt-btn--primary wt-width-full wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3" type="submit" form="search-filter-form" aria-label="Apply" data-wt-overlay-close="">
        WebElement apply = driver.findElement(By.xpath("//button[@aria-label='Apply']"));
        apply.click();

        // <span class="wt-display-inline-flex-sm">
        //    <span>1,780 results,</span>

        Thread.sleep(2000);

        // By.xpath("//span[@class='wt-display-inline-flex-sm']/span[1]"));

        WebElement result = driver.findElement(By.xpath("(//span[contains(text(),'results,')])[1]"));
        System.out.println("Result = " + result.getText());

driver.quit();
    }
}
