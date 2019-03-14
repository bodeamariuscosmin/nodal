package services;

import cucumber.api.PendingException;
import framework.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GeneralServices extends BaseClass {

    public GeneralServices() { }

    public GeneralServices(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void iNavigateSite(String site) {
        String url = null;

        switch (site.toLowerCase()) {
            case "homepage":
                url = "";
                break;
            case "contact page":
                url = "/contact";
                break;
            default:
                throw new PendingException("Unknown URL: " + url);
        }

        driver.navigate().to(baseUrl + url);
    }

    public void theTitleOfThePageShouldBe(String expectedTitle)
    {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
}
