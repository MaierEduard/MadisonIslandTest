package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShopingCardTest {



@Test
    public void addToCartFromShearchResultsTest() {

        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test");
        String keyword = "vase";
        driver.findElement(By.className("input-text")).sendKeys(keyword + Keys.ENTER);
    System.out.println("Pressed enter in search field");


        String heraldGlassVase = "Herald Glass Vase";


        driver.findElement(By.xpath("//div[@class='product-info' and .//a[text()='" + heraldGlassVase + "']]//button[@title='Add to Cart']")).click();

      String succesMessage = driver.findElement(By.className("success-msg")).getText();
        assertThat("Unexpected success message", succesMessage, is(heraldGlassVase + " was added to your shopping cart."));

 //   WebElement productNameInCart = driver.findElement(By.xpath())

    }




}
