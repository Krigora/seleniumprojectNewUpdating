package com.cybertek.tests.day04_locatot_getattribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PercentageCalculatorTest {

    public static void main(String[] args) {

        /*
        Main method:
    - launch browser, maximize
    - navigate to https://www.calculator.net/
    - Click on Percentage Calculator
    - Verify current title is "Percentage Calculator"
    - Enter 20% of 120000 and click enter (using Keys.ENTER)
    - Print the result "Result: 24000"
    - close browser
         */


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://www.calculator.net/";   // те саме  driver.get("https://www.calculator.net/");
        driver.get(url);

        // Click on Percentage Calculator
        driver.findElement(By.partialLinkText("Percentage Calculator")).click(); // driver.findElement(By.LinkText("Percentage Calculator")).click(); - повне та точне "Percentage Calculator"

        // Verify current title is "Percentage Calculator"
        String expectedTitle = "Percentage Calculator";
        String actualTitle = driver.getTitle();
        System.out.println("Current title = " + driver.getTitle()); // вивисти Title на друк

        if (actualTitle.contains(expectedTitle)){
            System.out.println("PASS: Title verification successful");
        } else {
            System.out.println("FAIL: Title verification successful");
        }

        // Enter 20%
        driver.findElement(By.name("cpar1")).sendKeys("20");

        //120000 and click enter (using Keys.ENTER)
        driver.findElement(By.name("cpar2")).sendKeys("120000", Keys.ENTER);

        //Print the result "Result: 24000"
        String result =  driver.findElement(By.className("h2result")).getText();
        System.out.println("result = " + result) ;

        if (result.endsWith("24000")){
            System.out.println("PASS: Calculation is correct");
        } else {
            System.out.println("FAIL: Calculation is incorrect");
        }

       driver.quit();

    }
}
