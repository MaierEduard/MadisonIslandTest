package org.fasttrackit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage {

    private WebElement getSizeButton(String size, WebDriver driver) {
        return driver.findElement(By.xpath("//ul[@id='configurable_swatch_size']//span[contains(text(),'" + size + "')]"));
    }

    public void selectSize(String size, WebDriver driver) {
        getSizeButton(size, driver).click();
    }

    public WebElement getColorButton(String color, WebDriver driver) {
        return driver.findElement(By.xpath("//ul[@id='configurable_swatch_color']//img[@alt='" + color + "']"));
    }

    public void selectColor(String color, WebDriver driver) {
        getColorButton(color, driver).click();
    }

    public String getAttributeColorButton(String color, WebDriver driver) {
       String titleForColorButton = getColorButton(color, driver).getAttribute("title");
        return color;
    }

    @FindBy(xpath = "//li[@class='inline-label']//label[@for='summary_field']")
    private WebElement summaryField;

    @FindBy(xpath = "//p[@class='rating-links']//a[contains(text(),'Add Your Review')]")
    private WebElement addYourReviewButton;

    @FindBy(xpath = "//div[@class='review-heading']//h2[contains(text(), 'Customer Reviews')]")
    private WebElement customerReviewAsText;

    @FindBy(className = "back-link")
    private WebElement backToMainProductInfoButton;

    @FindBy(xpath = "//p[@class='rating-links']//a[contains(text(), 'Review(s)')]")
    private WebElement reviewButton;

    @FindBy(css = ".gallery-image.visible")
    private WebElement chelseaTeeColorPicture;


    @FindBy(className = "option-m")
    private WebElement sizeM_Button;

    public void clickSizeM() {
        sizeM_Button.click();
    }

    @FindBy(css = ".option-s a")
    private WebElement sizeS_Button;

    @FindBy(xpath = "//a//img[contains(@src,'mtk000t_2')]")
    private WebElement blueTshirtLink;


    @FindBy(css = ".configurable-swatch-list .option-blue")
    private WebElement blueColorButton;


    @FindBy(id = "swatch20")
    private WebElement blackColorButton;


    @FindBy(css = ".add-to-cart .qty-wrapper  .input-text.qty")
    private WebElement quantity;

    public void clearQuantityFild() {
        quantity.clear();
    }

    public void numberOfQuantity(String number) {
        quantity.sendKeys(number);
    }

    @FindBy(className = "add-to-cart-buttons")
    private WebElement addToCartButton;

    @FindBy(className = "regular-price")
    private WebElement regularPriceWithoutDiscount;



    @FindBy(css = ".clearfix.swatch-attr  .validation-advice")
    private WebElement requiredFieldMsgFromColor;

    @FindBy(css = ".input-box .validation-advice")
    private WebElement requiredFieldMsgFromSize;


    @FindBy(css = ".product-shop .product-name")
    private WebElement productName;

    @FindBy(id = "swatch67")
    private WebElement size28Bottun;


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

    public WebElement getSizeM_Button() {
        return sizeM_Button;
    }

    public WebElement getSizeS_Button() {
        return sizeS_Button;
    }

    public WebElement getBlueColorButton() {
        return blueColorButton;
    }

    public WebElement getBlackColorButton() {
        return blackColorButton;
    }

    public WebElement getChelseaTeeColorPicture() {
        return chelseaTeeColorPicture;
    }

    public WebElement getReviewButton() {
        return reviewButton;
    }

    public WebElement getBackToMainProductInfoButton() {
        return backToMainProductInfoButton;
    }

    public WebElement getCustomerReviewAsText() {
        return customerReviewAsText;
    }

    public WebElement getAddYourReviewButton() {
        return addYourReviewButton;
    }

    public WebElement getSummaryField() {
        return summaryField;
    }

    public WebElement getSize28Bottun() {
        return size28Bottun;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }
}
