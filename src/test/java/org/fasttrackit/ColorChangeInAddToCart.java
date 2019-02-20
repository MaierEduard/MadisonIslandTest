package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ColorChangeInAddToCart {

@Test
    public void productColorChangeInAddToCart() {
    System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://fasttrackit.org/selenium-test");


    driver.findElement(By.xpath("//div[@class='page-header-container']//img[@class='large']")).click();
    driver.findElement(By.xpath("//div[@class='product-info']//a[@href='https://fasttrackit.org/selenium-test/chelsea-tee-703.html']")).click();
    driver.findElement(By.xpath("//ul[@id='configurable_swatch_color']//img[@src='https://fasttrackit.org/selenium-test/media/catalog/swatches/1/21x21/media/black.png']")).click();
    driver.findElement(By.cssSelector(".option-blue a span img")).click();
    driver.findElement(By.cssSelector(".option-s a")).click();
    String blueTshirt = driver.findElement(By.xpath("//ul[@class='product-image-thumbs']//img[@src='https://fasttrackit.org/selenium-test/media/catalog/product/cache/1/thumbnail/75x/9df78eab33525d08d6e5fb8d27136e95/m/t/mtk000t_2.jpg']")).getAttribute("src");
    System.out.println(blueTshirt);
    driver.findElement(By.cssSelector(".add-to-cart-buttons button span span")).click();
    System.out.println("The button Add to card was found ");
    String expectBlueTshirt = driver.findElement(By.cssSelector(".first td a img")).getAttribute("src");
    System.out.println(expectBlueTshirt);

    assertThat("The color T-shirt in imige is not the same", blueTshirt, is(expectBlueTshirt));
    driver.quit();




    }
}
