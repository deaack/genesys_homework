package tests;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.CompletePage;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;
import pageObjects.OverviewPage;
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
    public void testFullPurchaseProcess() {
        // 1. Login
        Credential credential = CredentialReader.readCredential();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login(credential.getUsername(), credential.getPassword());

        // 2. Add items to cart
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();
        inventory.addFleeceJacketToCart();

        // 3. Check if they are there
        String itemCount = inventory.getCartItemCount();
        assertEquals("2", itemCount, "Kosárban 2 terméknek kell lennie.");

        // 4. Cart to Checkout
        inventory.goToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        // 5. Provide Checkoutt data
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterCheckoutInformation("Ben", "Tester", "1234");
        checkout.clickContinue();

        // 6. Finish order
        OverviewPage overview = new OverviewPage(driver);
        overview.clickFinish();

        // 7. check success message
        CompletePage complete = new CompletePage(driver);
        String message = complete.getThankYouMessage();
        assertEquals("Thank you for your order!", message);
    }

    @AfterEach
    public void tearDown() {
        // if (driver != null) {
        //     driver.quit();
        // }
    }
}
