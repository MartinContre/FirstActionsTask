package steps;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.PersonalDetailsForm;

public class PersonalDetailsSteps {
    private final PersonalDetailsForm personalDetailsForm;

    public PersonalDetailsSteps() {
        personalDetailsForm = new PersonalDetailsForm();
    }

    @Then("^The third card is (opened|notOpened)$")
    public void theCardIsOpen(String status) {
        boolean boolStatus = status.equalsIgnoreCase("opened");
        Assert.assertEquals(personalDetailsForm.isDisplayed(), boolStatus);
    }
}
