package hooks;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.file.reader.TestDataReader;

import java.io.ByteArrayInputStream;

public class Hooks {
    private Browser browser;

    @Before
    public void setUp() {
        String URI = TestDataReader.getBaseUrl();
        browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo(URI);
        browser.waitForPageToLoad();
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println(scenario.getStatus());
        if (scenario.getStatus() != Status.PASSED) {
            byte[] screenshot = ((TakesScreenshot)browser.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(
                    scenario.getStatus().toString(),
                    new ByteArrayInputStream(screenshot)
            );
        }

        browser.quit();
    }
}
