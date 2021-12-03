package com.cybertek.tests.day13_faker_practice_browserutil_properties;

import com.cybertek.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class RegistrationFormNegativTest extends RegistrationFormTestBase {
    @Test
    public void invalidFirstNameTest(){
        //do not enter any value in firstname and click on sing on
        //"first name is requared" error msg should be displayed

        WebElement singUp = driver.findElement(By.id("wooden_spoon"));
        singUp.click();

        //wait for 1 second
        BrowserUtils.sleep(2);

        WebElement errorMsg = driver.findElement(By.xpath("//small[.='firstname']"));
        assertTrue(errorMsg.isDisplayed(), "Error message is not displayed");

        // //type 12345 and verify "first name can only consist of alphabetical letters" is displayed

        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("1234");

        BrowserUtils.sleep(2);

        WebElement noNumberMsg = driver.findElement(By.xpath("//small[.='first name can only consist of alphabetical letters']"));
        assertTrue(noNumberMsg.isDisplayed(), "Error message is not displayed");


    }


}
