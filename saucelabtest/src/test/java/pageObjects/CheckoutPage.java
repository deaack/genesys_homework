package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumUtils;

public class CheckoutPage {

    private final WebDriver driver;

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By cancelButton = By.id("canvel");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCheckoutInformation(String fname, String lname, String zip) {
        SeleniumUtils.waitAndFindElement(driver, firstName, Duration.ofSeconds(5)).sendKeys(fname);
        SeleniumUtils.waitAndFindElement(driver, lastName, Duration.ofSeconds(5)).sendKeys(lname);
        SeleniumUtils.waitAndFindElement(driver, postalCode, Duration.ofSeconds(5)).sendKeys(zip);
    }

    public void clickContinue() {
        SeleniumUtils.waitAndFindElement(driver, continueButton, Duration.ofSeconds(5)).click();
    }


}
