package tests;

import utils.Credential;
import utils.CredentialReader;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

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
