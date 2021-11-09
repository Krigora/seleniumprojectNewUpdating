package com.cybertek.tests.Home_work.CRM;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DEMO {

    public static void main(String[] args) throws InterruptedException {
        String url = "http://login2.nextbasecrm.com";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(url);

        String userNameHelpDesk3 = "helpdesk3@cybertekschool.com";
        String password = "UserUser";
        String invalidPassword = "wrongs";

 //<input class="login-inp" type="text" name="USER_LOGIN" placeholder="Login" value="" maxlength="255">
        WebElement loginBar = driver.findElement(By.name("USER_LOGIN"));
        loginBar.sendKeys(userNameHelpDesk3);

//<input class="login-inp" type="password" name="USER_PASSWORD" placeholder="Password" maxlength="255">

        WebElement passwordBar = driver.findElement(By.name("USER_PASSWORD"));
        passwordBar.sendKeys(password);

        // <input type="submit" value="Log In" class="login-btn" onclick="BX.addClass(this, 'wait');">
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        Thread.sleep(1000);
//<title>(45) Portal</title>
        System.out.println("Title: " + driver.getTitle());


        Thread.sleep(3000);

        String homePageTitle = driver.getTitle();
        String expectedTitle = "(45) Portal";

        if (homePageTitle.equals(expectedTitle)){
            System.out.println("PASS: title Match");

        }else {
            System.out.println("FAIL: Title not Matching");
        }


       // _________________________________________________________________________
                //Negative

//<span class="user-name" id="user-name">Part2 Group2</span>
        WebElement accountTab = driver.findElement(By.cssSelector("span[class='user-name']"));
        accountTab.click();

//<span class="menu-popup-item-text">Log out</span>
        WebElement logoutButton = driver.findElement(By.xpath("//span[.='Log out']"));
        logoutButton.click();

        Thread.sleep(1000);

        WebElement loginBar2 = driver.findElement(By.name("USER_LOGIN"));
        loginBar2.clear();

       // Thread.sleep(2000);

        loginBar2.sendKeys(userNameHelpDesk3);


        WebElement passwordBar2 = driver.findElement(By.name("USER_PASSWORD"));
        passwordBar2.clear();
        passwordBar2.sendKeys(invalidPassword);

        Thread.sleep(2000);

        WebElement loginButton2 = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton2.click();

        System.out.println("Title: " + driver.getTitle());

//<div class="errortext">Incorrect login or password<br></div>
        WebElement incorrectLoginPopur = driver.findElement(By.xpath("//div[@class='errortext']"));

        incorrectLoginPopur.getText();
        System.out.println(incorrectLoginPopur.isDisplayed());

        if (incorrectLoginPopur.isDisplayed()){
            System.out.println("PASS: Incorrect login");

        }else {
            System.out.println("FAIL: Incorrect login");
        }
        driver.quit();

    }
}