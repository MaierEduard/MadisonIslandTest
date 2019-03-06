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
        searchField.sendKeys(keyword);
        searchButton.click();
    }
    @FindBy(xpath = "//div[@class='page-header-container']//img[@class='large']")
    private WebElement homeLogo;

    public void clickHomeLogo() {
        homeLogo.click();
    }
    @FindBy(css = ".level0.nav-1.first.parent")
    public WebElement womenCategory;




    @FindBy(linkText = "Pants & Denim")
    public WebElement pantsDenimCategory;


    public WebElement getSearchButton() {
        return searchButton;
    }
    public WebElement getSearchField() {
        return searchField;
    }
}
