package services;

import framework.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomepageServices extends BaseClass {

    public HomepageServices() { }

    public HomepageServices(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
