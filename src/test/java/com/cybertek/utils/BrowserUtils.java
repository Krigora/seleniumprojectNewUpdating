package com.cybertek.utils;

public class BrowserUtils {
    /**
     * this method is used to pause the code for given seconds
     * It is static method so we can call:
     * BrowserUtils.sleep(5);
     * @param second
     */
    public static void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception happened in sleep method");
        }
    }

}
