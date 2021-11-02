package com.cybertek.tests.day05_xpath_css_isdisplayed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_ForgotPassword {

    /*
    TC #3: PracticeCybertek/ForgotPassword URL verification
 1. Open Chrome browser
 2. Go to http://practice.cybertekschool.com/forgot_password
 3. Enter any email into input box
 4. Click on Retrieve password
 5. Verify URL contains:
 Expected: “email_sent”
 6. Verify textbox displayed the content as expected.
 Expected: “Your e-mail’s been sent!”
 Hint: You need to use getText method for this practice
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://practice.cybertekschool.com/forgot_password";
        driver.get(url);

        //Enter any email into input box
        WebElement mailBox = driver.findElement(By.name("email"));
        mailBox.sendKeys("cybertek01@gmail.com");

        //Click on Retrieve password
        WebElement retrievePwdBtn = driver.findElement(By.id("form_submit"));
        retrievePwdBtn.click();

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("email_sent")) {
            System.out.println("PASS: email_sent url verified");
        } else {
            System.out.println("FAIL:email_sent url Failed");
        }
        // verify Your e-mails been sent! is display
        WebElement message = driver.findElement(By.name("confirmation_message"));
        System.out.println("message displayed = " + message.getText());

        //<h4 name="confirmation_message">Your e-mail's been sent!</h4>

        String expMessage = "Your e-mail's been sent!";
        String actMessage = message.getText();

        if (actMessage.equals(expMessage)) {
            System.out.println("PASS: message displayed correctly");

        } else {

            System.out.println("FAIL: message is not displayed expected");
        }
        System.out.println("Name attribute value of message element = " + message.getAttribute("name"));

        driver.quit();

     ///html/body/section[1]/div/div[1]/div/div[1]/div[1]/div/div/h2
        ///html/body/section[1]/div/div[1]/div/div[1]/div[1]/div/div/h2
        ///html/body/section[1]/div/div[1]/div/div[1]/div[1]/div/div/h2
    }
}
