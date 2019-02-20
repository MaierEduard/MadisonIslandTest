package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.fasttrackit.pageobjects.ProductsGrid;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class SearchTest {

    @Test
    public void searchByOneKeywordTest() {
        System.setProperty("webdriver.chrome.driver", AppConfig.getChromeDriverPath());
        WebDriver driver = new ChromeDriver();
        driver.get(AppConfig.getSiteUrl());

        Header header = PageFactory.initElements(driver, Header.class);
        String keyword = "vase";
        header.search(keyword);


        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);


        for (WebElement container : productsGrid.getProductNameContainers()) {
            String productName = container.getText();
            System.out.println(productName);
            assertThat("Some of the product names do not contain the searched keyword", productName, containsString(keyword.toUpperCase()));

        }
    }
}
