package org.fasttrackit.steps;

//import cucumber.api.java8.En;

import org.fasttrackit.TestBase;

import java.util.Map;
import java.util.stream.Stream;

public class Test extends TestBase {

    String text1 = "edy1";
    String text2 = "edy2";
@org.junit.Test
    public void map() {
        getStepVariables().put(text1, "text1");
        getStepVariables().put(text2, "text2");

        Stream<Map.Entry<String, Object>> entryStream = getStepVariables().entrySet().stream().filter(something -> something.getKey().equals(text1));
//        System.out.println(entryStream.);
    }


//        implements En {
//    private int budget = 0;
//    public Test() {
//        Given("^I have \"([^\"]*)\" RON in my wallet$", (String money) -> {
//            int intMoney = Integer.parseInt(money);
//            budget = intMoney;
//        });
//        When("^I buy milk with \"([^\"]*)\"$", (String productPrice) -> {
//            int intProductPrice = Integer.parseInt(productPrice);
//            budget -= intProductPrice;
//        });
//        Then("^I should have \"([^\"]*)\" in my wallet$", (String expectedBudget) -> {
//            int intExpectedBudget = Integer.parseInt(expectedBudget);
//            if (budget > intExpectedBudget) {
//                assertThat("The budget is greater then I expected", budget, is(equalTo(intExpectedBudget)));
//            } else if (budget < intExpectedBudget){
//                assertThat("The budget is less then I expected", budget, is(equalTo(intExpectedBudget)));
//            }
//            assertThat("the final budget is wrong", budget, is(equalTo(intExpectedBudget)));
//        });
//
//    }
}

