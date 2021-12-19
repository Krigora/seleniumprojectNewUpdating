package com.cybertek.pages.Edmund;

import static org.testng.Assert.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EdmundsCarDetailsPage extends BasePage {

    @FindBy(xpath = "//span[@class='d-inline-block']")
    public WebElement msrpRange;

    public String getMsrpRangeValue(){
        return msrpRange.getText();

    }


    @Override
    public void isCurrentPage() {
assertTrue(driver.getTitle().contains("Prices, Reviews, and Pictures | Edmunds"));


    }
}
