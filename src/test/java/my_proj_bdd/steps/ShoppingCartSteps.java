package my_proj_bdd.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my_proj_bdd.driver.DriverManager;
import my_proj_bdd.pages.ShoppingCartPage;

public class ShoppingCartSteps extends DriverManager {

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

    @When("I click 'Remove product' button")
    public void clickRemoveProductButton() {
        shoppingCartPage.clickRemoveProductButton();
    }

    @Then("I validate empty cart message is displayed")
    public void validateEmptyCart() {
        shoppingCartPage.validateEmptyCartMessage();
    }

    @Then("I validate shopping cart url is correct")
    public void validateCartUrl() {
        shoppingCartPage.validatePageUrl("/checkout");
    }
}
