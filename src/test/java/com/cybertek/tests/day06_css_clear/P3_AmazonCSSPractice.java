package com.cybertek.tests.day06_css_clear;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_AmazonCSSPractice {
    /*
    1. Open Chrome browser
2. Go to https://www.amazon.com
3. Enter search term (use cssSelector to locate search box)
4. Verify title contains search term
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String appUrl = "https://www.amazon.com";
        driver.get(appUrl);


         Thread.sleep(3000);
        //<input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder="" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search">

        // ("input[id='twotabsearchtextbox']")
        // ("input[aria-label="Search']")
        // ("input[name='field-keywords']")

        // type Wooden spoon
        WebElement searchField = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        WebElement searchButton = driver.findElement(By.cssSelector("input[value='Go']"));

        searchField.sendKeys("wooden spoon");
        searchButton.click();

        /**
         page refreshes ta this point
         We need to locate the element again in order to use them
         So we nrrd to repeat steps 31-32
         */

        //clear the search input box then search for "iphone 13 wooden case"

searchField = driver.findElement(By.cssSelector("input[name ='field-keywords']"));
searchButton = driver.findElement(By.cssSelector("input[id='nav-search-submit-button']"));

//clear the value of search  field
        searchField.clear();
        searchField.sendKeys("iphone wooden case");
        searchButton.click();

    }
}
