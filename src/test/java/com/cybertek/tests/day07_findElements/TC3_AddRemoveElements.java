package com.cybertek.tests.day07_findElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TC3_AddRemoveElements {
    /*
    TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements
3. Click to “Add Element” button 50 times
4. Verify 50 “Delete” button is displayed after clicking.
5. Click to ALL “Delete” buttons to delete them.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
Hint: Need to use findElements method.
     */

    public static void main(String[] args) {
        String url = "http://practice.cybertekschool.com/add_remove_elements/";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(url);


//3  locate button 50 times
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        //  Click to “Add Element” button 50 times
        for (int i = 0; i < 50; i++) {
            addElement.click();
        }

        // 4. Verify 50 “Delete” button is displayed after clicking.
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));
        System.out.println("count of delete Buttons = " + deleteButtons.size());

        if (deleteButtons.size() == 50){
            System.out.println("PASS: 50 buttons  added successfully");
        } else {
            System.out.println("FAIL: cannot add 50 button");
        }

        // 5. Click to ALL “Delete” buttons to delete them.
      for (WebElement deleteButton : deleteButtons){ //the same deleteButtons.forEach(deleteBtn -> deleteBtn.click());
           deleteButton.click();
       }

        //ForEach method with lambda expression (->)
       // deleteButtons.forEach(deleteBtn -> deleteBtn.click());  // the same, working

      //  deleteButtons.forEach(anyVarName -> anyVarName.click()); // tha same

        // run findElements for delete buttons again and see if it is 0
        deleteButtons = driver.findElements(By.xpath("//Button[.='Delete']"));
      if (deleteButtons.isEmpty()) {
          System.out.println("PASS: All 50 button deleted succesfully");

      }else {
          System.out.println("FAIL: could not delete all 50 buttond");
      }
      driver.quit();

    }
}
