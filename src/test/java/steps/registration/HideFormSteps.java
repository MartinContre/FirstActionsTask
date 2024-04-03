package steps.registration;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.RegistrationForm;

public class HideFormSteps {
    private final RegistrationForm registrationForm;

    public HideFormSteps() {
        registrationForm= new RegistrationForm();
    }

    @When("^User clicks hide help form$")
    public void clickHideHelpForm() {
        registrationForm.clickSendBottomBtn();
    }

    @Then("^Form content is hidden$")
    public void formContentIsHidden() {
        Assert.assertFalse(registrationForm.isHiddenHelpForm());
    }
}
