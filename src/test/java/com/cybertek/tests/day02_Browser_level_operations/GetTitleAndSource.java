package com.cybertek.tests.day02_Browser_level_operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndSource {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        String url = "https://www.etsy.com";
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        //read the title of the page and print out
        System.out.println("Title: " + driver.getTitle());

        //store the title into a String variable
        String etsyTitle = driver.getTitle();

        //read the url of the current page
        System.out.println("Current url: " + driver.getCurrentUrl());

        //story the url into a String variable currentUrl
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);


        //read page source and print it
        System.out.println("HTML page source: " + driver.getPageSource());

        //store the source code into a variable then print the char count
        String html = driver.getPageSource();
        System.out.println("count of html = " + html.length());

        //close the browser: driver.close()  , driver.quit();
        driver.quit();


    }
}
