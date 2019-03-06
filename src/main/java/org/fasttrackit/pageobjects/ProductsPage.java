package org.fasttrackit.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage {

    @FindBy(className = "option-m")
    public WebElement sizeM_Button;

    public void clickSizeM() {
            sizeM_Button.click();
    }

    @FindBy(css = ".option-s a")
    public WebElement sizeS_Button;

    @FindBy(xpath = "//a//img[contains(@src,'mtk000t_2')]")
    private WebElement blueTshirtLink;



    @FindBy(css = ".configurable-swatch-list .option-blue")
    public WebElement blueColorButton;


    @FindBy(id = "option20")
    public WebElement blackColorButton;



    @FindBy(css = ".add-to-cart .qty-wrapper  .input-text.qty")
    private WebElement quantity;

    public void clearQuantityFild() {
        quantity.clear();
    }

    public void numberOfQuantity(String number) {
        quantity.sendKeys(number);
    }

    @FindBy(className = "add-to-cart-buttons")
    public WebElement addToCartButton;

@FindBy(className = "regular-price")
    private WebElement regularPriceWithoutDiscount;

@FindBy(css = ".clearfix.swatch-attr  .validation-advice")
private WebElement requiredFieldMsgFromColor;

@FindBy(css = ".input-box .validation-advice")
private WebElement requiredFieldMsgFromSize;


    @FindBy(css = ".product-shop .product-name")
private WebElement productName;

    @FindBy(id = "swatch67")
    public WebElement size28Bottun;






    public WebElement getProductName() {
        return productName;
    }
    public WebElement getBlueTshirtLink() {
        return blueTshirtLink;
    }
    public WebElement getRequiredFieldMsgFromSize() {
        return requiredFieldMsgFromSize;
    }

    public WebElement getRequiredFieldMsgFromColor() {
        return requiredFieldMsgFromColor;
    }

    public WebElement getRegularPriceWithoutDiscount() {
        return regularPriceWithoutDiscount;
    }

    public WebElement getQuantity() {
        return quantity;
    }
}
