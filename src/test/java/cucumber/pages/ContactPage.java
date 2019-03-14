package cucumber.pages;

import framework.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactPage extends BaseClass {

    @FindBy(id = "name")
    public WebElement nameField;

    @FindBy(id = "emailAddress")
    public WebElement emailAddressField;

    @FindBy(id = "message")
    public WebElement messageField;

    @FindBy(css = "[type=\"submit\"]")
    public WebElement sendMessageButton;

    @FindBy(css = "div.Alert-module--Alert--QMVl6.Alert-module--success--1vesg")
    public List<WebElement> messageSentText;

    @FindBy(css = "button.CookieNotice-module--CookieNoticeAction--tL4tg")
    public WebElement closeCookieModal;

    public ContactPage() { }

    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
