package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.AppConfig;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
//import static org.junit.Assert.assertThat;

public class HeaderSteps extends TestBase {

    Header header = PageFactory.initElements(driver, Header.class);
    ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
    ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);
    ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
    ProductsCategory productsCategory = PageFactory.initElements(driver, ProductsCategory.class);
    WomenPage womenPage = PageFactory.initElements(driver, WomenPage.class);


    @And("^I click on logo$")
    public void iClickOnLogo() {
        header.clickHomeLogo();

    }

    @When("^I click on mini-cart link to see the products$")
    public void iClickOnMiniCartLink() {

        header.getMiniCart().click();

        List<WebElement> productsInMiniCart = header.getProductNameFromMiniCart();
        String productsNameAsText = " ";

        for (WebElement contains : productsInMiniCart) {
            String productsName = contains.getText();
            productsNameAsText += productsName + " ";
        }
        getStepVariables().put("productsInMiniCart", productsNameAsText);

    }

    @When("^I click on mini-cart link to see the products test$")
    public void iClickOnMiniCartLinkToSeeTheProductsTest() {
        header.getMiniCart().click();

        List<String> miniCartProducts = new ArrayList<>();

        for (WebElement productContains : header.getProductNameFromMiniCart()) {
            String productName = productContains.getText();
            miniCartProducts.add(productName);

        }
        getStepVariables().put("mini", miniCartProducts);


    }

    @Then("^the product lists are the same test$")
    public void theProductListsAreTheSameTest() {

        List<String> asssssss = new ArrayList<>();

        for (WebElement productContains : shoppingCart.getAllProductsName()) {
            String productNameInShoppingCart = productContains.getText();
            asssssss.add(productNameInShoppingCart);


        }

        getStepVariables().put("shopping", asssssss);
        System.out.println("mini" + getStepVariables().get("mini"));
        System.out.println("shopping" + getStepVariables().get("shopping"));
        //noinspection unchecked - This is surely a list
        assertThat("product list is not the same", (List<String>) getStepVariables().get("mini"), containsInAnyOrder(((List<String>) getStepVariables().get("shopping")).toArray()));
        // assertThat("product list is not the same", asssssss, containsInAnyOrder(getStepListVariables().get("mini").toArray()));

    }

    @When("^I click on mini-cart to see the products$")
    public void iClickOnMiniCartToSeeTheProducts() {

        List<String> productsList = new ArrayList<>();

        for (WebElement contains : header.getProductNameFromMiniCart()) {
            String productsInMiniCart = contains.getText();

            productsList.add(productsInMiniCart);

            getStepVariables().put("product in mini cart", productsList);
        }


    }

    @Given("^I tried everything$")
    public void iTriedEverything() {
        driver.get(AppConfig.getSiteUrl());
        productsGrid.clickProductChelseaTeeHomePage();
        productsPage.getBlackColorButton().click();
        productsPage.getSizeM_Button().click();
        productsPage.getAddToCartButton().click();
        Actions actions = new Actions(driver);
        actions.moveToElement(productsCategory.womenCategory).build().perform();
        productsCategory.pantsDenimCategory.click();
        womenPage.productTrbecaSkinnyJean.click();
        productsPage.getBlackColorButton().click();
        productsPage.getSize28Bottun().click();
        productsPage.getAddToCartButton().click();
        header.getMiniCart().click();

        List<String> productsFromMiniCart = new ArrayList<>();

        for (WebElement contains : header.getProductNameFromMiniCart()) {
            String productsNameInMiniCart = contains.getText();
            productsFromMiniCart.add(productsNameInMiniCart);
        }
        System.out.println(productsFromMiniCart);


        List<String> productsFromShoppingCart = new ArrayList<>();

        for (WebElement contains : shoppingCart.getAllProductsName()) {
            String productsNameInShoppingCart = contains.getText();
            productsFromShoppingCart.add(productsNameInShoppingCart);
        }
        System.out.println(productsFromShoppingCart);

        assertThat(" The products list is not the same", productsFromMiniCart, containsInAnyOrder(productsFromShoppingCart.toArray()));
        assertThat(" The products list is not the same", productsFromShoppingCart, containsInAnyOrder(productsFromMiniCart.toArray()));

    }

    @Then("^I tried almost everything$")
    public void iTriedAlmostEverything() {
        driver.get(AppConfig.getSiteUrl());
        productsGrid.clickProductChelseaTeeHomePage();
        productsPage.getBlackColorButton().click();
        productsPage.getSizeM_Button().click();
        productsPage.getAddToCartButton().click();
        Actions actions = new Actions(driver);
        actions.moveToElement(productsCategory.womenCategory).build().perform();
        productsCategory.pantsDenimCategory.click();
        womenPage.productTrbecaSkinnyJean.click();
        productsPage.getBlackColorButton().click();
        productsPage.getSize28Bottun().click();
        productsPage.getAddToCartButton().click();
        header.getMiniCart().click();

        List<String> productsFromMiniCart = new ArrayList<>();

        for (WebElement contains : header.getProductNameFromMiniCart()) {
            String productsNameInMiniCart = contains.getText();
            productsFromMiniCart.add(productsNameInMiniCart);
        }
        getStepVariables().put("mini", productsFromMiniCart);
        System.out.println(productsFromMiniCart);


        List<String> productsFromShoppingCart = new ArrayList<>();

        for (WebElement contains : shoppingCart.getAllProductsName()) {
            String productsNameInShoppingCart = contains.getText();
            productsFromShoppingCart.add(productsNameInShoppingCart);
        }
        getStepVariables().put("shopping", productsFromShoppingCart);
        System.out.println(productsFromShoppingCart);

        assertThat("product list is not the same", productsFromMiniCart, containsInAnyOrder(productsFromShoppingCart.toArray()));

        //noinspection unchecked
        assertThat("product list is not the same", productsFromMiniCart, containsInAnyOrder(((List<String>) getStepVariables().get("shopping")).toArray()));

        //noinspection unchecked
        assertThat("The products list is not the same", (List<String>)getStepVariables().get("mini"), containsInAnyOrder(((List<String>)getStepVariables().get("shopping")).toArray()));
        //noinspection unchecked
        assertThat("The products list is not the same", (List<String>)getStepVariables().get("shopping"), containsInAnyOrder(((List<String>)getStepVariables().get("mini")).toArray()));
        //noinspection unchecked
        assertThat("The products list is not the same", productsFromShoppingCart, containsInAnyOrder(((List<String>)getStepVariables().get("mini")).toArray()));
        //noinspection unchecked
        assertThat("The products list is not the same", (List<String>)getStepVariables().get("shopping"), containsInAnyOrder(productsFromMiniCart.toArray()));
    }

    @Then("^I didn't tried nothing$")
    public void iDidnTTriedNothing() {

        driver.get(AppConfig.getSiteUrl());
        productsGrid.clickProductChelseaTeeHomePage();
        productsPage.getBlackColorButton().click();
        productsPage.getSizeM_Button().click();
        productsPage.getAddToCartButton().click();
        Actions actions = new Actions(driver);
        actions.moveToElement(productsCategory.womenCategory).build().perform();
        productsCategory.pantsDenimCategory.click();
        womenPage.productTrbecaSkinnyJean.click();
        productsPage.getBlackColorButton().click();
        productsPage.getSize28Bottun().click();
        productsPage.getAddToCartButton().click();
        header.getMiniCart().click();

        List<WebElement> productsInMiniCart = header.getProductNameFromMiniCart();
        String productsNameInMiniCart = "";
        for (WebElement containsProducts : productsInMiniCart) {
            String productsName = containsProducts.getText();
            productsNameInMiniCart += productsName;
        }
        System.out.println(productsNameInMiniCart);

        List<WebElement> productsInShoppingCart = shoppingCart.getAllProductsName();
        String productsNameInShoppingCart = null;
        for (WebElement containsProducts : productsInShoppingCart) {
            productsNameInShoppingCart += containsProducts.getText();
        }
        System.out.println(productsNameInShoppingCart);

//        assertThat("The products list is not the same", ((List<WebElement>)productsNameInMiniCart).toArray(), containsInAnyOrder(((List<WebElement>)(productsNameInShoppingCart)).toArray());
//        assertThat("The products list is not the same", productsNameInShoppingCart, containsInAnyOrder(productsNameInMiniCart));
//        assertThat("The products list is not the same", productsNameInShoppingCart, hasItem(productsNameInMiniCart));


    }

    @Then("^I didn't try anything$")
    public void iDidnTTryAnything() {

        driver.get(AppConfig.getSiteUrl());
        productsGrid.clickProductChelseaTeeHomePage();
        productsPage.getBlackColorButton().click();
        productsPage.getSizeM_Button().click();
        productsPage.getAddToCartButton().click();
        Actions actions = new Actions(driver);
        actions.moveToElement(productsCategory.womenCategory).build().perform();
        productsCategory.pantsDenimCategory.click();
        womenPage.productTrbecaSkinnyJean.click();
        productsPage.getBlackColorButton().click();
        productsPage.getSize28Bottun().click();
        productsPage.getAddToCartButton().click();
        header.getMiniCart().click();

    }
}
