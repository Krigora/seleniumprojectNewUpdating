package com.cybertek.tests.day23_fluentwait_testNg_overview;

import com.cybertek.utils.ConfigurationReader;
import org.testng.annotations.Test;

import static com.cybertek.Office_Hourse.day1.PolymerTest.driver;

public class EdmundsNewCarSearchTest {

    @Test
    public void searchForNewCarTest() {
        driver.get(ConfigurationReader.getProperty("edmunds.url"));

    }

}
