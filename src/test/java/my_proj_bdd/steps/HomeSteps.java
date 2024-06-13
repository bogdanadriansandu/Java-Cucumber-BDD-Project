package my_proj_bdd.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my_proj_bdd.driver.DriverManager;
import my_proj_bdd.pages.HomePage;

public class HomeSteps extends DriverManager {

    HomePage homePage = new HomePage(driver);

    @Given("I am a user on Mega Image home page")
    public void openHomePage() {
        homePage.openHomePage();
    }

    @Then("I validate cookie header and click accept cookies button")
    public void acceptCookies() {
        homePage.validateCookieHeader();
        homePage.clickAcceptCookiesButton();
    }

    @When("I click 'Contul meu' button")
    public void clickMyAccount() {
        homePage.clickMyAccountButton();
    }

    @When("I click 'Shopping cart' button")
    public void clickShoppingCart() {
        homePage.clickShoppingCartButton();
    }

    @When("I click 'Add to cart' button with index: (.*)$")
    public void clickAdd(String index) throws InterruptedException {
        homePage.clickAddToCartButtonByIndex(index);
        homePage.clickSelectLaterButton();
    }
}
