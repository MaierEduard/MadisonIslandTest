package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.Header;
import org.fasttrackit.pageobjects.ShoppingCart;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
//import static org.junit.Assert.assertThat;

public class HeaderSteps extends TestBase {

    Header header = PageFactory.initElements(driver, Header.class);
    ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);


    @And("^I click on logo$")
    public void iClickOnLogo() {
        header.clickHomeLogo();

    }

    @When("^I click on mini-cart link to see the products$")
    public void iClickOnMiniCartLink() {

        header.getMiniCart().click();

        List<String> productsInMiniCart = new ArrayList<>();

        for (WebElement contains : header.getProductNameFromMiniCart()) {
            String productsName = contains.getText();
            productsInMiniCart.add(productsName);

        }
        getStepListVariables().put("productsInMiniCart", productsInMiniCart);
        System.out.println("products name in mini cart " + productsInMiniCart);

    }

    @When("^I click on mini-cart link to see the products test$")
    public void iClickOnMiniCartLinkToSeeTheProductsTest() {
        header.getMiniCart().click();

        List<String> miniCartProducts = new ArrayList<>();

        for (WebElement productContains : header.getProductNameFromMiniCart()) {
            String productName = productContains.getText();
            miniCartProducts.add(productName);

        }
        getStepListVariables().put("mini", miniCartProducts);


    }

    @Then("^the product lists are the same test$")
    public void theProductListsAreTheSameTest() {

List<String> asssssss = new ArrayList<>();

        for (WebElement productContains : shoppingCart.getAllProductsName()) {
            String productNameInShoppingCart = productContains.getText();
            asssssss.add(productNameInShoppingCart);



           // assertTrue("product list is not the same", getStepListVariables().get("mini").contains(productNameInShoppingCart));
        }

        getStepListVariables().put("shopping", asssssss);
        System.out.println("mini"+getStepListVariables().get("mini"));
        System.out.println("shopping"+ getStepListVariables().get("shopping"));
        assertThat("product list is not the same", getStepListVariables().get("mini"), containsInAnyOrder(getStepListVariables().get("shopping").toArray()));
       // assertThat("product list is not the same", asssssss, containsInAnyOrder(getStepListVariables().get("mini").toArray()));

    }

}
