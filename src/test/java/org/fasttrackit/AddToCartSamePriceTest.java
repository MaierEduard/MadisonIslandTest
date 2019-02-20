package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddToCartSamePriceTest {

@Test
    public void addToCartFromProdactPage_samePrice() {
    System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://fasttrackit.org/selenium-test");


    driver.findElement(By.className("large")).click();
    driver.findElement(By.linkText("CHELSEA TEE")).click();
    driver.findElement(By.id("option27")).click();
    driver.findElement(By.className("option-m")).click();
    String prodactPrice = driver.findElement(By.className("regular-price")).getText();
    driver.findElement(By.className("add-to-cart-buttons")).click();
    String addToCartPrice = driver.findElement(By.className("cart-price")).getText();

    String[] splitProdactPrice = prodactPrice.split(" ");
    String prodactPriceNumber = splitProdactPrice[0];
    String prodactPriceString = splitProdactPrice[1];
    prodactPriceNumber = prodactPriceNumber.replace(",", ".");

    String[] splitAddToCartPrice = addToCartPrice.split(" ");
    String addToCartNumber = splitAddToCartPrice[0];
    String addToCartString = splitAddToCartPrice[1];
    addToCartNumber = addToCartNumber.replace(",", ".");
    System.out.println(prodactPriceNumber + "  "+ addToCartPrice);

    assertThat("The price is not the same", prodactPriceNumber, equalTo(addToCartNumber));

    driver.quit();



    }


}
