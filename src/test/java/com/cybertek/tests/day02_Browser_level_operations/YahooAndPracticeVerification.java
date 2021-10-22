package com.cybertek.tests.day02_Browser_level_operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooAndPracticeVerification {
    public static void main(String[] args) {

        /*
        TC #1: Yahoo Title Verification
1. Open Chrome browser
2. Go to https://www.yahoo.com/
3. Verify title:
Expected: Yahoo
TC #2: Cybertek practice tool verifications
1. Open Chrome browser
2. Go to https://practice.cybertekschool.com/
3. Verify URL contains
Expected: cybertekschool
4. Verify title:
 Expected: Practice
         */
        WebDriverManager.chromedriver().setup();
        String url = "https://www.yahoo.com/";
        WebDriver driver = new ChromeDriver();
        String expectedTitle = "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASS: title verification successful" );
        } else {
            System.out.println("FAIL: title verification failed");

        }
        System.out.println("actualTitle = " + actualTitle);
        System.out.println("expectedTitle = " + expectedTitle);

//if (driver.getTitle().equals("Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos")){
     //   driver.quit();

   }


}
