package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PhpTravelsRegistrationTest {

    /*

     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String appUrl = " https://www.phptravels.net";
        driver.get(appUrl);

        driver.findElement(By.partialLinkText("Sign")).click();


        WebElement firstName = driver.findElement(By.name("first_name"));
        firstName.sendKeys("Ihor");

        WebElement lastName = driver.findElement(By.name("last_name"));
        lastName.sendKeys("Kryvynskyy");
//phone
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("7735710117");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("Ihor.kryvynskyy@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("QWErty123");

        //<button type="submit" class="btn btn-default btn-lg btn-block effect ladda-button waves-effect" data-style="zoom-in"><span class="ladda-label">Signup</span><span class="ladda-spinner"></span></button>
         Thread.sleep(2000);

        WebElement signup = driver.findElement(By.xpath("//button[.='Signup']"));
        signup.click();

        //<p class="font-size-14">Please enter your account credentials below</p>


        WebElement email1 = driver.findElement(By.name("email"));
        email.sendKeys("Ihor.kryvynskyy@gmail.com");

        WebElement password1 = driver.findElement(By.name("password"));
        password.sendKeys("QWErty123");

        //<button type="submit" class="btn btn-default btn-lg btn-block effect ladda-button waves-effect" data-style="zoom-in"><span class="ladda-label">Login</span><span class="ladda-spinner"></span></button>

        WebElement login = driver.findElement(By.xpath("//button[.='Login']"));
        login.click();



    }
}
