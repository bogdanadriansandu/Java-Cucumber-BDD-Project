package my_proj_bdd.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Elements
    @FindBy(xpath = "//button[@data-testid='cookie-popup-accept']")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//h2[@data-testid='cookie-popup-title']")
    private WebElement cookieHeader;

    @FindBy(xpath = "//button[@data-testid='header-myhub-toggle']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//button[@data-testid='product-block-add']")
    private List<WebElement> addToCartButtonsAsList;

    @FindBy(xpath = "//a[@data-testid='header-minibasket']")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//button[@data-testid='modal-close-button']")
    private WebElement selectLaterButton;

    // Actions
    public void clickAcceptCookiesButton() {
        acceptCookiesButton.click();
    }

    public void openHomePage() {
        driver.get("https://www.mega-image.ro/");
    }

    public void clickMyAccountButton() {
        myAccountButton.click();
    }

    public void clickShoppingCartButton() {
        shoppingCartButton.click();
    }

    public void clickAddToCartButtonByIndex(String index) throws InterruptedException {
        // we transform index from string to int
        int index_as_int = Integer.parseInt(index);
        // we find the element
        WebElement element = addToCartButtonsAsList.get(index_as_int);
        //to perform Scroll on application using Selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)", "");
        // we click the button
        js.executeScript("arguments[0].click();", element);
        // we wait one second for the product to be added to the cart
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickSelectLaterButton() {
        try {
            // try to click on it if you find this element
            selectLaterButton.click();
        } catch (NoSuchElementException e) {
            // the test continues even if we didn't find this element
        }
    }

    // Validations
    public void validateCookieHeader() {
        Assert.assertEquals("Cookie header title is incorrect", "Cookie-uri pe mega-image.ro", cookieHeader.getText());
    }
}
