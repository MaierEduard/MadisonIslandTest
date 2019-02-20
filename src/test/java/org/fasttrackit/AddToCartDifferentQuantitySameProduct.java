package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddToCartDifferentQuantitySameProduct {
@Test
    public void addToCartDifferentQuantitySameProduct() throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://fasttrackit.org/selenium-test");
    driver.findElement(By.xpath("//div[@class='page-header-container']//img[@class='large']")).click();
    driver.findElement(By.xpath("//div[@class='product-info']//a[@href='https://fasttrackit.org/selenium-test/chelsea-tee-703.html']")).click();
    driver.findElement(By.className("option-m")).click();
    driver.findElement(By.cssSelector(".configurable-swatch-list .option-blue")).click();
    driver.findElement(By.cssSelector(".input-text.qty")).clear();
    driver.findElement(By.cssSelector(".input-text.qty")).sendKeys("2");
    String firstQuantityInProductPage = driver.findElement(By.cssSelector(".input-text.qty")).getAttribute("value");
    double convertedFirstQuantityInProductPage = Double.parseDouble(firstQuantityInProductPage);
    driver.findElement(By.className("add-to-cart-buttons")).click();
    driver.navigate().back();
    driver.findElement(By.cssSelector(".add-to-cart .qty-wrapper  .input-text.qty")).clear();
    driver.findElement(By.cssSelector(".add-to-cart .qty-wrapper  .input-text.qty")).sendKeys("3");
    String secondQuantityInProductPage = driver.findElement(By.cssSelector(".add-to-cart .qty-wrapper  .input-text.qty")).getAttribute("value");
    double convertedSecondQuantityInProductPage = Double.parseDouble(secondQuantityInProductPage);
    driver.findElement(By.className("add-to-cart-buttons")).click();
    Thread.sleep(2000);
    String totalQuantityInSoppingCart = driver.findElement(By.cssSelector(".product-cart-actions .input-text.qty")).getAttribute("value");
    double convertedTotalQuantityInSoppingCart = Double.parseDouble(totalQuantityInSoppingCart);

    assertThat("Total quantity is wrong", convertedFirstQuantityInProductPage + convertedSecondQuantityInProductPage, is(equalTo(convertedTotalQuantityInSoppingCart)));



}
}
