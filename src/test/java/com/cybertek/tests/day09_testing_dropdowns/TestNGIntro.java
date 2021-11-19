package com.cybertek.tests.day09_testing_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGIntro {
    // can be used by each test
    String url = "https://www.etsy.com";

    @BeforeClass
    public void setUp(){
        System.out.println("@BeforeClass setUp method ......");
        System.out.println("open browser and Navigation to " + url);
        System.out.println("--------------------------------------");
    }

    @BeforeMethod
    public void setUpApp (){
        System.out.println("@BeforeMethod setUpApp method is running........");
        System.out.println("navigating back to " + url);
        System.out.println("--------------------------------------------------");
    }


    @Test(priority =  1) // run first
    public void test1() {
        System.out.println("Running test 1 .....");
        int num = 10;
        Assert.assertEquals(10, num);

    }

    @Test (priority = 2)// converts regular method to Test method
    public void myTest2() {
        System.out.println("Running my Test 2 .....");
        String name = "Bob";
        Assert.assertTrue(name.contains("b"));
    }
@AfterMethod // runs ater EVERY test
    public void tearDown(){
        System.out.println("@AfterMethod tearDown is running ......." );
        System.out.println("------------------------------------------");
    }

    @AfterClass
    public void cleanUp(){
        System.out.println("AfterClass cleanUp method is running ....");
        System.out.println("------------------------------------------");
    }


}


