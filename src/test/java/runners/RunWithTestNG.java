package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features",
        glue = "cucumber/steps/",
        format = {"pretty", "html:target/Destination"})
public class RunWithTestNG extends AbstractTestNGCucumberTests {
}