package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.Header;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HeaderSteps extends TestBase {

    Header header = PageFactory.initElements(driver,Header.class);


    @And("^I click on logo$")
    public void iClickOnLogo() {
        header.clickHomeLogo();

    }

    @When("^I click on mini-cart link to see the products$")
    public void iClickOnMiniCartLink() {
    header.getMiniCart().click();
        for (WebElement containsProduct : header.getProductNameFromMiniCart()) {
            String productName = containsProduct.getText();
            getStepVariables().put("productNameFromMiniCart", productName);
            System.out.println(" products list in mini cart : " + getStepVariables().get("productNameFromMiniCart"));
        }
    }
}
