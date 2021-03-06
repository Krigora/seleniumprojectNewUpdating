package com.cybertek.tests.day17_upload_js_executer;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Guru99UploadTest extends TestBase {

    @Test
    public void uploadFileTest(){
        driver.get(ConfigurationReader.getProperty("guru99upload.url"));

        //<input type="file" name="uploadfile_0" class="upload_txt" id="uploadfile_0" size="40">
        WebElement chooseFileElem = driver.findElement(By.id("uploadfile_0"));

        //<input type="checkbox" class="field_check" id="terms" name="terms">
        WebElement terms = driver.findElement(By.id("terms"));

       //<button type="button" id="submitbutton" name="send" class="btn buttoncolor has-spinner" style="color:#000;"> <span class="spinner"><img src="images/spinner.gif" width="15" height="15"></span>Submit File</button>

        WebElement submitFileBtn = driver.findElement(By.id("submitbutton"));

        chooseFileElem.sendKeys(System.getProperty("user.home") + "/Downloads/some-file.txt");
        terms.click();
        submitFileBtn.click();

       // verify upload success by checking "1 file
        //has been successfully uploaded.
        //<h3 id="res" class="demo" style="color: rgb(255, 255, 255); display: block;"><center>1 file <br>has been successfully uploaded.</center></h3>

        WebElement resultMsg = driver.findElement(By.id("res"));
        Assert.assertEquals(resultMsg.getText(), "1 file\nhas been successfully uploaded." );
    }


}

