package org.fasttrackit.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart {

    @FindBy(css =".product-cart-actions .input-text.qty")
     private WebElement quantityFild;

    @FindBy(className = "cart-price")
    private WebElement productPrice;

    @FindBy(xpath = "//td[@class='product-cart-image']//img[@alt='Chelsea Tee']")
    private WebElement blueTshirtLink;

    @FindBy(css = ".first.odd .product-name")
    private WebElement productName;

    @FindBy(css = ".success-msg")
    private WebElement msgSuccessAdded;

    @FindBy(xpath = "//tr[contains(@class,'first')]//td[@class='a-center product-cart-remove last']//a[@title='Remove Item']")
    public WebElement firstRemoveButton;

    @FindBy(css = ".last.even .a-center a")
    public WebElement secondRemoveButton;

    @FindBy(className = "page-title")
    private WebElement msgEmptyShoppingCart;

    @FindBy(css = ".first.odd .product-name")
    private WebElement firstProduct;

    @FindBy(css = ".last  .product-cart-info  h2")
    private WebElement secondProduct;




    public WebElement getSecondProduct() {
        return secondProduct;
    }

    public WebElement getFirstProduct() {
        return firstProduct;
    }
    public WebElement getMsgEmptyShoppingCart() {
        return msgEmptyShoppingCart;
    }
    public WebElement getFirstRemoveButton() {
        return firstRemoveButton;
    }
    public WebElement getMsgSuccessAdded() {
        return msgSuccessAdded;
    }
    public WebElement getProductName() {
        return productName;
    }
    public WebElement getBlueTshirtLink() {
        return blueTshirtLink;
    }
    public WebElement getProductPrice() {
        return productPrice;
    }

    public WebElement getQuantityFild() {
        return quantityFild;
    }
}
