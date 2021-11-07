package com.cybertek.tests.day07_findElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorAddTest {
    /*
    Try to use CSS or Xpath for this task.
You are writing an automation test to verify if the calculator is working as expected.
1) Add a class CalculatorAddTest
2) Declare variables String appUrl = “https://www.calculator.net” int num1 = 5, num2 = 3
int expectedResult = 8
3) Launch selenium, maximize and navigate to the url
4) Locate 4 elements “5”, “3”, “+” , “=” using css or xpath and store into WebElement
objects
5) Click the elements in right order as you would do normally,
Add Thread.sleep(1234) in between steps to slow it down a little - not needed if you
have a cheap computer like mine :)
6) Locate result area and store into webElement object
7) Read the text of the result element, remove any unneeded characters and convert
into int. int expectedResult = Integer.parseInt(result);
8) Using if statement compare actualResult and the expectedResult . print pass or fail
accordingly.
9) Quit selenium and go home

     */
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String appUrl = "https://www.calculator.net";
        int num1 = 5;
        int num2 = 3;
        int expectedResult = 8;
        driver.get(appUrl);

        //4) Locate 4 elements “5”, “3”, “+” , “=” using css or xpath and store into WebElement
        //objects

        WebElement num1Elem = driver.findElement(By.cssSelector("span[onclick='r(5)']"));
        WebElement addElem = driver.findElement(By.xpath("//span[text()='+']"));  // span[.='+'] or //span[text()
        WebElement num2Elem = driver.findElement(By.cssSelector("span[onclick='r(3)']"));
        WebElement equalElem = driver.findElement(By.xpath("//span[.='=']"));

        num1Elem.click();
        Thread.sleep(1234);
        addElem.click();
        Thread.sleep(1234);
        num2Elem.click();
        Thread.sleep(1234);
        equalElem.click();


        // 6) Locate result area and store into webElement object
        WebElement result = driver.findElement(By.cssSelector("div[id='sciOutPut']")); // #sciOutPut
        System.out.println(num1 + " + " + num2 + " = " + result.getText());

        // 7) Read the text of the result element, remove any unneeded characters and convert

        String resultValue = result.getText();
        //get rid/remove of rigth/left spaces
        resultValue = resultValue.trim();
        //convert from String to int
        int actualResult = Integer.parseInt(resultValue);

        if (actualResult == expectedResult){
            System.out.println("PASS: calculation passed");
        } else {
            System.out.println("FAIL: calculation mismatch");
        }
        driver.quit();
    }

}
