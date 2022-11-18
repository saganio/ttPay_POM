package Libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * Created by uguryildiz on 18.11.2022
 */
public class EventHandler implements WebDriverEventListener {

    public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    public void afterClickOn(WebElement arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        // TODO Auto-generated method stub

    }

    public void afterNavigateBack(WebDriver arg0) {
        // TODO Auto-generated method stub

    }

    public void afterNavigateForward(WebDriver arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    public void afterNavigateTo(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    public void afterScript(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    public void beforeClickOn(WebElement arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    public void beforeNavigateBack(WebDriver arg0) {
        // TODO Auto-generated method stub

    }

    public void beforeNavigateForward(WebDriver arg0) {
        // TODO Auto-generated method stub

    }

    public void beforeNavigateTo(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    public void beforeScript(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    public void onException(Throwable arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }
}
