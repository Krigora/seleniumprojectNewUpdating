package com.cybertek.tests.Home_work;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GasMileageCalculatorTest {
/*
- Add a new class GasMileageCalculatorTest
- Goto https://www.calculator.net
- Search for “gas mileage” using search box
- Click on the “Gas Mileage Calculator” link
 - On Next page verify:
o Title equals: “Gas Mileage Calculator”
o “Gas Mileage Calculator” label is displayed
 - Locate, clear and type “7925” into “Current odometer” field
- Locate, clear and type “7550” into “Previous odometer” field
- Locate, clear and type “16” into “Gas added” field
- Locate, clear and type “3.55” into “Gas price” field and Click on Calculate button
 - Locate and print the mpg value

 */

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        String url = "https://www.calculator.net";
        driver.get(url);
        System.out.println("Title: " + driver.getTitle());

        //<input type="text" name="calcSearchTerm" id="calcSearchTerm" class="inlongest" onkeyup="return calcSearch();" onfocus="document.onkeydown=null;">

        WebElement searchField = driver.findElement(By.name("calcSearchTerm"));
        searchField.sendKeys("gas mileage");

        //<a href="/gas-mileage-calculator.html">Gas Mileage Calculator</a>

        WebElement searchButton = driver.findElement(By.cssSelector("a[href='/gas-mileage-calculator.html']"));

        searchButton.click();

        System.out.println("Title equals: " + driver.getTitle());

        Thread.sleep(1000);

       // <input type="text" name="uscodreading" id="uscodreading" value="12360" class="inlong" onkeyup="iptfieldCheck(this, 'r', 'pn');" style="border-color: rgb(65, 117, 22);">
        WebElement currentOdometr = driver.findElement(By.name("uscodreading"));
        currentOdometr.clear();
        currentOdometr.sendKeys("7925");

        Thread.sleep(1000);

        //<input type="text" name="uspodreading" id="uspodreading" value="12000" class="inlong" onkeyup="iptfieldCheck(this, 'r', 'pn');">

        WebElement previousOdometr = driver.findElement(By.xpath("//input[@id='uspodreading']"));
        previousOdometr.clear();
        previousOdometr.sendKeys("7550");

        Thread.sleep(1000);

// <input type="text" name="usgasputin" id="usgasputin" value="15" class="inlong" onkeyup="iptfieldCheck(this, 'r', 'pn');">
        WebElement gas = driver.findElement(By.name("usgasputin"));
        gas.clear();
        gas.sendKeys("16");

// <input type="text" name="usgasprice" id="usgasprice" value="3" class="inlong indollar" onkeyup="iptfieldCheck(this, '', 'pn');">
        WebElement gasPrice = driver.findElement(By.name("usgasprice"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");

        //<input type="image" src="//d26tpo4cm8sb6k.cloudfront.net/img/svg/calculate.svg" value="Calculate" alt="Calculate" style="margin-top:10px;">
        WebElement buttonCalc = driver.findElement(By.cssSelector("input[type='image']"));
        buttonCalc.click();

        //<b>0.2 mpg</b>
      // <span class="bigtext">(10.04 L/100 km  or 9.96 km/L)</span>


       WebElement otherResult = driver.findElement(By.xpath("//span[@class='bigtext']"));

      // System.out.println("currently value = " + result.getAttribute("value") );


        System.out.println("Gas mileage: " + driver.findElement(By.tagName("b")).getText() + " " + otherResult.getText());


        driver.quit();
    }






}
