package com.cybertek.tests.Home_work;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
         Thread.sleep(4000);


        WebElement signup = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']"));
        signup.sendKeys(Keys.ENTER);

        // <div class="message">

        WebElement message = driver.findElement(By.xpath("//div[@class='message']"));
        System.out.println(message.getText());

        //<p class="font-size-14">Please enter your account credentials below</p>

        String actualTitle = driver.getTitle();
        String expectedTitle = "Signup - PHPTRAVELS";

        System.out.println("Actual Title: " + actualTitle );
        System.out.println("Expected Title: " + expectedTitle);

        if (actualTitle.contains(expectedTitle)){
            System.out.println("PASS:  Title verification successful");
        } else {
            System.out.println("FAIL: Title verification fail");
        }
        //<a href="https://www.phptravels.net/login" type="submit" class="btn btn-block btn-outline-primary effect ladda-sm ladda-button waves-effect" data-style="zoom-in"><span class="ladda-label">Login</span><span class="ladda-spinner"></span></a>

        Thread.sleep(4000);

       //WebElement Newlogin = driver.findElement(By.xpath("//a[@href='https://www.phptravels.net/login']"));
       // Newlogin.sendKeys(Keys.ENTER);

        // <input class="form-control" type="email" placeholder="Email" required="required" name="email">
        WebElement NewMail = driver.findElement(By.name("email"));
        NewMail.sendKeys("Ihor.kryvynskyy@gmail.com");

        //<input class="form-control" type="password" placeholder="Password" required="required" name="password">
        WebElement NewPassword = driver.findElement(By.name("password"));
        NewPassword.sendKeys("QWErty123");

        //<button type="submit" class="btn btn-default btn-lg btn-block effect ladda-button waves-effect" data-style="zoom-in"><span class="ladda-label">Login</span><span class="ladda-spinner"></span></button>
        WebElement LoginNew = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']"));
        LoginNew.sendKeys(Keys.ENTER);

        String actualTitleN = driver.getTitle();
        String expectedTitleN = "Login - PHPTRAVELS";

        System.out.println("Actual Title: " + actualTitleN );
        System.out.println("Expected Title: " + expectedTitleN);

        if (actualTitleN.contains(expectedTitleN)){
            System.out.println("PASS:  Title verification successful");
        } else {
            System.out.println("FAIL: Title verification fail");
        }

    //    WebElement NewloginEmail = driver.findElement(By.xpath("//button[@class='btn btn-block btn-outline-primary effect ladda-sm ladda-button waves-effect']"));
     //   NewloginEmail.sendKeys(Keys.ENTER);

     //   WebElement NewMailNew = driver.findElement(By.xpath("//input[@placeholder='Email']"));
      //  NewMailNew.sendKeys("Ihor.kryvynskyy@gmail.com");

     //   WebElement NewPasswordNew = driver.findElement(By.xpath("//input[@placeholder ='Password']"));
      //  NewPasswordNew.sendKeys("QWErty123");

///html/body/section[1]/div/div[1]/div/div[1]/div[1]/div/div/h2


WebElement containsText = driver.findElement(By.xpath("//html/body/section[1]/div/div[1]/div/div[1]/div[1]/div/div/h2"));
        String wellcome = containsText.getText();

        if (wellcome.contains("Ihor")){
            System.out.println("PASS: Wellcome verification successful");
        } else {
            System.out.println("FAIL: Verification on valid");
        }

driver.quit();

    }
}
