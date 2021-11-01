package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMapsXpathTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://www.google.com/maps/";
        driver.get(url);

        //search for cybertek school
        WebElement addressField = driver.findElement(By.xpath("/html/body/div[3]/div[9]/div[3]/div[1]/div[1]/div[1]/div[2]/form/div/div[3]/div/input[1]"));
        addressField.sendKeys("cybertek chicago" + Keys.ENTER);


        Thread.sleep(3000);

        //click on directions
        WebElement directions = driver.findElement(By.xpath("/html/body/div[3]/div[9]/div[8]/div/div[1]/div/div/div[4]/div[1]/button/span/img"));
        directions.click();

        Thread.sleep(2000);

        //<input autocomplete="off" class="tactile-searchbox-input" aria-autocomplete="list" aria-controls="sbsg50" dir="ltr" spellcheck="false" style="border: none; padding: 0px; margin: 0px; height: auto; width: 100%; outline: none;" aria-label="Choose starting point, or click on the map..." placeholder="Choose starting point, or click on the map...">

        WebElement startingAddressField = driver.findElement(By.xpath("//input[@placeholder='Choose starting point, or click on the map...']"));
        startingAddressField.sendKeys("Chicago, IL" + Keys.ENTER);

        driver.quit();

    }
}
