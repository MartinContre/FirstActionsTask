package steps.registration;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.RegistrationForm;

public class CookiesSteps {
    private final RegistrationForm registrationForm;

    public CookiesSteps() {
        registrationForm = new RegistrationForm();
    }

    @When("^Click accept cookies button$")
    public void clickAcceptCookiesButton(){
        registrationForm.clickAcceptCookiesBtn();
    }

    @Then("^Cookies form is closed$")
    public void cookiesFormIsClosed() {
        Assert.assertFalse(registrationForm.isNotDisplayedCookies(), "Cookies form still open");
    }
}
