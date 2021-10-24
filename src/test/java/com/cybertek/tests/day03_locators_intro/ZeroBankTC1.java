package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankTC1 {
    /*
    1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String uppUrl = "http://zero.webappsecurity.com/login.html";
        driver.get(uppUrl);
Thread.sleep(2000);
        //Verify header text
        System.out.println("header text = " + driver.findElement(By.tagName("h3")).getText());

        String header = driver.findElement(By.tagName("h3")).getText();
        System.out.println("header = " + header);

        String expectedHeader = "Log in to ZeroBank";
        if (header.equals(expectedHeader)) {
            System.out.println("PASS: Header is displaed correctle");
        } else {
            System.out.println("FAIL: Header is incorrectly");

        }
        Thread.sleep(2000);

        driver.quit();
    }

}