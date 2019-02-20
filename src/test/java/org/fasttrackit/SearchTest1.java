package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest1 {
@Test
    public void searchByOneKeyWordTest() {
    System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://fasttrackit.org/selenium-test");
    driver.findElement(By.className("input-text")).sendKeys("pants" + Keys.ENTER);



    List<WebElement> ProductNameContainer = driver.findElements(By.xpath("//h2[@class='product-name']"));


    for (WebElement container:ProductNameContainer) {
        String productsName = container.getText();
        System.out.println(productsName);
        assertThat("Some of the product names do not contain the searched keyword", productsName, containsString("PANTS"));

    }

    }


}
