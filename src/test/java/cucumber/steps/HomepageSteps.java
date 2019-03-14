package cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.pages.HomepagePage;
import framework.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import services.GeneralServices;
import services.HomepageServices;

public class HomepageSteps extends BaseClass {

    public HomepageSteps() { }

    public HomepageSteps(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
