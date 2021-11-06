package com.cybertek.tests.Home_work;

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
    driver.get(appUrl);

    Thread.sleep(2000);

    //<span onclick="r(5)" class="scinm">5</span>

    WebElement num1 = driver.findElement(By.cssSelector("span[onclick='r(5)']"));
    num1.click();

    //<span onclick="r('+')" class="sciop">+</span>
    WebElement addition = driver.findElement(By.cssSelector("span[class='sciop']"));
    addition.click();

    //<span onclick="r(3)" class="scinm">3</span>
    WebElement num2 = driver.findElement(By.cssSelector("span[onclick='r(3)']"));
    num2.click();
Thread.sleep(1234);

    // <span onclick="r('=')" class="scieq">=</span>
   // WebElement equal = driver.findElement(By.cssSelector("span[class='scieq']"));
   // equal.click();

    //<div id="sciOutPut">&nbsp;8</div>
    ///html/body/div[3]/div/table/tbody/tr/td[1]/table/tbody/tr[1]/td/div/div[2]
    WebElement resultText = driver.findElement(By.cssSelector("div[id='sciOutPut']"));
    System.out.println("Result: " + resultText.getText());


    WebElement result = driver.findElement(By.xpath("//html/body/div[3]/div/table/tbody/tr/td[1]/table/tbody/tr[1]/td/div/div[2]"));
    String actualResult = result.getText();

    if (actualResult.contains("8")){
        System.out.println("PASS: all good");
    } else {
        System.out.println("FAIL: bed boy");
    }

driver.quit();

}



}
