package com.cybertek.tests.day10_dropdown_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class MultiSelectDropDown {


    String url = "http://practice.cybertekschool.com/dropdown";
    WebDriver driver; //can use in every method

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void selectMultipleLanguagesTest() throws InterruptedException {

//<select name="Languages" multiple="">
//      <option value="java">Java</option>
//      <option value="js">JavaScript</option>
//      <option value="c#">C#</option>
//      <option value="python">Python</option>
//      <option value="ruby">Ruby</option>
//      <option value="c">C</option>
//    </select>
        Select languages = new Select(driver.findElement(By.name("Languages")));
        languages.selectByVisibleText("Java");
        languages.selectByVisibleText("JavaScript");
        languages.selectByVisibleText("Python");

        System.out.println("languages.isMultiple() = " + languages.isMultiple());

        Thread.sleep(1234);
        // un check all selected options
        languages.deselectAll();

        Thread.sleep(1234);

        for (WebElement each : languages.getOptions()){
            each.click();
        }

    }
}