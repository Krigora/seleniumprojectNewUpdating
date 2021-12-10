package com.cybertek.tests.day14_utils_webtables_properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;
import static org.testng.Assert.*;


public class WebTableDemoTest {

    WebDriver driver;
    String url = "http://practice.cybertekschool.com/tables";

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void readFromTableTest() {
        //print table data as a single String, not so common, but useful sometimes
        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println("Table 1 text = " + table1.getText());
        // verify tconway@earthlink.net
        assertTrue(table1.getText().contains("tconway@earthlink.net"));

        //print all column names in single line
        WebElement allColNames = driver.findElement(By.xpath("//table[@id='table1']/thead/tr"));
        System.out.println("Colum names: " + allColNames.getText());

        //print each column name in separete lines using a loop and findElements method
        List<WebElement> colNamesList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        System.out.println("Columns count = " + colNamesList.size());

        for (WebElement colName : colNamesList) {
            System.out.println("colName = " + colName.getText());
        }
// print first col + first cell data
        String xpathSrt = "//table[@id='table1']/tbody/tr[1]/td[1]";
        WebElement firstRowCell = driver.findElement(By.xpath(xpathSrt));
        System.out.println("firstRowCell.getText() = " + firstRowCell.getText());

        System.out.println("cal 1, row 4 = " + getCellData(1, 4));
        System.out.println("col 3 , row 3 = " + getCellData(3, 3));

    }


    @Test
    public void getAllColomnDate() {
        //print all names
        // print all emails
        List<WebElement> names = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
        List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));

        System.out.println(" ------ ALL FIRST NAMES ------");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(i + " - " + names.get(i).getText() + " " + emails.get(i).getText());
        }

        System.out.println(" ----- ALL EMAILLS -----");
        for (WebElement e : emails) {
            System.out.println(e.getText());
        }
    }

    @Test
    public void printAllTableDataTest() {
        //get rows count and assign to rowsCount variable and print it
        int rowsCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        System.out.println("rowsCount = " + rowsCount);

        for (int r = 1; r <= rowsCount; r++) {
            for(int c = 1; c <= 6; c++) {
               // String value = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+r+"]/td["+c+"]")).getText();
                String value = getCellData(r, c);
                System.out.println("value = " + value);
            }
        }
        /**
         table data -> 2 d array -> String [][] data
         table data -> list of maps list<Map>String, String> data
         table data -> list of Customer objects
         */

    }

    @Test
    public void readNeighborCell(){
        WebElement jonsEmail = driver.findElement(By.xpath("//table[@id='table1']//td[.='John']/following-sibling::td[1]"));
        System.out.println("john email = " + jonsEmail.getText());

        WebElement jonsLastName = driver.findElement(By.xpath("//table[@id='table1']//td[.='John']/preceding-sibling::td[1]"));
        System.out.println("john Last Name = " + jonsLastName.getText());

        //table[@id='table1']//td[.='Doe']/../td[4]
        //table[@id='table1']//td[.='Doe']/following-sibling::td[3]

    }

    public String getCellData(int row, int col) {
        String xpathStr = "//table[@id='table1']/tbody/tr[" + row + "]/td[" + col + "]";
        return driver.findElement(By.xpath(xpathStr)).getText();

    }

}
