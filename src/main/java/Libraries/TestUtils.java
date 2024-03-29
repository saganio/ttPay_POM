package Libraries;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

@SuppressWarnings("ALL")
public class TestUtils extends BaseClass {

    private static Integer fluentWaitInterval = 60;

    public static Wait getFluentWait() {
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(fluentWaitInterval))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        return fluentWait;
    }

    public static void clickElementBy(By by) {
        tryFindElement(by).click();
    }

    public static void clearAndfillInFieldWith(By by, String text) {
        tryFindElement(by).clear();
        tryFindElement(by).sendKeys(text);
    }

    public static WebElement tryFindElement(By by) {
        WebElement element = (WebElement) getFluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }

    public static String getTextFromElement(By by) {
        return tryFindElement(by).getText().trim();
    }

    public static void doubleClick(WebElement element) {

        Actions action = new Actions(driver);
        action.moveToElement((WebElement) element);
        action.doubleClick();
        action.perform();

    }

    public static void swipeToElement(String text) {
        WebElement el = driver.findElement(MobileBy
                .AndroidUIAutomator("new UiScrollable(new UiSelector()).setAsVerticalList().scrollIntoView("
                                    + "new UiSelector().text(\"" + text + "\"));"));

    }

    public String dateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getRandomAlphanumericString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public String getRandomNumberAsString(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String getRandomAlphabeticString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public boolean waitUntilElementIsPresent(By by) {
        try {
            getFluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public boolean waitUntilElementClickable(By by) {
        try {
            getFluentWait().until(ExpectedConditions.elementToBeClickable(by));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public int getNumberOfResultsForElement(By by) {
        return driver.findElements(by).size();
    }

}