package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChangeColorInProductPage {

@Test
    public void multipleColorChangesAndDimensionsToProductChelseaTee() throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://fasttrackit.org/selenium-test");


    driver.findElement(By.xpath("//div[@class='page-header-container']//img[@class='large']")).click();
    driver.findElement(By.xpath("//div[@class='product-info']//a[@href='https://fasttrackit.org/selenium-test/chelsea-tee-703.html']")).click();
    driver.findElement(By.className("option-black")).click();
    String selectColorBlack = driver.findElement(By.id("select_label_color")).getText();
    Thread.sleep(1000);
    String srcForImigieBeforeSelectTheColor = driver.findElement(By.cssSelector(".gallery-image.visible")).getAttribute("src");
    System.out.println(selectColorBlack);
    assertThat("Black",is(selectColorBlack));
    System.out.println("Black color is selected");
    String srcForImigieAfterSelectTheColor = driver.findElement(By.cssSelector(".gallery-image.visible")).getAttribute("src");
    System.out.println(srcForImigieAfterSelectTheColor);
    assertThat("We select black but T-shirt is another color",srcForImigieBeforeSelectTheColor, is(srcForImigieAfterSelectTheColor));



    String srcForTshirtBlueBeforeSelectTheColor = "https://fasttrackit.org/selenium-test/media/catalog/product/cache/1/image/1800x/040ec09b1e35df139433887a97daa66f/m/t/mtk000t_4.jpg";
    driver.findElement(By.className("option-blue")).click();
    String selectColorBlue = driver.findElement(By.id("select_label_color")).getText();
    assertThat("Blue", is(selectColorBlue));
    Thread.sleep(1000);
    driver.findElement(By.cssSelector(".gallery-image.visible")).getAttribute("src");
    driver.findElement(By.className("option-m")).click();
    String srcForTshirtBlueAfterSelectTheColor = driver.findElement(By.cssSelector(".gallery-image.visible")).getAttribute("src");
    assertThat("We select blue but T-shirt is another color", srcForTshirtBlueBeforeSelectTheColor, is(srcForTshirtBlueAfterSelectTheColor));


    String srcForWhiteTshirtBeforeSelectTheColor = "https://fasttrackit.org/selenium-test/media/catalog/product/cache/1/image/1800x/040ec09b1e35df139433887a97daa66f/m/t/mtk002t_3.jpg";
    driver.findElement(By.className("option-white")).click();
    driver.findElement(By.className("option-l")).click();
    String selectColorWhite = driver.findElement(By.id("select_label_color")).getText();
    assertThat("White", is(selectColorWhite));
    Thread.sleep(1000);
    String srcForWhiteTshirAfterSelectTheColor = driver.findElement(By.cssSelector(".gallery-image.visible")).getAttribute("src");
    assertThat("We select white but T-shirt is another color",srcForWhiteTshirtBeforeSelectTheColor, is(srcForWhiteTshirAfterSelectTheColor));

    driver.findElement(By.className("option-blue")).click();
    String selectColorBlueForSecondTime = driver.findElement(By.id("select_label_color")).getText();
    assertThat("Blue", is(selectColorBlueForSecondTime));
    Thread.sleep(1000);
    driver.findElement(By.cssSelector(".gallery-image.visible")).getAttribute("src");
    driver.findElement(By.className("option-m")).click();
    String srcForTshirtBlueAfterSelectTheColorForSecondTime = driver.findElement(By.cssSelector(".gallery-image.visible")).getAttribute("src");
    assertThat("We select blue but T-shirt is another color", srcForTshirtBlueBeforeSelectTheColor, is(srcForTshirtBlueAfterSelectTheColorForSecondTime));












}


}
