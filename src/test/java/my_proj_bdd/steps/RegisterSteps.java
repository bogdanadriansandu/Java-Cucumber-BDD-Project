package my_proj_bdd.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my_proj_bdd.driver.DriverManager;
import my_proj_bdd.pages.RegisterPage;

public class RegisterSteps extends DriverManager {

    RegisterPage registerPage = new RegisterPage(driver);

    @When("I click 'Continua' button")
    public void clickContinue() {
        registerPage.clickContinueButton();
    }

    @When("I fill email/phone input: (.*)$")
    public void fillEmailPhone(String emailPhone) {
        registerPage.fillEmailPhoneInput(emailPhone);
    }

    @Then("I validate error message: (.*)$")
    public void validateMessage(String expectedMessage) {
        registerPage.validateErrorMessage(expectedMessage);
    }

    @When("I click 'Create account' button")
    public void clickCreateAccount() {
        registerPage.clickCreateAccountButton();
    }

    @Then("I validate register header is displayed")
    public void validateRegisterHeader() {
        registerPage.validateRegisterHeader();
    }
}
