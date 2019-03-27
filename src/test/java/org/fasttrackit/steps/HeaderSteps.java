package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.Header;
import org.openqa.selenium.support.PageFactory;

public class HeaderSteps extends TestBase {

    Header header = PageFactory.initElements(driver,Header.class);


    @And("^I click on logo$")
    public void iClickOnLogo() {
        header.clickHomeLogo();

    }
}
