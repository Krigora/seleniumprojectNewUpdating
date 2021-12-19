package com.cybertek.pages.Edmund;

import static org.testng.Assert.*;

public class EdmundsHomePage extends BasePage {

//
    @Override
    public void isCurrentPage() {
        assertEquals(driver.getTitle(), "New Cars, Used Cars, Car Reviews and Pricing | Edmunds");

    }
}

