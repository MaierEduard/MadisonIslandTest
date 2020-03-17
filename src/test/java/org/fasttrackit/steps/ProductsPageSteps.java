package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.ProductsPage;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ProductsPageSteps extends TestBase {

   ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);




    @When("^I add([^\"]*)to cart$")
    public void clickAddToCartButton(String addToCartButton) {
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

    private int totalQuantity;

    @And("^I change the quantity in product page in (\\d+)$")
    public void iChangeTheQuantityIn(String quantity) {
        productsPage.clearQuantityField();
        productsPage.numberOfQuantity(quantity);
        totalQuantity += Integer.parseInt(quantity);
        getStepVariables().put("totalQuantity", totalQuantity);
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
        productsPage.getSize28Bottun().click();
    }

    @When("^I verify price and I add product to cart$")
    public void iVerifyPriceAndIAddProductToCart() {
        String productPrice = productsPage.getRegularPriceWithoutDiscount().getText();
        String[] splitProductPrice = productPrice.split(" ");
        String productPriceNumber = splitProductPrice[0];
        productPriceNumber = productPriceNumber.replace(",", ".");
        getStepVariables().put("getRegularPriceFromProductPage", productPriceNumber);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        productsPage.getAddToCartButton().click();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

    }



    @Then("^the price must be the same$")
    public void thePriceMustBeTheSame() {

        String regularPriceInProductPage = productsPage.getRegularPriceWithoutDiscount().getText();
        assertThat("the product price is not the same", getStepVariables().get("regularPriceInHomePage"), equalTo(regularPriceInProductPage));

    }

    @Then("^expect the color of the product to change in black$")
    public void expectTheColorOfTheProductToChangeInBlack() {

        String expectedColor = "https://fasttrackit.org/selenium-test/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/t/mtk004t.jpg";
        String srcForChelseaTeeBlack = productsPage.getChelseaTeeColorPicture().getAttribute("src");
        System.out.println(srcForChelseaTeeBlack);
        assertThat("the color of products has not changed",srcForChelseaTeeBlack,equalTo(expectedColor));

    }

    @Then("^expect the name Chelsea Tee to be on both pages$")
    public void expectTheNameChelseaTeeToBeOnBothPages() {

        String productName = productsPage.getProductName().getText();
        System.out.println(productName);
        assertThat("The name of product is not the same", getStepVariables().get("productNameInHomePage"),equalTo(productName));
    }


    @And("^I click on review button$")
    public void iClickOnReviewButton() {
        productsPage.getReviewButton().click();

    }

    @Then("^I expect to see reviews$")
    public void iExpectToSeeReviews() {
        String expectedResultReview = "CUSTOMER REVIEWS";
        String customerReview = productsPage.getCustomerReviewAsText().getText();

        String[] splitCustomerReview = customerReview.split("[^ ]+ [^ ] ");
        String resultReview = splitCustomerReview[0];

        System.out.println(resultReview);
       assertThat("the button review doesn't work",resultReview, equalTo(expectedResultReview));

    }

    @When("^I click on Add your review$")
    public void iClickOnAddYourReview() {
        productsPage.getAddYourReviewButton().click();
    }

    @Then("^I expect to be a field to write reviews$")
    public void iExpectToBeAFieldToWriteReviews() {

        String expectedField = "Summary of Your Review".toUpperCase();
        String reviewField = productsPage.getSummaryField().getText();

        assertThat("the button Add your review doesn't work", reviewField, equalTo(expectedField));

    }

    @And("^I select the color \"([^\"]*)\"$")
    public void iSelectTheColor(String color){
        productsPage.selectColor(color,driver);

    }

    @And("^I select size \"([^\"]*)\"$")
    public void iSelectSize(String size) {
        productsPage.selectSize(size,driver);
    }


    @And("^I add product to cart with color black$")
    public void iAddProductToCartWithColorBlack() {

        String titleForBlackButton = productsPage.getBlackColorButton().getAttribute("title");
        getStepVariables().put("titleForBlackButton", titleForBlackButton);
        productsPage.getAddToCartButton().click();

    }

    @When("^I add product to cart with color \"([^\"]*)\"$")
    public void iAddProductToCartWithColor(String color){
       String titleForBlackButton = productsPage.getAttributeColorButton(color,driver);
        getStepVariables().put("titleForBlackButton", titleForBlackButton);
        productsPage.getAddToCartButton().click();
    }
}
