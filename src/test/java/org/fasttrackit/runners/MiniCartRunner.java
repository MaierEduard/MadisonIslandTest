package org.fasttrackit.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "org.fasttrackit", features = "src/test/resources/features/add-to-cart.feature", plugin = {"html:target/cucumber-html-reports", "json:target/json-reports/addToCart.json"})


public class MiniCartRunner {
}
