package org.fasttrackit.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Header {

    @FindBy(css = ".mini-products-list .product-name")
    List<WebElement> productName;

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
        return productName;
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
