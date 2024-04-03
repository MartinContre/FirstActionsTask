package steps.registration;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.RegistrationModel;
import org.testng.Assert;
import pageobject.RegistrationForm;
import utils.StringUtils;
import utils.file.reader.TestDataReader;

public class RegistrationSteps {
    private final RegistrationForm registrationForm;

    public RegistrationSteps() {
        registrationForm = new RegistrationForm();
    }

    @Then("^First card is open$")
    public void firstCardIsOpen() {
        Assert.assertTrue(registrationForm.isDisplayed(), "First card is not open");
    }

    @When("User inputs a random valid password, email, accept the terms of use, and click next button")
    public void inputARandomValidPasswordEmailAcceptTheTermsOfUseAndClickNextButton() {
        String email = StringUtils.generateMail(TestDataReader.getEmailLength());
        String password = StringUtils.generatePassword(TestDataReader.getPasswordLength(), email);
        String emailDomain = StringUtils.getEmailDomain();

        fillRegistrationData(password, email, emailDomain);
        acceptAndContinue();
    }

    @And("^User writes values, accept the terms of use, and click next button$")
    public void inputAcceptTheTermsOfUseAndClickNextButton(RegistrationModel registerModel) {
        fillRegistrationData(
                registerModel.getPassword(),
                registerModel.getEmail(),
                registerModel.getDomain()
        );
        acceptAndContinue();
    }

    private void fillRegistrationData(String password, String email, String emailDomain) {
        registrationForm.typePassword(password);
        registrationForm.typeEmail(email);
        registrationForm.typeDomain(emailDomain);
        registrationForm.selectRandomExtensionDomain();
    }

    private void acceptAndContinue() {
        registrationForm.acceptTermsAndConditions();
        registrationForm.clickNextBtn();
    }
}
