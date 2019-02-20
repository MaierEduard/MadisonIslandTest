package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class RemoveItemInShoppingCartWithOneProductTest {

    @Test
    public void removeItemInShoppingCartWithOneProductTest() {

      System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://fasttrackit.org/selenium-test");
    driver.findElement(By.xpath("//div[@class='page-header-container']//img[@class='large']")).click();
    driver.findElement(By.xpath("//div[@class='product-info']//a[@href='https://fasttrackit.org/selenium-test/chelsea-tee-703.html']")).click();
    driver.findElement(By.className("option-m")).click();
    driver.findElement(By.cssSelector(".configurable-swatch-list .option-blue")).click();
    driver.findElement(By.className("add-to-cart-buttons")).click();
    String productInShoppingCart = driver.findElement(By.cssSelector(".first.odd  .product-cart-info  .product-name")).getText();
          System.out.println(productInShoppingCart);
        String msgSuccesAdded = driver.findElement(By.cssSelector(".success-msg")).getText();
        System.out.println(msgSuccesAdded);

         assertThat("Chelsea Tee was added to your shopping cart.", containsString(msgSuccesAdded));
    driver.findElement(By.cssSelector(".first.odd .a-center.product-cart-remove.last .btn-remove.btn-remove2 ")).click();
        String emptyShopingCart = driver.findElement(By.xpath("//h1['Shopping Cart is Empty']")).getText();
        System.out.println(emptyShopingCart);

        assertThat("can't remove the item from shopping cart",emptyShopingCart, containsString(emptyShopingCart.toUpperCase()));
    }
}
