package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.AvatarAndInterestsForm;
import utils.UploadFileRobot;
import utils.file.reader.TestDataReader;

public class AvatarAndInterestsSteps {
    private final AvatarAndInterestsForm avatarAndInterestsForm;

    public AvatarAndInterestsSteps() {
        avatarAndInterestsForm = new AvatarAndInterestsForm();
    }

    @Then("The second card should be open")
    public void theSecondCardShouldBeOpen() {
        Assert.assertTrue(avatarAndInterestsForm.isDisplayed(), "The second card is not open");
    }

    @When("^User chooses (\\d+) random interests, upload an image, and click Next button$")
    public void chooseRandomInterestsUploadAnImageAndClickNextButton(int numberOfCheckBoxes) {
        avatarAndInterestsForm.clickUploadAvatarLabel();
        UploadFileRobot.uploadFile(TestDataReader.getPathUploadImage());

        avatarAndInterestsForm.checkCheckbox(numberOfCheckBoxes);

        avatarAndInterestsForm.clickNextBtn();
    }
}
