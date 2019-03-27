package org.fasttrackit.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsCategory {


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
