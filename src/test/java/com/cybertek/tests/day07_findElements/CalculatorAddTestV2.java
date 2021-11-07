package com.cybertek.tests.day07_findElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorAddTestV2 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String appUrl = "https://www.calculator.net";
        int num1 = 7;
        int num2 = 4;
        /**
         Homework: make selenium work for numbers more than 1 digit as well
         int num1 = 128, num2 = 90; etc
         */
        int expectedResult = num1 + num2;
        driver.get(appUrl);

        System.out.println("//span[.='"+ num1 +"']"); //span[.='7']

        //<span onclick="r(5)" class="scinm">5</span>

        WebElement num1Elem = driver.findElement(By.xpath("//span[.='" + num1 +"']"));
        WebElement num2Elem = driver.findElement(By.cssSelector("span[onclick='r(" + num2 +")']"));
        WebElement plus = driver.findElement(By.xpath("//span[.='+']"));
        WebElement equal = driver.findElement(By.xpath("//span[text()='=']"));

        num1Elem.click();
        plus.click();
        num2Elem.click();
        equal.click();

        WebElement result = driver.findElement(By.xpath("//div[@id='sciOutPut']"));
        System.out.println("Result = " + result.getText());

        driver.quit();

    }
}
