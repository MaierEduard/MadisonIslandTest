package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.ProductsPage;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductsPageSteps extends TestBase {

   ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);




    @When("^I add([^\"]*)to cart$")
    public void clickAddToCartButton(String addToCartButton) throws InterruptedException {
        String productPrice = productsPage.getRegularPriceWithoutDiscount().getText();
        String[] splitProductPrice = productPrice.split(" ");
        String productPriceNumber = splitProductPrice[0];
        productPriceNumber = productPriceNumber.replace(",", ".");


        //String productPriceConverted = Double.parseDouble(productPriceNumber);

        getRegularPriceFromProductPage = productPriceNumber;

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        productsPage.getAddToCartButton().click();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);


    }

    @And("^I select the blue color and size M$")
    public void iSelectTheAnd() {
       productsPage.getBlueColorButton().click();
        productsPage.clickSizeM();

    }

    @And("^I select the black color and size M$")
    public void iSelectTheBlackColorAndSizeM() {
        productsPage.getBlackColorButton().click();
        productsPage.clickSizeM();
    }

    @And("^I change the quantity in (\\d+)$")
    public void iChangeTheQuantityIn(String quantity) {
        productsPage.clearQuantityFild();
        productsPage.numberOfQuantity(quantity);
        List<String> numbersQuantityContain = new ArrayList<>();
        numbersQuantityContain.add(quantity);
        String firstNumber = numbersQuantityContain.get(0);
        String secondNumber = numbersQuantityContain.get(1);
        String sumQuantityNumber = firstNumber+secondNumber;
        sumQuantityNumberInProductPage = sumQuantityNumber;


    }


    @And("^I select the size M$")
    public void iSelectTheSizeM() {
        productsPage.clickSizeM();
    }

    @Then("^the product is not added to cart$")
    public void theProductIsNotAddedToCart() {
        String requiredFieldMsg = productsPage.getRequiredFieldMsgFromSize().getText();
        String expectedRequiredFieldMsg = "This is a required field.";
        assertThat("Successful added to shopping cart", expectedRequiredFieldMsg, is(requiredFieldMsg));

    }

    @And("^I select the color black$")
    public void iSelectTheColorBlack() {
        productsPage.getBlackColorButton().click();
    }

    @And("^I select size 28$")
    public void iSelectSize() {
        productsPage.size28Bottun.click();
    }
}
