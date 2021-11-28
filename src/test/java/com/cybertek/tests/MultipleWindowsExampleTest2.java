package com.cybertek.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class MultipleWindowsExampleTest2 {
    WebDriver driver;
    String url = "https://demoqa.com/browser-windows";

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
        @Test
        public void demoQAMultipleWindows() {

            String mainHandle = driver.getWindowHandle();
            WebElement newTab = driver.findElement(By.cssSelector("#tabButton"));
            newTab.click();
            WebElement newWindow = driver.findElement(By.cssSelector("#windowButton"));
            newWindow.click();
            WebElement newWindowWithMessage = driver.findElement(By.cssSelector("#messageWindowButton"));
            newWindowWithMessage.click();

            System.out.println("Title of main/parent page = " + driver.getTitle());

            //store all window handle ids in to a Set
            Set<String> allWindowHandle = driver.getWindowHandles();
            System.out.println("Total window count = " + allWindowHandle.size());

            for (String eachWinHandle : allWindowHandle) {
                System.out.println("Switching to new window" + eachWinHandle);
                driver.switchTo().window(eachWinHandle);
                System.out.println("Title: " + driver.getTitle());
            }

        }
    }