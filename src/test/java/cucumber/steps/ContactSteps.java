package cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import services.ContactServices;

public class ContactSteps extends BaseClass {

    public ContactSteps() { }

    public ContactSteps(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @When("I click the \"(.*)\" button from the Contact page")
    public static void iClickTheButtonFromTheContactPage(String button) throws InterruptedException {
        ContactServices contactServices = new ContactServices(driver);

        contactServices.iClickTheButtonFromTheContactPage(button);
    }

    @When("I input \"(.*)\" in the \"(.*)\" field from the Contact page")
    public static void iInputInTheFromTheContactPage(String text, String field) throws InterruptedException {
        ContactServices contactServices = new ContactServices(driver);

        contactServices.iInputInTheFromTheContactPage(text, field);
    }

    @Then("the form should \"(.*)\" submitted successfully")
    public static void theFormShouldSubmittedSuccessfully(String status) throws InterruptedException {
        ContactServices contactServices = new ContactServices(driver);

        contactServices.theFormShouldSubmittedSuccessfully(status);
    }

    @Then("I should see the warning for \"(.*)\"")
    public static void iShouldSeeTheWarningFor(String field) throws InterruptedException {
        ContactServices contactServices = new ContactServices(driver);

        contactServices.iShouldSeeTheWarningFor(field);
    }
}
