package org.fasttrackit.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.fasttrackit.DriverConfiguration;


public class Hooks {


    @Before
    public void setup(Scenario scenario) {
        String browser = System.getProperty("browser" ,"chrome");
        DriverConfiguration.initDriver(browser);

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(500);
       // DriverConfiguration.getDriver().quit();

    }
}
