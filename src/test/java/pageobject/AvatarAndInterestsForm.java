package pageobject;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.RandomSelector;

import java.util.ArrayList;
import java.util.List;

public class AvatarAndInterestsForm extends Form {
    private final ILabel uploadLabel = getElementFactory().getLabel(
            By.xpath("//a[@class='avatar-and-interests__upload-button']"),
            "Upload avatar image"
    );
    private final String checkBoxLocator = "//div[contains(@class,'avatar-and-interests__interests-list__item')]/div/span/preceding-sibling::span";
    private final IButton nextBtn = getElementFactory().getButton(
            By.xpath("//button[text()='Next']"),
            "Next button"
    );
    private List<ICheckBox> checkBoxesAvailable = new ArrayList<>();

    public AvatarAndInterestsForm() {
        super(By.xpath("//h2[text()='This is me']"), "Avatar and interests form");
    }

    public boolean isDisplayed() {
        return state().isDisplayed();
    }

    public void clickUploadAvatarLabel() {
        uploadLabel.click();
    }

    public void checkCheckbox(int n) {
        checkBoxesAvailable = getCheckboxes();
        checkUnselectAllCheckbox();
        List<Integer> randomIndexes = RandomSelector.selectRandomIndexes(n, checkBoxesAvailable.size());

        for (int index : randomIndexes) {
            checkBoxesAvailable.get(index).check();
        }
    }

    public void clickNextBtn() {
        nextBtn.click();
    }

    private void checkUnselectAllCheckbox() {
        checkBoxesAvailable.getLast().getJsActions().scrollIntoView();
        checkBoxesAvailable.getLast().check();
        checkBoxesAvailable.removeLast();
    }

    private List<ICheckBox> getCheckboxes() {
        return getElementFactory().findElements(By.xpath(checkBoxLocator), ICheckBox.class,
                ElementsCount.MORE_THAN_ZERO, ElementState.DISPLAYED);
    }
}
