package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.AppConfig;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.StringContains.containsString;

public class AddToCArtSteps extends TestBase {

    ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
    MiniCartSteps miniCartSteps = PageFactory.initElements(driver,MiniCartSteps.class);
    ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);
    ProductsGrid productsGrid = PageFactory.initElements(driver,ProductsGrid.class);
    ProductsCategory productsCategory = PageFactory.initElements(driver,ProductsCategory.class);
    WomenPage womenPage = PageFactory.initElements(driver,WomenPage.class);

    @And("^I go back to the product page$")
    public void iGoBackToTheProductPage() {
        driver.navigate().back();

    }

    @When("^I remove the first product$")
    public void iRemoveTheProduct() {
        shoppingCart.getFirstRemoveButton().click();



    }

    @Then("^the product is removed from cart$")
    public void theProductIsRemovedFromCart() {
        String msgEmptyShoppingCart = shoppingCart.getMsgEmptyShoppingCart().getText();
        assertThat("SHOPPING CART IS EMPTY",containsString(msgEmptyShoppingCart.toUpperCase()));
    }

    @When("^I remove the second product$")
    public void iRemoveTheSecondProduct() {
        String secondProductInShoppingCart = shoppingCart.getSecondProduct().getText();
        shoppingCart.getSecondRemoveButton().click();
        getStepVariables().put("secondProduct", secondProductInShoppingCart);


    }

    @Then("^the second product is removed from cart$")
    public void theSecondProductIsRemovedFromCart() {
        List<WebElement> productContain = driver.findElements(By.cssSelector(".cart-table.data-table .product-name"));
        for (WebElement products:productContain) {
          String productsName = products.getText();

          assertThat("can't remove the product", getStepVariables().get("secondProduct"), not(is(productsName)) );

    }
}

    @Then("^total price equals sum of individual prices$")
    public void totalPriceEqualsSumOfIndividualPrices() {

        String productPrice = shoppingCart.getProductPrice().getText();
        String[] splitProductPrice = productPrice.split(" ");
        String intProductPrice = splitProductPrice[0];
        intProductPrice = intProductPrice.replace(",", ".");
        double convertProductPrice = Double.parseDouble(intProductPrice);
        System.out.println(convertProductPrice);
        String productQuantity = shoppingCart.getFirstQuantityField().getAttribute("value");
        double convertProductQuantity = Double.parseDouble(productQuantity);
        System.out.println(convertProductQuantity);
        String totalPrice = shoppingCart.getSubTotalPrice().getText();
        String[] splitTotalPrice = totalPrice.split(" ");
        String intTotalPrice = splitTotalPrice[0];
        intTotalPrice = intTotalPrice.replace(",", ".");
        double convertTotalPrice = Double.parseDouble(intTotalPrice);
        System.out.println(convertTotalPrice);

        assertThat("Total price is wrong" ,convertProductPrice*convertProductQuantity, is(convertTotalPrice) );

    }


    @Then("^the \"([^\"]*)\" is the same as in \"([^\"]*)\" page$")
    public void theIsTheSameAsInPage (String productPagePrice, String productPriceInShoppinCart) {

        String shoppingCartPrice = shoppingCart.getProductPrice().getText();
        String[] splitAddToCartPrice = shoppingCartPrice.split(" ");
        String shoppingCartPriceAsText = splitAddToCartPrice[0];
        String shoppingCartPriceConverted = shoppingCartPriceAsText.replace(",", ".");

        productPriceInShoppinCart = shoppingCartPriceConverted;
        System.out.println("the regular price is : "+ getStepVariables().get("getRegularPriceFromProductPage"));
        System.out.println("shopping cart price : " + productPriceInShoppinCart);

        assertThat("The price is not the same", getStepVariables().get("getRegularPriceFromProductPage"), equalTo(productPriceInShoppinCart));
    }


    @And("^I change quantity in \"([^\"]*)\"$")
    public void iChangeQuantityIn(String numberQuantity) {

        shoppingCart.getNumberOfQuantity = numberQuantity;
        shoppingCart.chengeNumberInFirstQuantityField(numberQuantity);


    }

    @Then("^I expect the quantity of product to change$")
    public void iExpectTheQuantityOfProductToChange() {
        String quantityAfterChanged = shoppingCart.getFirstQuantityField().getAttribute("value");
        System.out.println(quantityAfterChanged);
       String quantityBeforeChanged = shoppingCart.getNumberOfQuantity;
        System.out.println(quantityBeforeChanged);
        assertThat("The Quantity is not changed",quantityAfterChanged, equalTo(quantityBeforeChanged) );
    }


    @And("^I click the update button$")
    public void iClickTheUpdateButton() throws InterruptedException {

        shoppingCart.getQuantityUpdate().click();
       Thread.sleep(5000);

    }

    @And("^I change quantity for first product in \"([^\"]*)\" and for second product in \"([^\"]*)\"$")
    public void iChangeQuantityForFirstProductInAndForSecondProductIn(String firstQuantity, String secondQuantity) {

        List<String> populateNumber = new ArrayList<>();
        populateNumber.add(firstQuantity);
        populateNumber.add(secondQuantity);
        getStepVariables().put("populateQuantityFields", populateNumber);
        System.out.println(getStepVariables().get("populateQuantityFields"));
 shoppingCart.clearAllQuantitiesFields();
 shoppingCart.getFirstQuantityField().sendKeys(firstQuantity);
 shoppingCart.getSecondQunatityField().sendKeys(secondQuantity);

    }



    @Then("^I expect the both quantity of products to change$")
    public void iExpectTheBothQuantityOfProductsToChange() {

        for (WebElement contains : shoppingCart.getQuantitiesFields()) {
            String quantitiesAttributeAfterUpdate = contains.getAttribute("value");
            System.out.println("after update " + quantitiesAttributeAfterUpdate);

           // assertThat("the Quantities is not changed", quantitiesAttributeAfterUpdate, is(getStepVariables().get("populateQuantityFields")));

        }
    }

    @When("^I click UPDATE SHOPPING CART$")
    public void iClickUPDATESHOPPINGCART() {

        shoppingCart.getUpdateShoppingCart().click();

    }

    @Then("^the total quantity is listed$")
    public void theTotalQuantityIsListed() {
        System.out.println("sum of the quantity in product page is : " + getStepVariables().get("totalQuantity"));
        String totalQuantityLikeText = shoppingCart.getFirstQuantityField().getAttribute("value");
        int totalQuantityInShoppingToCart = Integer.parseInt(totalQuantityLikeText);
            assertThat("total quantity in shopping cart is wrong ",totalQuantityInShoppingToCart, equalTo(getStepVariables().get("totalQuantity")));

    }

    @And("^I select country \"([^\"]*)\"$")
    public void iSelect(String country) {

        shoppingCart.getCountryBySelectList().selectByVisibleText(country);


    }

    @And("^I select state \"([^\"]*)\"$")
    public void iSelectState(String state) {
     shoppingCart.getStateBySelectList().selectByVisibleText(state);

    }

    @And("^I populate City field with \"([^\"]*)\"$")
    public void iPopulateCityFieldWith(String city) {
    shoppingCart.getCityField().sendKeys(city);
    }

    @And("^I populate ZIP field with \"([^\"]*)\"$")
    public void iPopulateZIPFieldWith(String zipCode) {
        shoppingCart.getZipeCodeField().sendKeys(zipCode);

    }

    @And("^I populate Discount Code field with \"([^\"]*)\"$")
    public void iPopulateDiscountCodeFieldWith(String couponCode) {
     shoppingCart.getDiscountCode().sendKeys(couponCode);

        getStepVariables().put("couponCode", couponCode);
    }

    @When("^I click the apply button$")
    public void iClickTheApplyButtonToVerifyTheDiscountCode() {
        shoppingCart.getApplyButtonForDiscontCode().click();
    }

    @Then("^I expect a confirmation message that the code is not valid$")
    public void iExpectAConfirmationMessageThatTheCodeIsNotValid() {

       String messageConfirmation = shoppingCart.getErrorMessageFromDiscountCode().getText();
       assertThat("The Discount Code it is work ",messageConfirmation, is("Coupon code \""+getStepVariables().get("couponCode")+"\" is not valid."));

    }

    @Given("^I open the homepage and I add products to cart$")
    public void iOpenTheHomepageAndIAddProductsToCart() {
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
    }

    @Then("^the product lists are the same$")
    public void theProductListsAreTheSame() throws InterruptedException {
        Thread.sleep(5000);

        for (WebElement containsName : shoppingCart.getAllProductsName()) {
            Thread.sleep(5000);
            String productsName = containsName.getText();
            System.out.println(" name from shopping cart : " + productsName);

            assertThat("the list of products is not the same", getStepVariables().get("productNameFromMiniCart"),equalTo(containsInAnyOrder(productsName)));
        }
    }

    @Then("^sum of SUB TOTAL price and TAX is the same as GRAND TOTAL price$")
    public void sumOfSUBTOTALPriceAndTAXIsTheSameAsGRANDTOTALPrice() {

       String productPrice = shoppingCart.getProductPrice().getText();
       String[] productPriceSplit = productPrice.split(" ");
        String productPriceNumber = productPriceSplit[0];
        productPriceNumber = productPriceNumber.replace(",", ".");

    }

    @When("^I click on empty cart$")
    public void iClickOnEmptyCart() {
        shoppingCart.getEmptyCartButton().click();
    }

    @Then("^I expect to shopping cart to by empty$")
    public void iExpectToShoppingCartToByEmpty() {

        String messageEmptyShoppingCart = shoppingCart.getMsgEmptyShoppingCart().getText();
        assertThat("SHOPPING CART IS EMPTY", is(messageEmptyShoppingCart.toUpperCase()));
    }

    @Then("^I expect the color to be the same$")
    public void iExpectTheColorToBeTheSame() {
        String productColorAsText = shoppingCart.getProductsColor().getText();

        assertThat("the product don't have the same color", productColorAsText, is(getStepVariables().get("titleForBlackButton")));
    }

    @When("^I click to continue to shopping$")
    public void iClickToContinueToShopping() {

        String linkHomePage = shoppingCart.getContinueToShoppingButton().getAttribute("href");
        shoppingCart.getContinueToShoppingButton().click();
        assertThat("https://fasttrackit.org/selenium-test/", is(linkHomePage));
    }

    @Then("^I expect a warning message to fill the empty field$")
    public void iExpectAWarningMessageToFillTheEmptyField() {

        String warningRequiredField = shoppingCart.getRequiredFildMessageForApplyButton().getText();
        String expectedWarning = "This is a required field.";
        assertThat("the warning is not displayed", warningRequiredField, is(expectedWarning));

    }
}
