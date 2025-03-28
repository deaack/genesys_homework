package pageObjects.saucedemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumUtils;

public class OverviewPage {

    private final WebDriver driver;
    private final By finishButton = By.id("finish");
    private final By cancelButton = By.id("cancel");

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFinish() {
        WebElement finish = SeleniumUtils.waitAndFindElement(driver, finishButton, Duration.ofSeconds(5));
        finish.click();
    }



}
