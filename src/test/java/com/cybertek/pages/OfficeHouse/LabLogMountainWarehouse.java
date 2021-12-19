package com.cybertek.pages.OfficeHouse;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LabLogMountainWarehouse extends TestBase {
    public LabLogMountainWarehouse(){
        //Selenium command to initialize the element below
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="RegisterEmailAddress")
    public WebElement email;

    @FindBy(id="RegisterPassword")
    public WebElement password;

    @FindBy(id="ConfirmPassword")
    public WebElement ConfPass;

    @FindBy(xpath="//button[.='Register']")
    public WebElement signInBtn;

   // @FindBy(xpath="//div[.='Sorry, Wrong Email or Password']")
   // public WebElement errorMsg;



    }



