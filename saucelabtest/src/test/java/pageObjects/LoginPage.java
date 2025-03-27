package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import utils.SeleniumUtils;

public class LoginPage {

    private WebDriver driver;
    static final String LOGINPAGE = "https://www.saucedemo.com/";

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
        driver.get(LOGINPAGE);
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
}
