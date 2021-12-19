package com.cybertek.tests.day23_fluentwait_testNg_overview;

import com.cybertek.pages.Edmund.EdmundsHomePage;
import com.cybertek.pages.Edmund.EdmundsNewCarPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.testng.annotations.Test;

import static com.cybertek.Office_Hourse.day1.PolymerTest.driver;

public class EdmundsNewCarSearchTest extends TestBase {

    @Test
    public void searchForNewCarTest() {
        driver.get(ConfigurationReader.getProperty("edmunds.url"));
        driver.get(ConfigurationReader.getProperty("edmunds.url"));
        EdmundsHomePage homePage = new EdmundsHomePage();
        homePage.isCurrentPage();
        homePage.gotoNewCarPricingPage();  //BASEPAGE

        EdmundsNewCarPage newCarPage = new EdmundsNewCarPage();
        newCarPage.selectMake("Audi");
        newCarPage.selectModel("e-tron GT");

        //enter zipcode
        newCarPage.zipCode.clear();
        newCarPage.zipCode.sendKeys("60656");
        //click on Go
        newCarPage.goBtn.click();




    }

}
