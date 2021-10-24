package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5_SmartBearLoginTest {

    /*
    TC #5:	Basic	login	authentication
1- Open	a	chrome	browser
2- Go	to:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3- Verify	title	equals:
Expected:	Web	Orders	Login
4- Enter	username:	Tester
5- Enter	password:	test
6- Click	“Sign	In”	button
7- Verify	title equals:
Expected:	Web	Orders
     */

    public static void main(String[] args) throws InterruptedException {
        String appUrl = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
        String userName = "Tester";
        String password = "test";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(appUrl);

        // enter username
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(userName);
        // enter password
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
        // click login
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        //verify title is "web Orders

        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASS: Login success/ title match");
        } else {
            System.out.println("FAIL: Login faild. title mismatched");

        }

        //click logout link
        driver.findElement(By.linkText("logout")).click();
        Thread.sleep(2000);

        //quit browser
      driver.quit();




    }



}
