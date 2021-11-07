package com.cybertek.tests.day07_findElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class TC3_AddRemoveElements {

    public static void main(String[] args) {
        String url = "http://practice.cybertekschool.com/add_remove_elements/";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(url);
    }
}
