package org.fasttrackit.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopBy {

    @FindBy(xpath = "//span[@class='swatch-label']//img[@title='Blue']")
    public WebElement blueColorButton;

    @FindBy(xpath ="//span[@class='swatch-label']//img[@title='Black']")
    public WebElement blackColorButton;

    @FindBy(xpath = "//dd[@class='odd']//a[contains(@href, 'price=100-200')]")
    public WebElement price100_199;

    @FindBy(xpath = "//a[contains(@href, 'price=200-')]")
    private WebElement price200Above;

    public void clickPrice200Above() {
        price200Above.click();
    }
    @FindBy(xpath = "//li//span[@class='value']")
    public WebElement priceAfterSort;





    public WebElement getPriceAfterSort() {
        return priceAfterSort;
    }
    public WebElement getPrice100_199() {
        return price100_199;
    }
    public WebElement getBlackColorButton() {
        return blackColorButton;
    }
    public WebElement getBlueColorButton() {
        return blueColorButton;
    }
}
