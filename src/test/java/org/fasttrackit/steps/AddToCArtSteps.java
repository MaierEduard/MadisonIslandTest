package org.fasttrackit.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.ProductsPage;
import org.fasttrackit.pageobjects.ShoppingCart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class AddToCArtSteps extends TestBase {

    ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
    ProductsPage productsPage = PageFactory.initElements(driver,ProductsPage.class);

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
        secondProductInShoppingCart = secondProductInShoppingCartGetText;


    }

    @Then("^the second product is removed from cart$")
    public void theSecondProductIsRemovedFromCart() {
        List<WebElement> productContain = driver.findElements(By.cssSelector(".cart-table.data-table .product-name"));
        for (WebElement products:productContain) {
          String productsName = products.getText();

          assertThat("can't remove the product", secondProductInShoppingCartGetText, not(is(productsName)) );

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
        productPagePrice = getRegularPriceFromProductPage;

        assertThat("The price is not the same", productPagePrice, equalTo(productPriceInShoppinCart));
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
        System.out.println(populateNumber);
        populateNumberforQuantitiesFilds = populateNumber;


 shoppingCart.clearAllQuantitiesFields();
 shoppingCart.getFirstQuantityField().sendKeys(firstQuantity);
 shoppingCart.getSecondQunatityField().sendKeys(secondQuantity);

    }



    @Then("^I expect the both quantity of products to change$")
    public void iExpectTheBothQuantityOfProductsToChange() {

        for (WebElement contains : shoppingCart.getQuantitiesFields()) {
            String quantitiesAttributeAfterUpdate = contains.getAttribute("value");
            System.out.println("after update " + quantitiesAttributeAfterUpdate);

            assertThat("the Quantities is not changed", quantitiesAttributeAfterUpdate, equalTo(populateNumberforQuantitiesFilds));

        }
    }

    @When("^I click UPDATE SHOPPING CART$")
    public void iClickUPDATESHOPPINGCART() {

        shoppingCart.getUpdateShoppingCart().click();

    }

    @Then("^the total quantity is listed$")
    public void theTotalQuantityIsListed() {




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
        getCouponCodeForDiscoundCodeFild = couponCode;
    }

    @When("^I click the apply button to verify the discount code$")
    public void iClickTheApplyButtonToVerifyTheDiscountCode() {
        shoppingCart.getApplyButtonForDiscontCode().click();
    }

    @Then("^I expect a confirmation message that the code is not valid$")
    public void iExpectAConfirmationMessageThatTheCodeIsNotValid() {

       String messageConfirmation = shoppingCart.getErrorMessageFromDiscountCode().getText();
       assertThat("The Discount Code it is work ",messageConfirmation, is("Coupon code \""+getCouponCodeForDiscoundCodeFild+"\" is not valid."));




    }

}
