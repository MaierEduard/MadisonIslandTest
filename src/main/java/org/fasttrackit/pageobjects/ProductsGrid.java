package org.fasttrackit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Driver;
import java.util.List;

public class ProductsGrid {

    @FindBy(css = ".products-grid .price")
    public List<WebElement> productPriceContains;

    @FindBy(xpath = "//ul[@class='products-grid products-grid--max-4-col first last odd']//span[@class='swatch-label']//img")
    public List<WebElement> productColorContainers;

    @FindBy(css = ".product-name > a")
    private List<WebElement> productNameContainers;

    public WebElement getAddToCartButton(String productName, WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='product-info' and .//a[text()='" + productName + "']]//button[@title='Add to Cart']"));
    }
    public void addProductToCart(String productName, WebDriver driver) {
        getAddToCartButton(productName, driver).click();
    }

    @FindBy(xpath = "//div[@class='product-info']//a[@title='Chelsea Tee']")
    private WebElement productChelseaTeeHomePage;

    public void clickProductChelseaTeeHomePage() {
        productChelseaTeeHomePage.click();
    }
    @FindBy(id = "old-price-437")
    private WebElement oldPriceForModernMurrayCeramicVase;


    @FindBy(id = "product-price-437")
    private WebElement specialPriceForModernMurrayCeramicVase;




    public WebElement getSpecialPriceForModernMurrayCeramicVase() {
        return specialPriceForModernMurrayCeramicVase;
    }

    public WebElement getOldPriceForModernMurrayCeramicVase() {
        return oldPriceForModernMurrayCeramicVase;
    }
    public List<WebElement> getProductNameContainers() {
        return productNameContainers;
    }

}
