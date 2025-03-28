package pageObjects.guru99;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.SeleniumUtils;

import java.time.Duration;
import java.util.Set;

public class Guru99Page {

    private WebDriver driver;

    private By iframe = By.cssSelector("iframe:not([src*='youtube'])");
    private By imageInIframe = By.cssSelector("a > img");

    private By emailField = By.id("philadelphia-field-email");
    private By submitButton = By.id("philadelphia-field-submit");

    private By seleniumMenu = By.xpath("//li[@class='dropdown']/a[text()='Selenium']");
    private By tooltipOption = By.xpath("//ul[@class='dropdown-menu']//a[text()='Tooltip']");

    private By downloadButton = By.xpath("//a[contains(text(), 'Download now')]");

    public Guru99Page(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://demo.guru99.com/test/guru99home");
    }

    public void clickImageInIframe() {
        WebElement frame = SeleniumUtils.waitAndFindElement(driver, iframe, Duration.ofSeconds(10));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", frame);
        driver.switchTo().frame(frame);

        WebElement img = SeleniumUtils.waitAndFindElement(driver, imageInIframe, Duration.ofSeconds(10));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", img);
        img.click();

        driver.switchTo().defaultContent();
    }

    public void closeNewTabAndReturn() {
        String mainHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();

        for (String handle : handles) {
            if (!handle.equals(mainHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }

        driver.switchTo().window(mainHandle);
    }

    public void submitEmail(String email) {
        WebElement emailInput = SeleniumUtils.waitAndFindElement(driver, emailField, Duration.ofSeconds(5));
        emailInput.sendKeys(email);

        WebElement submitBtn = SeleniumUtils.waitAndFindElement(driver, submitButton, Duration.ofSeconds(5));
        submitBtn.click();
    }

    public String getPopupTextAndAccept() {
        Alert alert = SeleniumUtils.waitForAlert(driver, Duration.ofSeconds(5));
        String text = alert.getText();
        alert.accept();
        return text;
    }

    public void navigateToTooltipPage() {
        WebElement menu = SeleniumUtils.waitAndFindElement(driver, seleniumMenu, Duration.ofSeconds(5));
        WebElement tooltip = SeleniumUtils.waitAndFindElement(driver, tooltipOption, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).pause(500).moveToElement(tooltip).click().build().perform();
    }

    public boolean isDownloadButtonVisible() {
        WebElement btn = SeleniumUtils.waitAndFindElement(driver, downloadButton, Duration.ofSeconds(5));
        return btn.isDisplayed();
    }
}
