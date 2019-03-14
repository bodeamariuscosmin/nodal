package cucumber.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.utils.Helpers;
import framework.BaseClass;

public class Hooks extends BaseClass {

    @Before("@test")
    public void TestInitialize()
    {
        SetUp();
    }

    @After("@test")
    public static void TearDown(Scenario scenario) throws Throwable {
        if(scenario.isFailed()) {
            scenario.write("\nCurrent URL = " + driver.getCurrentUrl());
            Helpers.takeScreenShot(scenario);
        }

        driver.quit();
    }
}
