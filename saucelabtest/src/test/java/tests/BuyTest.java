package tests;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;
import utils.Credential;
import utils.CredentialReader;

public class BuyTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testPurchaseProcess() {
        // Login
        Credential credential = CredentialReader.readCredential();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login(credential.getUsername(), credential.getPassword());

        // Cart
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();
        inventory.addFleeceJacketToCart();

        // Validate
        String itemCount = inventory.getCartItemCount();
        assertEquals("2", itemCount, "2 items should be in the shopping cart");

        // Checkout
        inventory.goToCart();
    }

    @AfterEach
    public void tearDown() {
        // if (driver != null) {
        //     driver.quit();
        // }
    }
}
