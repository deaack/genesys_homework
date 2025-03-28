package tests.htmleditor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import pageObjects.htmleditor.TextEditorPage;

import static org.junit.jupiter.api.Assertions.*;

public class TextEditorTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testFormattedTextInRichTextEditor() throws InterruptedException {
        TextEditorPage editor = new TextEditorPage(driver);
        editor.openEditor();

        editor.clickBoldButton();
        editor.clickUnderlineButton();

        new WebDriverWait(driver, Duration.ofSeconds(1)).until(d -> true);

        editor.typeInEditor("Automation Test Example");

        new WebDriverWait(driver, Duration.ofSeconds(1)).until(d -> true);

        String html = editor.getEditorHtmlContent();

        assertTrue(html.contains("font-weight:bold"), "Not bold!");
        assertTrue(html.contains("text-decoration:underline"), "Not underlined!");
        assertTrue(html.contains("Example"), "Example text missing!");
    }

    @AfterEach
    public void tearDown() {
        // if (driver != null) {
        //     driver.quit();
        // }
    }
}
