package org.fasttrackit.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShoppingCart {

    @FindBy()
    private WebElement subTotalPriceInCheckout;

    @FindBy(id = "advice-required-entry-coupon_code")
    private WebElement requiredFildMessageForApplyButton;

    @FindBy(xpath = "//div[@class='cart-empty']//a")
    private WebElement continueToShoppingButton;

    @FindBy(xpath = "//td//dd[text()[normalize-space(.)='Black']]")
    private WebElement productsColor;

    @FindBy(id = "empty_cart_button")
    private WebElement emptyCartButton;

    @FindBy(xpath = "//table[@id='shopping-cart-table']//h2[@class='product-name']")
    private List<WebElement> allProductsName;

    @FindBy(css = ".messages .error-msg")
    private WebElement errorMessageFromDiscountCode;

    @FindBy(className = "button-wrapper")
    private WebElement applyButtonForDiscontCode;

    @FindBy(xpath = "//button[@class='button2 btn-update' and not(contains(@style, 'visibility:hidden;'))]")
    private WebElement updateShoppingCart;

     @FindBy(css = ".last .button.btn-update")
    private WebElement quantityUpdate;


    @FindBy(css = ".first .input-text")
    private WebElement firstQuantityField;

    @FindBy(xpath = "//tr[@class='last even']//input[@class='input-text qty']")
    private WebElement secondQuantityField;

    @FindBy(css = ".last .product-cart-actions .input-text.qty")
    private WebElement secondQunatityField;

    @FindBy(css = ".product-cart-total span.cart-price span")
    private WebElement subTotalPrice;


    @FindBy(xpath = "//td[@class='product-cart-price']//span[@class='price']")
    private WebElement productPrice;

    @FindBy(xpath = "//td[@class='product-cart-image']//img[@alt='Chelsea Tee']")
    private WebElement blueTshirtLink;

    @FindBy(css = ".first.odd .product-name")
    private WebElement productName;

    @FindBy(css = ".success-msg")
    private WebElement msgSuccessAdded;

    @FindBy(xpath = "//tr[contains(@class,'first')]//td[@class='a-center product-cart-remove last']//a[@title='Remove Item']")
    private WebElement firstRemoveButton;

    @FindBy(css = ".last.even .a-center a")
    private WebElement secondRemoveButton;

    @FindBy(className = "page-title")
    private WebElement msgEmptyShoppingCart;

    @FindBy(css = ".first.odd .product-name")
    private WebElement firstProduct;

    @FindBy(css = ".last  .product-cart-info  h2")
    private WebElement secondProduct;

    public void chengeNumberInFirstQuantityField(String number) {
        getFirstQuantityField().clear();
        getFirstQuantityField().sendKeys(number);
    }





    @FindBy(xpath = "//tbody//input[@class='input-text qty']")
    private List<WebElement> quantitiesFields;


    public void clearAllQuantitiesFields() {
        for (WebElement contains : getQuantitiesFields()) {
            contains.clear();

        }
    }
    @FindBy(id = "country")
    private WebElement countryFild;

    public Select getCountryBySelectList() {
        return new Select(countryFild);
    }

    @FindBy(id = "region_id")
    private WebElement stateFild;

    public Select getStateBySelectList() {
        return new Select(stateFild);
    }

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "postcode")
    private WebElement zipeCodeField;

    @FindBy(id = "coupon_code")
    private WebElement discountCode;



 public static String getNumberOfQuantity;


    public WebElement getSecondRemoveButton() {
        return secondRemoveButton;
    }

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

    public WebElement getSubTotalPrice() {
        return subTotalPrice;
    }

    public WebElement getFirstQuantityField() {
        return firstQuantityField;
    }


    public List<WebElement> getQuantitiesFields() {
        return quantitiesFields;
    }

    public WebElement getSecondQunatityField() {
        return secondQunatityField;
    }

    public WebElement getQuantityUpdate() {
        return quantityUpdate;
    }

    public WebElement getCountryFild() {
        return countryFild;
    }

    public WebElement getStateFild() {
        return stateFild;
    }

    public WebElement getCityField() {
        return cityField;
    }

    public WebElement getZipeCodeField() {
        return zipeCodeField;
    }

    public WebElement getDiscountCode() {
        return discountCode;
    }

    public WebElement getApplyButtonForDiscontCode() {
        return applyButtonForDiscontCode;
    }

    public WebElement getErrorMessageFromDiscountCode() {
        return errorMessageFromDiscountCode;
    }
    public List<WebElement> getAllProductsName() {
        return allProductsName;
    }

    public WebElement getEmptyCartButton() {
        return emptyCartButton;
    }

    public WebElement getProductsColor() {
        return productsColor;
    }

    public WebElement getContinueToShoppingButton() {
        return continueToShoppingButton;
    }

    public WebElement getRequiredFildMessageForApplyButton() {
        return requiredFildMessageForApplyButton;
    }

    public WebElement getSecondQuantityField() {
        return secondQuantityField;
    }

    public WebElement getUpdateShoppingCart() {
        return updateShoppingCart;
    }
}
