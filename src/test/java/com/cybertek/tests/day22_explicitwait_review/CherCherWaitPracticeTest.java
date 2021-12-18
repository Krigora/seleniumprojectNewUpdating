package com.cybertek.tests.day22_explicitwait_review;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CherCherWaitPracticeTest extends TestBase {

    @BeforeMethod
    public void gotoHomePage() {
        driver.get(ConfigurationReader.getProperty("chercher.url"));
    }
    @Test
    public void waitForAlertTest() {
        //<button class="btn btn-success" id="alert" onclick="setTimeout(alertme,5000);alertcount();">Click me, to Open an alert after 5 seconds</button>
        WebElement openAlertBtn = driver.findElement(By.id("alert"));
        openAlertBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.alertIsPresent());
        //org.openqa.selenium.NoAlertPresentException: no such alert

      //  driver.switchTo().alert().accept();

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    @Test
    public void waitForButtonEnabledTest() {
        //<button id="disable" disabled="" ;onclick="setTimeout(enable, 10000);">Button</button>
        WebElement button = driver.findElement(By.id("disable"));
        System.out.println("cher cher button enable = " +  button.isEnabled());


//<button id="enable-button" class="btn btn-primary" onclick="setTimeout(enable,10000);enablecount();disable();">Enable button after 10 seconds</button>
        WebElement enableBtn = driver.findElement(By.id("enable-button"));
        enableBtn.click();

        //wait until the button is anabled
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(button));

        System.out.println("cher cher button enable = " +  button.isEnabled());


    }

    @Test
    public void waitForCheckBoxIsCheckedTest() {
        //<input type="checkbox" id="ch">
        WebElement checkbox = driver.findElement(By.id("ch"));
        System.out.println("checkbox is checked = " + checkbox.isSelected());
        //<button id="checkbox" type="button" class="btn btn-primary btn-xs" onclick="setTimeout(myFunction,10000);count();uncheck();">Check Checkbox after 10 seconds</button>
        WebElement enableCheckBoxBtm = driver.findElement(By.id("checkbox"));
        enableCheckBoxBtm.click();

      //  wait until checkbox is selected
                WebDriverWait wait = new WebDriverWait(driver, 65);
                wait.until(ExpectedConditions.elementToBeSelected(checkbox));

        System.out.println("checkbox is checked = " + checkbox.isSelected());

    }
}
