package com.cybertek.tests.day10_dropdown_alerts_iframes_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CarGurusUsedCarSearchTest {

    String url = "https://www.cargurus.com";
    WebDriver driver; //can use in every method

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterClass
    public void teamDown() {
        driver.quit();

    }

    @Test
    public void searchForMinivanTest() {
        //verify on correct page by checking the title
        String expTitle = "Buy & Sell Cars: Reviews, Prices, and Financing - CarGurus";
        Assert.assertEquals(driver.getTitle(), expTitle);

// <select class="form-control cg-carPicker-makerSelect maker-select-dropdown ft-make-selector" autocomplete="off" id="carPickerUsed_makerSelect" aria-label="Select Make"> <option value="-1"

        Select make = new Select(driver.findElement(By.id("carPickerUsed_makerSelect")));
        make.selectByVisibleText("Toyota");

        //select Seinna
        //<select class="form-control cg-carPicker-modelSelect model-select-dropdown ft-model-selector" autocomplete="off" id="carPickerUsed_modelSelect" aria-label="Select
        Select model = new Select(driver.findElement(By.id("carPickerUsed_modelSelect")));
        //<option value="d308" class="selectOption">Sienna</option>
        model.selectByValue("d308");

        // type zip code - 60656
        //<input type="tel" name="zip" size="7" maxlength="7" aria-label="Zip" id="dealFinderZipUsedId_dealFinderForm" value="" placeholder="ZIP" class="form-control dealFinderZip ft-homepage-search__used-car-form__make-model__zip error">
        WebElement zipCode = driver.findElement(By.name("zip"));
        zipCode.sendKeys("60656");

// print currently selected options of make and model
        System.out.println("selected Make = " + make.getFirstSelectedOption().getText());
        System.out.println("selected Model = " + model.getFirstSelectedOption().getText());

        //<input type="submit" value="Search" id="dealFinderForm_0" class="cgBtn isolated ft-homepage-search__used-car-form__make-model__submit">

        WebElement searchButton = driver.findElement(By.id("dealFinderForm_0"));
        searchButton.click();

        //<span class="oKvYB4" data-cg-ft="page-navigation-number-of-listings">Showing <strong>1 - 15</strong> out of <strong>263</strong> listings</span>

        WebElement resultCount = driver.findElement(By.xpath("//span[@class='oKvYB4']/strong[2]"));
        System.out.println("Result Count:" + resultCount.getText());

        //assert that count is more than 0
        int count = Integer.valueOf(resultCount.getText());
        Assert.assertTrue(count > 0);


        }

    }





