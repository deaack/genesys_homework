package pageObjects.htmleditor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.SeleniumUtils;

import java.time.Duration;

public class TextEditorPage {

    private WebDriver driver;

    private By boldButton = By.cssSelector("button[data-cke-tooltip-text^='Bold']");
    private By underlineButton = By.cssSelector("button[data-cke-tooltip-text^='Underline']");

    private By editorBody = By.cssSelector("div.ck-editor__editable[contenteditable='true']");

    public TextEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openEditor() {
        driver.get("https://onlinehtmleditor.dev");
    }

    public void clickBoldButton() {
        WebElement bold = SeleniumUtils.waitAndFindElement(driver, boldButton, Duration.ofSeconds(5));
        bold.click();
    }

    public void clickUnderlineButton() {
        WebElement underline = SeleniumUtils.waitAndFindElement(driver, underlineButton, Duration.ofSeconds(5));
        underline.click();
    }

    public void typeInEditor(String text) {
        WebElement body = SeleniumUtils.waitAndFindElement(driver, editorBody, Duration.ofSeconds(5));
        body.click();
        body.sendKeys(text);
    }

    public String getEditorHtmlContent() {
        WebElement body = SeleniumUtils.waitAndFindElement(driver, editorBody, Duration.ofSeconds(5));
        return body.getAttribute("innerHTML");
    }
}
