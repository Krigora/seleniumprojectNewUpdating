package com.cybertek.tests.Home_work;

import com.cybertek.pages.OfficeHouse.LabLogMountainWarehouse;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MountinWarehousePosTest extends TestBase {

    @Test
    public void mountinWarehous() {
        driver.get(ConfigurationReader.getProperty("mountinwarehouse.url"));
        LabLogMountainWarehouse singUp = new LabLogMountainWarehouse();


        //   <button type="button" class="c-sledgehammer__close "><span class="i-close-dark"></span></button>
        //close alert
        WebElement infoAlertLink = driver.findElement(By.xpath("//button[@class='c-sledgehammer__close ']"));
        infoAlertLink.click();

        WebElement myAccount = driver.findElement(By.linkText("My Account"));
        myAccount.click();


        singUp.email.sendKeys(faker.internet().emailAddress());
        singUp.password.sendKeys("rjpJUF950");
        singUp.ConfPass.sendKeys("rjpJUF950");
        singUp.signInBtn.click();


    }
    @AfterMethod     // or drive.quit();
    public void tearDown() {
        driver.quit();
    }
}