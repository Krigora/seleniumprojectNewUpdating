package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #4:	Google	search
1- Open	a	chrome	browser
2- Go	to:	https://google.com
3- Write	“apple”	in	search	box
4- Click	google	search	button
5- Verify	title:
Expected:	Title	should	start	with	“apple”	word
 */

public class TC4_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://google.com";
        driver.get(url);

        // locate anr type "apple" to google search
         driver.findElement(By.name("q")).sendKeys("apple");

         Thread.sleep(2000);

         //locate and click on search botton
        driver.findElement(By.name("btnK")).click();

        String actTitle = driver.getTitle();
        String expTitle = "apple";

        if (actTitle.startsWith((expTitle))){
            System.out.println("PASS: Title match");
        } else {
            System.out.println("FAIL: Title mismatched");
        }






        driver.quit();

    }


}
