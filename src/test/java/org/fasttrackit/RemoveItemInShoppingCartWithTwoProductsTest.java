package org.fasttrackit;

import javafx.scene.effect.DisplacementMap;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RemoveItemInShoppingCartWithTwoProductsTest {
@Test
    public void firstRemoveItemInShoppingCartWithTwoProducts() {

    System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://fasttrackit.org/selenium-test");
    driver.findElement(By.xpath("//div[@class='page-header-container']//img[@class='large']")).click();
    driver.findElement(By.xpath("//div[@class='product-info']//a[@href='https://fasttrackit.org/selenium-test/chelsea-tee-703.html']")).click();
    driver.findElement(By.className("option-m")).click();
    driver.findElement(By.cssSelector(".configurable-swatch-list .option-blue")).click();
    driver.findElement(By.className("add-to-cart-buttons")).click();
    WebElement firstProductInShoppingCart = driver.findElement(By.cssSelector(".first.odd  .product-cart-info  .product-name"));
    String first = firstProductInShoppingCart.getText();
    driver.findElement(By.xpath("//div[@class='page-header-container']//img[@class='large']")).click();
    driver.findElement(By.linkText("LAFAYETTE CONVERTIBLE DRESS")).click();
    driver.findElement(By.xpath("//span[@class='swatch-label']")).click();
    driver.findElement(By.className("option-10")).click();
    driver.findElement(By.cssSelector(".configurable-swatch-list .option-blue")).click();
    driver.findElement(By.className("add-to-cart-buttons")).click();
    String secodProductInShoppingCart = driver.findElement(By.cssSelector(".last  .product-cart-info  h2")).getText();
    System.out.println(secodProductInShoppingCart);

    driver.findElement(By.cssSelector(".first.odd .a-center.product-cart-remove.last .btn-remove.btn-remove2 ")).click();

    //assertThat("can't remove the item from shopping cart", first, is(not(Display)));





}
}
