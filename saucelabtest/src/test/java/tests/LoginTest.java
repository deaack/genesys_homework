package tests;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import utils.Credential;
import utils.CredentialReader;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.firefoxdriver().setup(); //automatic Webdriver handle
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Disabled
    @Test
    public void testLoginWithValidCredentials() {
        Credential credential = CredentialReader.readCredential();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login(credential.getUsername(), credential.getPassword());

        assertTrue(driver.getCurrentUrl().contains("inventory"), "Successful login.");
    }

    @AfterEach
    public void tearDown() {
        // if (driver != null) {
        //     driver.quit();
        // }
    }
}
