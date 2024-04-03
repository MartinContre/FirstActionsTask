package pageobject;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.RandomSelector;
import utils.TimeUtils;

import java.util.List;

public class RegistrationForm extends Form {
    private final ITextBox passwordTxtBox = getElementFactory().getTextBox(
            By.xpath("//input[contains(@placeholder, 'Password')]"), "Password text box"
    );
    private final ITextBox emailTxtBox = getElementFactory().getTextBox(
            By.xpath("//input[contains(@placeholder, 'Your email')]"), "Email text box");
    private final ITextBox domainTxtBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'Domain')]"), "Domain text box");
    private final IButton dropdownOpenerBtn = getElementFactory().getButton(By.xpath("//div[@class='dropdown__opener']"), "Dropdown opener");
    private final By dropDownList = By.className("dropdown__list-item"
    );
    private final ICheckBox termsConditionsCheckBox = getElementFactory().getCheckBox(
            By.xpath("//span[@class='checkbox__box']"),"Accept terms and conditions check box"
    );
    private final IButton nextBtn = getElementFactory().getButton(
            By.xpath("//a[@class='button--secondary']"), "Next button"
    );
    private final IButton sendBtn = getElementFactory().getButton(
            By.xpath("//button[@class='button button--solid button--blue help-form__send-to-bottom-button']"), "Send to button"
    );
    private final ILabel titleHelpFormLabel = getElementFactory().getLabel(
            By.xpath("//h2[text()='How can we help?']"), "Title help form"
    );
    private final IButton acceptCookiesBtn = getElementFactory().getButton(
            By.xpath("//button[text()='Not really, no']"),
            "Accept cookies"
    );
    private final ILabel cookiesMessageLabel = getElementFactory().getLabel(
            By.xpath("//p[@class='cookies__message']"),
            "Tittle cookies"
    );
    private final ILabel timerLabel = getElementFactory().getLabel(
            By.xpath("//*[@class='timer timer--white timer--center']"),
            "Timer label"
    );
    private List<ILabel> extensionsDomainList;

    public RegistrationForm() {
        super(By.xpath("//div[@class='login-form']"), "Login Form");
    }

    public boolean isDisplayed() {
        return state().waitForDisplayed();
    }

    public void typePassword(String password) {
        passwordTxtBox.clearAndType(password);
    }

    public void typeEmail(String email) {
        emailTxtBox.clearAndType(email);
    }

    public void typeDomain(String domain) {
        domainTxtBox.clearAndType(domain);
    }

    private void openDomainDropdownList() {
        dropdownOpenerBtn.click();
    }

    public void selectRandomExtensionDomain() {
        openDomainDropdownList();
        if (extensionsDomainList == null) {
            extensionsDomainList = getExtensiosDomainsList();
        }
        int selectedDomain = RandomSelector.selectRandomIndexes(1, extensionsDomainList.size()).getFirst();
        extensionsDomainList.get(selectedDomain).click();
    }

    public void acceptTermsAndConditions() {
        termsConditionsCheckBox.click();
    }

    public void clickNextBtn() {
        nextBtn.getJsActions().scrollIntoView();
        nextBtn.click();
    }

    public void clickSendBottomBtn() {
        sendBtn.click();
    }

    public boolean isHiddenHelpForm() {
        titleHelpFormLabel.state().waitForNotDisplayed();
        return titleHelpFormLabel.state().isDisplayed();
    }

    public void clickAcceptCookiesBtn() {
        acceptCookiesBtn.state().waitForDisplayed();
        acceptCookiesBtn.click();
    }

    public boolean isNotDisplayedCookies() {
        cookiesMessageLabel.state().waitForNotDisplayed();
        return cookiesMessageLabel.state().isDisplayed();
    }

    public String getTime() {
        return TimeUtils.deleteFirstChars(timerLabel.getText());
    }

    private List<ILabel> getExtensiosDomainsList() {
        return getElementFactory().findElements(dropDownList, ElementType.LABEL,
                ElementsCount.MORE_THAN_ZERO, ElementState.DISPLAYED);
    }
}
