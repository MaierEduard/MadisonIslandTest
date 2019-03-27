package org.fasttrackit.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Header {


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

    public WebElement getSearchButton() {
        return searchButton;
    }
    public WebElement getSearchField() {
        return searchField;
    }
    public WebElement getHomeLogo() {
        return homeLogo;
    }
}
