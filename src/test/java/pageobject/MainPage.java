package pageobject;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {
    private final ILink startLink = getElementFactory().getLink(
            By.className("start__link"),
            "Start link"
    );

    public MainPage() {
        super(By.xpath("//p[@class='start__paragraph'][contains(text(),'Hi and welcome')]"), "Welcome page");
    }

    public boolean isDisplayed() {
        return state().waitForDisplayed();
    }

    public void clickStartLink() {
        startLink.click();
    }
}
