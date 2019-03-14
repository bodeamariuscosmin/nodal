package cucumber.steps;

import cucumber.api.java.en.Given;
import framework.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import services.GeneralServices;

public class GeneralSteps extends BaseClass {

    public GeneralSteps(){}

    public GeneralSteps(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @Test
    @Given("^I navigate to \"(.*)\"$")
    public void iNavigateSite(String site) throws Throwable {
        GeneralServices generalServices = new GeneralServices(driver);

        generalServices.iNavigateSite(site);
    }

    @Test
    @Given("^the title of the page should be \"(.*)\"$")
    public void theTitleOfThePageShouldBe(String site) throws Throwable {
        GeneralServices generalServices = new GeneralServices(driver);

        generalServices.theTitleOfThePageShouldBe(site);
    }
}
