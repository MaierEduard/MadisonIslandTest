package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class DiscountPriceTest {

    @Test
    public void discountPriceTest() {

        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test");
        String keyword = "vase";
        driver.findElement(By.className("input-text")).sendKeys(keyword + Keys.ENTER);
        System.out.println("Press enter in search fild");

        String oldPrice = driver.findElement(By.id("old-price-437")).getText();
        String specialPrice = driver.findElement(By.id("product-price-437")).getText();
        System.out.println(oldPrice + specialPrice);

        String[] oldPriceSplit = oldPrice.split(" ");
        String oldPriceNumber = oldPriceSplit[0];
        String oldPriceString = oldPriceSplit[1];

        oldPriceNumber = oldPriceNumber.replace(",", ".");

        String[] specialPriceSplit = specialPrice.split(" ");
        String specialPriceNumber = specialPriceSplit[0];
        String specialPriceString = specialPriceSplit[1];

        specialPriceNumber = specialPriceNumber.replace(",", ".");


        System.out.println(oldPriceNumber + specialPriceNumber);
        double convertedOldPriceNumber = Double.parseDouble(oldPriceNumber);
        double convertedSpecialPriceNumber = Double.parseDouble(specialPriceNumber);

        assertThat("the product is not on sale", convertedSpecialPriceNumber, lessThan(convertedOldPriceNumber));


        }



    }





