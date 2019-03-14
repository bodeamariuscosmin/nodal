package services;

import cucumber.api.PendingException;
import cucumber.pages.ContactPage;
import cucumber.utils.Helpers;
import framework.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.sql.Timestamp;

public class ContactServices extends BaseClass {

    public ContactServices() { }

    public ContactServices(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void iClickTheButtonFromTheContactPage(String button) {
        ContactPage contactPage = new ContactPage(driver);
        WebElement elementToClick;

        switch(button.toLowerCase())
        {
            case "send message":
                elementToClick = contactPage.sendMessageButton;
                break;
            case "close cookies modal":
                elementToClick = contactPage.closeCookieModal;
                break;
            default:
                throw new PendingException("Unknown button: " + button);
        }

        Helpers.clicker(elementToClick);
    }

    public void iInputInTheFromTheContactPage(String text, String field)
    {
        ContactPage contactPage = new ContactPage(driver);
        WebElement inputField;
        String textToInput;

        switch(text.toLowerCase())
        {
            case "unique name":
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                long time = timestamp.getTime();
                textToInput = "Marius" + time;
                break;
            case "too short name":
                textToInput = "A";
                break;
            case "too long name":
                textToInput = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                break;
            case "unique email":
                timestamp = new Timestamp(System.currentTimeMillis());
                time = timestamp.getTime();
                textToInput = "Marius" + time + "@test.com";
                break;
            case "invalid email":
                timestamp = new Timestamp(System.currentTimeMillis());
                time = timestamp.getTime();
                textToInput = "Marius" + time;
                break;
            default:
                textToInput = text;
        }

        switch(field.toLowerCase())
        {
            case "name":
                inputField = contactPage.nameField;
                break;
            case "email":
                inputField = contactPage.emailAddressField;
                break;
            case "message":
                inputField = contactPage.messageField;
                break;
            default:
                throw new PendingException("Unknown field: " + field);
        }

        Helpers.waiter(inputField);
        inputField.sendKeys(textToInput);
    }

    public void theFormShouldSubmittedSuccessfully(String status)
    {
        ContactPage contactPage = new ContactPage(driver);

        switch (status.toLowerCase())
        {
            case "be":
                Helpers.waiter(contactPage.messageSentText.get(0));
                Assert.assertEquals(contactPage.messageSentText.get(0).getText(), "Message sent! We will get back to you as soon as possible.");
                break;
            case "not be":
                Assert.assertTrue(contactPage.messageSentText.size() < 1);
                break;
            default:
                throw new PendingException("Unknown status: " + status);
        }
    }

    public void iShouldSeeTheWarningFor(String field)
    {
        ContactPage contactPage = new ContactPage(driver);
        String warning;

        switch(field.toLowerCase())
        {
            case "name":
                warning = contactPage.nameField.getCssValue("required");
                break;
            case "email":
                warning = contactPage.emailAddressField.getAttribute("required");
                break;
            case "message":
                warning = contactPage.messageField.getAttribute("required");
                break;
            default:
                throw new PendingException("Unknown field: " + field);
        }

//        Helpers.waiter(contactPage.placeholder);

        Assert.assertEquals(warning, "Please fill out this field.");
    }
}
