package com.cybertek.tests.day08_implicitwait_checkbox_radio_testing;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RedioButtonsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "http://practice.cybertekschool.com/radio_buttons";

        //implicit wait command. wait upto 10 seconds while finding element
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        // <input type="radio" id="red" name="color">
        WebElement red = driver.findElement(By.id("red"));
        if (!red.isSelected()){
            red.click();
        }
        // <input type="radio" id="football" name="sport">
        WebElement football = driver.findElement(By.id("football"));
        if(!football.isSelected()) {
            System.out.println("SELECTING <Football> radio button");
            football.click();
        }

        //verity if football option is selected
        if (football.isSelected()){
            System.out.println("PASS - football is selected");
        } else {
            System.out.println("FAIL - football is not selected");
        }

        // find all radio buttons
        //print the count
        //click one by one , waiting 1 second in between
        // we can use isEnabled method ti check if element is active/disable
        List<WebElement> radioButtons =driver.findElements(By.xpath("//input[@type='radio']"));
        System.out.println("Total count = " + radioButtons.size());

        for (WebElement radio : radioButtons) {
            if (radio.isEnabled()) {
                radio.click();
            }
            Thread.sleep(1234);
        }

        driver.quit();
    }
}
