package my_proj_bdd.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    // Elements
    @FindBy(xpath = "//button[@data-testid='basket-icon-wrapper']")
    private WebElement removeProductButton;

    @FindBy(xpath = "//div[@data-testid='text-container']/p/following-sibling::p")
    private WebElement emptyCartMessage;

    // Actions
    public void clickRemoveProductButton() {
        removeProductButton.click();
    }

    // Validations
    public void validateEmptyCartMessage() {
        Assert.assertEquals("Empty cart message is incorrect", "Cosul tau este gol", emptyCartMessage.getText());
    }
}
