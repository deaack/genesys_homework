package tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import utils.SeleniumUtils;

public class ErrorAndFooterTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testErrorMessageForMandatoryFields() {
        driver.get(LoginPage.LOGINPAGE_URL + "inventory.html");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.attemptEmptyLogin();

        String errorText = loginPage.getErrorMessage();

        assertTrue(errorText.toLowerCase().contains("username is required") || errorText.toLowerCase().contains("epic sadface"),
                   "Not expected errorr message: " + errorText);
    }

    @Test
    public void testFooterContains2025AndTerms() {
        driver.get(LoginPage.LOGINPAGE_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        By footer = By.className("footer_copy");
        WebElement footerElement = SeleniumUtils.waitAndFindElement(driver, footer, Duration.ofSeconds(5));
        String footerText = footerElement.getText();

        assertTrue(footerText.contains("2025"), "Footer does not contain 2025!");
        assertTrue(footerText.contains("Terms of Service"), "Footer does not contain 'Terms of Service' expression!");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
