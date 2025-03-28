package tests.guru99;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.guru99.Guru99Page;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

public class Guru99Test {

    private WebDriver driver;
    private Guru99Page guru;
    private WebDriverWait wait;

    @BeforeEach
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        guru = new Guru99Page(driver);
    }

    @Test
    public void testGuru99Steps() {
        guru.open();

        guru.clickImageInIframe();
        wait.until(d -> d.getWindowHandles().size() > 1);

        guru.closeNewTabAndReturn();
        wait.until(d -> d.getWindowHandles().size() == 1);

        guru.submitEmail("test@example.com");
        wait.until(d -> {
            try {
                return d.switchTo().alert() != null;
            } catch (Exception e) {
                return false;
            }
        });

        String alertText = guru.getPopupTextAndAccept();
        assertTrue(alertText.toLowerCase().contains("successfully"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        guru.navigateToTooltipPage();
        assertTrue(guru.isDownloadButtonVisible());
    }

    @AfterEach
    public void tearDown() {
        // if (driver != null) {
        //     driver.quit();
        // }
    }
}
