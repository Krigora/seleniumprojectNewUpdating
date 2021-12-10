package com.cybertek.tests.day14_utils_webtables_properties;

import com.cybertek.utils.SmartBearUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SmartBearProductTest extends SmartBearTestBase{

    /*
    TC #1: Smartbear software link verification
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click to Login button
6. Print out count of all the links on landing page
7. Print out each link text on this page
     */

    @Test
    public void verifyLinksAfterLogin(){
        //perform login steps
        SmartBearUtils.loginToSmartBear(driver);

        // get all the links and print count and text
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Links count = " + links.size());

        for (WebElement link : links){
            System.out.println("Link text = " + link.getText());
        }

    }

}

