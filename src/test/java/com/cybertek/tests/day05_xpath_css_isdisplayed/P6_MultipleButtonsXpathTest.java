package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P6_MultipleButtonsXpathTest {
    public static void main(String[] args) {

        /*
        TC #6: XPATH LOCATOR practice
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/multiple_buttons
3. Click on Button 1
4. Verify text displayed is as expected:
Expected: “Clicked on button one!”
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
         */
        String appUrl = "http://practice.cybertekschool.com/multiple_buttons";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);

       // <button class="btn btn-primary" onclick="button1()">Button 1</button>

        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();

        //<p id="result" style="color:green">Clicked on button one!</p>
        WebElement resultMeg = driver.findElement(By.xpath("//p[@id='result']"));
        System.out.println(resultMeg.getText());

        //Locate button2 using xpat and check if it is currently displayed on the page,
        // then click on
        //<button class="btn btn-primary" onclick="button2()" name="button2">Button 2</button>
        WebElement button2 = driver.findElement(By.xpath("//button[text()='button 2()']")); //or ("//button[.='Button2']"));

        if (button2.isDisplayed()){
            System.out.println("PASS: Button2 is displayed");
            button2.click();
        } else {
            System.out.println("FAIL: Button2 is not displayed");
        }




    }
}
