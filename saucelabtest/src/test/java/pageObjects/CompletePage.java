package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumUtils;

public class CompletePage {

    private final  WebDriver driver;

    private final By thankYouMessage = By.cssSelector(".complete-header");

    public CompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getThankYouMessage() {
        WebElement message = SeleniumUtils.waitAndFindElement(driver, thankYouMessage, Duration.ofSeconds(5));
        return message.getText();
    }


    
}
