package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.fasttrackit.AppConfig;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.HomePage;
import org.fasttrackit.pageobjects.ProductsGrid;
import org.openqa.selenium.support.PageFactory;

public class HomePageSteps extends TestBase {
    HomePage homePage = PageFactory.initElements(driver,HomePage.class);
    ProductsGrid productsGrid = PageFactory.initElements(driver,ProductsGrid.class);


    @Given("^I open the homepage$")
    public void iOpenTheHomepage() {
        driver.get(AppConfig.getSiteUrl());




    }

    @And("^Check the price and I open the product Chelsea Tee page$")
    public void CheckThePriceAndIOpenTheProductChelseaTeePage() {
        String regularPriceInHomePage = homePage.getRegularPriceAsTextChelseaTee().getText();
        getStepVariables().put("regularPriceInHomePage", regularPriceInHomePage);
        productsGrid.clickProductChelseaTeeHomePage();

    }

    @When("^Check the name and I open the product Chelsea Tee page$")
    public void checkTheNameAndIOpenTheProductChelseaTeePage() {

        String productNameInHomePage = homePage.getChelseaTeaNameAsText().getText();
        getStepVariables().put("productNameInHomePage",productNameInHomePage);
        productsGrid.clickProductChelseaTeeHomePage();

    }

    @And("^I open the product Lafayette dress$")
    public void iOpenTheProductLafayetteDress() {

        homePage.getProductLafayetteDressInHomePage().click();
    }

    @And("^I open \"([^\"]*)\" product page$")
    public void iOpenProductPage(String productName) {
        homePage.clickOnProduct(productName,driver);

    }
}

