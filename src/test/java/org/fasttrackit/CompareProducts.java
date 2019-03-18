package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.fasttrackit.pageobjects.ProductsGrid;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class CompareProducts extends TestBase {

    @Test
    public void compareProducts() throws InterruptedException {

        Header header = PageFactory.initElements(driver, Header.class);
        Actions actions = new Actions(driver);
        actions.moveToElement(header.womenCategory).build().perform();
        header.pantsDenimCategory.click();
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);

        String linkDumbo = Keys.chord(Keys.CONTROL, Keys.RETURN);
        driver.findElement(By.linkText("DUMBO BOYFRIEND JEAN")).sendKeys(linkDumbo);

        String linkParkAvenue = Keys.chord(Keys.CONTROL, Keys.RETURN);
        driver.findElement(By.linkText("PARK AVENUE PLEAT FRONT TROUSERS")).sendKeys(linkParkAvenue);
        Thread.sleep(5000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String firstProduct = driver.findElement(By.xpath("//div[@class='product-name']//span")).getText();
        System.out.println(firstProduct);
        driver.findElement(By.linkText("Add to Compare")).click();
        String succesMsgAddToCompare = driver.findElement(By.className("success-msg")).getText();
        System.out.println(succesMsgAddToCompare);
        assertThat(succesMsgAddToCompare, containsString("has been added to comparison list."));
        driver.close();

        driver.switchTo().window(tabs.get(2));
        String secondProduct = driver.findElement(By.xpath("//div[@class='product-name']//span")).getText();
        System.out.println(secondProduct);
        driver.findElement(By.linkText("Add to Compare")).click();
        System.out.println(succesMsgAddToCompare);
        assertThat(succesMsgAddToCompare, is(endsWith("has been added to comparison list.")));
        driver.close();

        driver.switchTo().window(tabs.get(0));
        driver.navigate().refresh();

//        List<WebElement> productsCopare = driver.findElements(By.cssSelector("#compare-items"));
//        for (WebElement contains : productsCopare) {
//            String productsName = contains.getText();
//            System.out.println(productsName);

        ArrayList<String> prodName = new ArrayList<>();
        prodName.add(firstProduct);
        prodName.add(secondProduct);
        System.out.println("this is nckscnwnwcbdc " + prodName);

        driver.findElement(By.xpath("//div[@class='block-content']//button[@title='Compare']")).click();

        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        Thread.sleep(5000);
        driver.get("https://fasttrackit.org/selenium-test/catalog/product_compare/index/");
        driver.manage().window().maximize();
        List<WebElement> productInCompare = driver.findElements(By.className("product-name"));
        for (WebElement products : productInCompare) {
            String productsNameInCopare = products.getText();
            System.out.println("this is a text...." + productsNameInCopare);
            assertThat("the products not display in add to compare  " + prodName, containsString(productsNameInCopare));

        }


    }
}


