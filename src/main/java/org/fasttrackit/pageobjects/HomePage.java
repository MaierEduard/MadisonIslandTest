package org.fasttrackit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage{

    private WebElement getProduct(String productName, WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='widget-products']//a[contains(text(), '" + productName + "')]"));
    }

    public void clickOnProduct(String productName, WebDriver driver) {
        getProduct(productName,driver).click();
    }


    @FindBy(xpath = "//h3[@class='product-name']//a[@title='Lafayette Convertible Dress']")
    private WebElement productLafayetteDressInHomePage;

    @FindBy(id = "product-price-410-widget-new-grid")
    private WebElement regularPriceAsTextChelseaTee;

    @FindBy(xpath = "//h3[@class='product-name']//a[@title='Chelsea Tee']")
    private WebElement chelseaTeaNameAsText;



    public WebElement getChelseaTeaNameAsText() {
        return chelseaTeaNameAsText;
    }

    public WebElement getProductLafayetteDressInHomePage() {
        return productLafayetteDressInHomePage;
    }

    public WebElement getRegularPriceAsTextChelseaTee() {
        return regularPriceAsTextChelseaTee;
    }
}
