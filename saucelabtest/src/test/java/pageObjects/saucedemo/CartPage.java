package pageObjects.saucedemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumUtils;

public class CartPage {

    private final WebDriver driver;

    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckout() {
        WebElement btn = SeleniumUtils.waitAndFindElement(driver, checkoutButton, Duration.ofSeconds(5));
        btn.click();
    }

    
}
