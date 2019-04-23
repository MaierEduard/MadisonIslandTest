package org.fasttrackit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsCategory {

    public WebElement subCategory(String subCategoryName, WebDriver driver) {
        return driver.findElement(By.xpath("//ul[@class='level0']//a[contains(text(),'" + subCategoryName + "')]"));
    }

    public void clickOnSubCategory(String subCategoryName, WebDriver driver) {
        subCategory(subCategoryName, driver).click();
    }

    @FindBy(css = ".level0.nav-1.first.parent")
    public WebElement womenCategory;

    @FindBy(linkText = "Pants & Denim")
    public WebElement pantsDenimCategory;



    public WebElement getWomenCategory() {
        return womenCategory;
    }

    public WebElement getPantsDenimCategory() {
        return pantsDenimCategory;
    }
}
