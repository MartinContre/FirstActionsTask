package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.MainPage;

public class MainPageSteps {
    private final MainPage mainPage;

    public MainPageSteps() {
        mainPage = new MainPage();
    }
    @Given("^Welcome page is open$")
    public void welcomePageIsOpen() {
        Assert.assertTrue(mainPage.isDisplayed(), "Main page is not open");
    }

    @When("^User clicks please click here to go button$")
    public void clickPleaseClickHereToGo() {
        mainPage.clickStartLink();
    }
}
