package com.cybertek.tests.Home_work.Vytrack;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TC_001 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://qa2.vytrack.com/user/login";

        //implicit wait command. wait upto 10 seconds while finding element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        driver.findElement(By.name("_username")).sendKeys("User7");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.name("_submit")).click();
        Thread.sleep(2000);

        WebElement noClickFleetButton = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(noClickFleetButton).perform();

        //<span class="title title-level-2">Vehicles</span>
        WebElement vehiclesButton = driver.findElement(By.xpath("//span[.=Vehicles]"));
        vehiclesButton.click();


    }
}
