package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.Header;
import org.fasttrackit.pageobjects.ProductsCategory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class ProductsCategorySteps extends TestBase {

    ProductsCategory productsCategory = PageFactory.initElements(driver,ProductsCategory.class);
    Header header =PageFactory.initElements(driver, Header.class);

    @And("^I select Pants & Denim from Women category$")
    public void iSelectPantsDenimFromWomenCategory() {
        Actions actions = new Actions(driver);
        actions.moveToElement(productsCategory.womenCategory).build().perform();
        productsCategory.pantsDenimCategory.click();
    }


    @And("^I go to \"([^\"]*)\" category and I select \"([^\"]*)\"$")
    public void iGoToCategoryAndISelect(String categoryName, String subCategoryName) {
        Actions actions = new Actions(driver);
        actions.moveToElement(header.selectCategory(categoryName,driver)).build().perform();
        productsCategory.clickOnSubCategory(subCategoryName,driver);

    }
}
