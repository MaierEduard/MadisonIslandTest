package org.fasttrackit;


import org.fasttrackit.pageobjects.ProductsPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class TestBase {
    protected WebDriver driver = DriverConfiguration.getDriver();


    @Before
    public void setup() {
        String browser = System.getProperty("browser", "chrome");

        driver = DriverConfiguration.initDriver(browser);
        driver.get(AppConfig.getSiteUrl());
        System.out.println("Opened homepage");
    }

    @After
    public void tearDown() {
      //  driver.quit();

    }

    public void waitForPageToLoad(long timeOutMillis) {

        do {
            long waitTime = 500;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("wait interapted.  " + e.getMessage());
            }
            timeOutMillis -= waitTime;
            System.out.println("Waiting for page to load. Remaining millis" + timeOutMillis);
        }
        while (
                timeOutMillis > 0 && !((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }


     public static String getRegularPriceFromProductPage;

    public static List populateNumberforQuantitiesFilds;

    public static String sumQuantityNumberInProductPage;

    public static String secondProductInShoppingCartGetText;

    public static String getCouponCodeForDiscoundCodeFild;

}




