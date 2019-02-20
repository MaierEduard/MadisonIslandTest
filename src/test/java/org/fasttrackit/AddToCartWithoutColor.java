package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddToCartWithoutColor {
@Test
    public void addToCartWithoutColor() {

        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test");
        driver.findElement(By.xpath("//div[@class='page-header-container']//img[@class='large']")).click();
        driver.findElement(By.xpath("//div[@class='product-info']//a[@href='https://fasttrackit.org/selenium-test/chelsea-tee-703.html']")).click();
        driver.findElement(By.className("option-m")).click();
        driver.findElement(By.className("add-to-cart-buttons")).click();
        String requiredFieldMsg = driver.findElement(By.cssSelector(".clearfix.swatch-attr  .validation-advice")).getText();
        String expectedRequiredFieldMsg = "This is a required field.";

    assertThat("Successful added to shopping cart",expectedRequiredFieldMsg ,containsString(requiredFieldMsg));
    }



}
