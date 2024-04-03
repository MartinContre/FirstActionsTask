package pageobject;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsForm extends Form {
    public PersonalDetailsForm() {
        super(
                By.xpath("//h3[text()='Personal details']"),
                "Personal details form"
        );
    }

    public boolean isDisplayed() {
        Browser browser = AqualityServices.getBrowser();
        browser.waitForPageToLoad();
        return state().isDisplayed();
    }
}
