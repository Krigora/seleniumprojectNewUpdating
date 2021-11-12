package com.cybertek.tests.day04_locatot_getattribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeDemo {
    public static void main(String[] args) {
        /*
        navigate to google home page

Locate the search field and assign to WebElement variable
WebElement searchField = driver.findElement(By.name("q"));

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.google.com/";
        driver.get(url);

        //Locate the search field and assign to WebElement variable
        WebElement searchField = driver.findElement(By.name("q"));
        System.out.println("Class value = " + searchField.getAttribute("class"));
        System.out.println("max length = " + searchField.getAttribute("maxlength"));
        searchField.sendKeys("Wooden Spoon");


        //read the value that is in the
        System.out.println("currently value = " + searchField.getAttribute("value") );

        //print name value of the WebElement
        System.out.println("name = " + searchField.getAttribute("name"));


       // driver.quit();



    }
}
