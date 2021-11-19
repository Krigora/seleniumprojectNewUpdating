package com.cybertek.tests.day09_testing_dropdowns;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDownTest {


    String url = "http://practice.cybertekschool.com/dropdown";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.out.println("Setting up WebDriver......");
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void titleTest(){
        System.out.println("Title of the page = " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Practice");

    }
    @Test
    public void SimpleDropDownTest(){
        // locate Select element
        //<select id="dropdown">
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        //create select element object
        Select simpleDropDown = new Select(dropDown);
        simpleDropDown.selectByVisibleText("Option 1");


    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Closing browser");
        driver.close();
    }

}
