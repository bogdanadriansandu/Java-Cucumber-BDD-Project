package my_proj_bdd.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Elements
    @FindBy(xpath = "//button[@data-testid='submit-button']")
    private WebElement continueButton;

    @FindBy(xpath = "//p[@data-testid='form-error-message']")
    private WebElement validationErrorMessage;

    @FindBy(xpath = "//input[@id='emailOrPhoneNumber']")
    private WebElement emailPhoneInput;

    @FindBy(xpath = "//h2[@data-testid='create-account-title']")
    private WebElement registerHeader;

    @FindBy(xpath = "//button[@data-testid='welcome-confirmation-modal-create-an-account-button']")
    private WebElement createAccountButton;

    // Actions
    public void clickContinueButton() {
        continueButton.click();
    }

    public void fillEmailPhoneInput(String emailPhone) {
        emailPhoneInput.sendKeys(emailPhone);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    // Validations
    public void validateErrorMessage(String expectedMessage) {
        Assert.assertEquals("Validation message is incorrect", expectedMessage, validationErrorMessage.getText());
    }

    public void validateRegisterHeader() {
        Assert.assertEquals("Register header is incorrect", "Creeaza un cont nou", registerHeader.getText());
    }
}
