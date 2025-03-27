package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import utils.SeleniumUtils;

public class InventoryPage {

    private WebDriver driver;

    private By cartBadge = By.className("shopping_cart_badge");

    private By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By addFleeceJacketButton = By.id("add-to-cart-sauce-labs-fleece-jacket");

    private By cartIcon = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBackpackToCart() {
        // driver.findElement(addBackpackButton).click();
        WebElement btn = SeleniumUtils.waitAndFindElement(driver, addBackpackButton, Duration.ofSeconds(5));
        btn.click();
    }

    public void addFleeceJacketToCart() {
        // driver.findElement(addFleeceJacketButton).click();
        WebElement btn = SeleniumUtils.waitAndFindElement(driver, addFleeceJacketButton, Duration.ofSeconds(5));
        btn.click();
    }

    public String getCartItemCount() {
        // return driver.findElement(cartBadge).getText();
        WebElement badge = SeleniumUtils.waitAndFindElement(driver, cartBadge, Duration.ofSeconds(5));
        return badge.getText();
    }

    public void goToCart() {
        // driver.findElement(cartIcon).click();
        WebElement cart = SeleniumUtils.waitAndFindElement(driver, cartIcon, Duration.ofSeconds(5));
        cart.click();
    }
}
