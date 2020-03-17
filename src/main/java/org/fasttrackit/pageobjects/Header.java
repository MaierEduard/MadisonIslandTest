package org.fasttrackit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Header {


    public WebElement selectCategory(String categoryName, WebDriver driver) {
        return driver.findElement(By.xpath("//nav[@id='nav']//a[contains(text(),'" + categoryName + "')]"));
    }


    @FindBy(css = ".mini-products-list .product-name")
    List<WebElement> productNameInMiniCart;

    @FindBy(className = "header-minicart")
    private WebElement miniCart;


    @FindBy(id="search")
    private WebElement searchField;

    @FindBy(className = "search-button")
    private WebElement searchButton;

    public void search(String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword);
        searchButton.click();
    }
    @FindBy(xpath = "//div[@class='page-header-container']//img[@class='large']")
    private WebElement homeLogo;

    public void clickHomeLogo() {
        homeLogo.click();
    }



    public List<WebElement> getProductNameFromMiniCart() {
        return productNameInMiniCart;
    }
    public WebElement getSearchButton() {
        return searchButton;
    }
    public WebElement getSearchField() {
        return searchField;
    }
    public WebElement getHomeLogo() {
        return homeLogo;
    }
    public WebElement getMiniCart() {
        return miniCart;
    }


}
