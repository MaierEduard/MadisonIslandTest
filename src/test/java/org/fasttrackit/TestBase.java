package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.fasttrackit.pageobjects.ProductsGrid;
import org.fasttrackit.pageobjects.ShopBy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {

    protected WebDriver driver = DriverConfiguration.getDriver();

    @Before
    public void setup() {
        String browser = System.getProperty("browser" ,"chrome");

        driver = DriverConfiguration.initDriver(browser);
        driver.get(AppConfig.getSiteUrl());
        System.out.println("Opened homepage");
    }

    @After
    public void tearDown() {
        driver.quit();

    }

    public void waitForPageToLoad(long timeOutMillis) {

        do {
            long waitTime = 500;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("wait interapted.  "+ e.getMessage());
            }
            timeOutMillis -= waitTime;
            System.out.println("Waiting for page to load. Remaining millis" + timeOutMillis);
        }
        while (
        timeOutMillis > 0 && !((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    public static class SortByBlueColor {

        @Test
        public void sortByBlueColor() {
            System.setProperty("webdriver.chrome.driver", AppConfig.getChromeDriverPath());
            WebDriver driver = new ChromeDriver();
            driver.get(AppConfig.getSiteUrl());


            Header header = PageFactory.initElements(driver, Header.class);
            Actions actions = new Actions(driver);
            actions.moveToElement(header.womenCategory).build().perform();
            header.pantsDenimCategory.click();
            ShopBy shopBy = PageFactory.initElements(driver, ShopBy.class);
            shopBy.blueColorButton.click();
            String blueButton = shopBy.blueColorButton.getAttribute("alt");
            ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);


            List<WebElement> productColorContainer = productsGrid.productColorContainers;


            for (WebElement container:productColorContainer) {
                String productColor = container.getAttribute("alt");
                System.out.println(productColor);

                assertThat("The color is not the same", blueButton.toLowerCase(), is(productColor));



            }



        }


    }
}

