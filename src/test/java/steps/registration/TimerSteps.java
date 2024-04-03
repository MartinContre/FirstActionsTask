package steps.registration;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.RegistrationForm;

public class TimerSteps {
    private final RegistrationForm registrationForm;
    public TimerSteps() {
        registrationForm = new RegistrationForm();
    }

    @Then("^Timer starts from \"([^\"]*)\"$")
    public void timerStartsFrom(String time) {
        Assert.assertTrue(registrationForm.isDisplayed(), "The first card is not open");

        String actualTime = registrationForm.getTime();

        Assert.assertEquals(actualTime, time, String.format("Timer started in: %s", actualTime));
    }
}
