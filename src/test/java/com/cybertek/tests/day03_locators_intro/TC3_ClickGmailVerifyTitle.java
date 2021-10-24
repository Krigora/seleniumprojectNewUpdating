package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_ClickGmailVerifyTitle{
    /*
    TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
     */

    public static void main(String[] args) {

 WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();


        String url = "https://google.com";   // те саме  driver.get("http://practice.cybertekschool.com");

        driver.get(url);                     // те свме

        // find Gmail link and click on it
      //  driver.findElement(By.linkText("Gmail")).click();
        driver.findElement(By.partialLinkText("Gm")).click();


// Verify title contains/starts with Gmail
        String expectedTitle = "Gmail";          //"Gmail: Free, Private & Secure Email | Google Workspace";

        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("PASS: gmail title verification successful");
        } else {
            System.out.println("FAIL: gmail title verification successful");
        }

       // go back

        driver.navigate().back();

        String googleExpectedTitle = "Google";
        String googleActualTitle = driver.getTitle();

        if (googleActualTitle.equals(googleExpectedTitle)){
            System.out.println("PASS: google title verification successful");
        } else {
            System.out.println("FAIL: google title verification successful");
        }

        driver.quit();






}





}














