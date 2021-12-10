package com.cybertek.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    /*
    WebDDriverFactory class:
    is used to create WebDriver(selenium) object and return it
    It will open the browser and maximize it

    method:

    getDrive(String browserType)
    it will check browser type and return object;
    if browserType is "chrome:"
    it will set up chrome driver, and return new ChromeDriver
    if browserType is Firefox":
    it will set up firefox driver, and return new FirefoxDriver

    EX:

    WebDriver driver = WebDriverFactory.getDriver("Chrome");
    and use driver as normal
    Thank you, nice working with you
     */

    public static WebDriver getDriver(String browserType){
        if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        } else {
            System.out.println("Invalid BrowserType = " + browserType);
            return null; // null means No object. empty
        }
    }
}

