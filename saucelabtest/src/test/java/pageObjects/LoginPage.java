package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumUtils;

public class LoginPage {

    private final WebDriver driver;
    public static final String LOGINPAGE_URL = "https://www.saucedemo.com/";

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
        driver.get(LOGINPAGE_URL);
    }

    public void enterUsername(String username) {
        // driver.findElement(usernameField).sendKeys(username);
        WebElement userField = SeleniumUtils.waitAndFindElement(driver, usernameField, Duration.ofSeconds(5));
        userField.sendKeys(username);
    }

    public void enterPassword(String password) {
        // driver.findElement(passwordField).sendKeys(password);
        WebElement passField = SeleniumUtils.waitAndFindElement(driver, passwordField, Duration.ofSeconds(5));
        passField.sendKeys(password);
    }

    public void clickLoginButton() {
        // driver.findElement(loginButton).click();
        WebElement loginBtn = SeleniumUtils.waitAndFindElement(driver, loginButton, Duration.ofSeconds(5));
        loginBtn.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    //Errors

    public void attemptEmptyLogin() {
        WebElement loginBtn = SeleniumUtils.waitAndFindElement(driver, loginButton, Duration.ofSeconds(5));
        loginBtn.click();
    }

    public String getErrorMessage() {
        WebElement error = SeleniumUtils.waitAndFindElement(driver, errorMessage, Duration.ofSeconds(5));
        return error.getText();
    }


}
