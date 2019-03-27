package org.fasttrackit.steps;

import cucumber.api.java.en.Then;
import org.fasttrackit.TestBase;

public class MiniCartSteps extends TestBase {
    @Then("^the previously stored product name is displayed in mini-cart$")
    public void thePreviouslyStoredProductNameIsDisplayedInMiniCart() {
        System.out.println("Previousely store product:" + getStepVariables().get("addToCartProductName"));

        // TODO: Implement assertion
    }
}
