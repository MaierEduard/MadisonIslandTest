package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SubTotalTest {
@Test
    public void subToatForChelseaTee() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test");


        driver.findElement(By.xpath("//div[@class='page-header-container']//img[@class='large']")).click();
        driver.findElement(By.xpath("//div[@class='product-info']//a[@href='https://fasttrackit.org/selenium-test/chelsea-tee-703.html']")).click();
    driver.findElement(By.className("option-m")).click();
    driver.findElement(By.cssSelector(".configurable-swatch-list .option-blue")).click();
    driver.findElement(By.cssSelector(".input-text.qty")).clear();
    driver.findElement(By.cssSelector(".input-text.qty")).sendKeys("3");
    Thread.sleep(1000);
    driver.findElement(By.className("add-to-cart-buttons")).click();
    Thread.sleep(2000);
    String productPrice = driver.findElement(By.xpath("//td[@class='product-cart-price']//span[@class='cart-price']//span[@class='price']")).getText();
    System.out.println(productPrice);
    String[] splitProductPrice = productPrice.split(" ");
    String intProductPrice = splitProductPrice[0];
    String stringProductPrice = splitProductPrice[1];
    intProductPrice = intProductPrice.replace(",", ".");
    double convertProductPrice = Double.parseDouble(intProductPrice);
    System.out.println(convertProductPrice);

    String productQuantity = driver.findElement(By.cssSelector(".product-cart-actions .input-text.qty")).getAttribute("value");
    double convertProductQuantity = Double.parseDouble(productQuantity);
    System.out.println(convertProductQuantity);

    String totalPrice = driver.findElement(By.cssSelector(".product-cart-total span.cart-price span")).getText();
    String[] splitTotalPrice = totalPrice.split(" ");
    String intTotalPrice = splitTotalPrice[0];
    String stringTotalPrice = splitTotalPrice[1];
    intTotalPrice = intTotalPrice.replace(",", ".");
    double convertTotalPrice = Double.parseDouble(intTotalPrice);
    System.out.println(convertTotalPrice);

    assertThat("Total price is wrong" ,convertProductPrice*convertProductQuantity, is(convertTotalPrice) );



    }




}
