package Utils;

import Libraries.BaseClass;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class TestListener extends BaseClass implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;

    }

    //HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    public static String capture(WebDriver driver) throws IOException {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("target//errSS//" + System.currentTimeMillis()
                             + ".png");
        String errflpath = Dest.getAbsolutePath().replace("/C:", "C:/");
        FileUtils.copyFile(scrFile, Dest);
        return errflpath;
    }

    //Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) throws IOException {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("I am in" + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.info("I am on finish " + iTestContext.getName());
        //Do tier down operations for ExtentReports reporting!

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test started.");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is succeed.");
        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseClass) testClass).getDriver();

        //Allure ScreenShotRobot and SaveTestLog
        if (driver != null) {
            Log.info("Test is succeed and screenshot taken: " + getTestMethodName(iTestResult));
            try {
                capture(driver);
                Allure.addAttachment("Screenshot",
                        new ByteArrayInputStream(((TakesScreenshot) driver)
                                .getScreenshotAs(OutputType.BYTES)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Save a log on allure.
        // saveTextLog(getTestMethodName(iTestResult) + " succeed and screenshot taken!");


    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is failed.");

        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseClass) testClass).getDriver();

        //Allure ScreenShotRobot and SaveTestLog
        if (driver != null) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            try {
                capture(driver);
                Allure.addAttachment("Screenshot",
                        new ByteArrayInputStream(((TakesScreenshot) driver)
                                .getScreenshotAs(OutputType.BYTES)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Save a log on allure.
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is skipped.");
        //ExtentReports log operation for skipped tests.

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}