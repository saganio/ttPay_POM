package Libraries;

import Utils.Log;
import Utils.TestListener;
import io.appium.java_client.MobileElement;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;

@SuppressWarnings("ALL")
@Listeners(TestListener.class)
public class BaseClass {

    public static AndroidDriver<MobileElement> driver;
    private static AppiumDriverLocalService service;

    public static void startAppiumServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();

        builder.usingAnyFreePort();
        // Tell builder where node is installed. Or set this path in an environment variable named NODE_PATH
   /*     builder.usingDriverExecutable(new File("path_to_node"));
        // Tell builder where Appium is installed. Or set this path in an environment variable named APPIUM_PATH
        builder.withAppiumJS(new File("path_to_appium"));


        HashMap<String, String> environment = new HashMap();
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
        builder.withEnvironment(environment);
*/

        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        service.clearOutPutStreams();
    }

    public static AndroidDriver<MobileElement> initializeSetup() {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("VERSION", "11");
        capabilities.setCapability("deviceName", "Pixel_XL_API_33");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "tr.com.turktelekom.pokus.test");
        capabilities.setCapability("appActivity", "tr.com.innova.fintek.ttpay.pokus.view.splash.SplashActivity");
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("disableWindowAnimation", true);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 6000);
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability("autoAcceptAlerts", true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(service.getUrl(), capabilities);
        driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 300);

        driver.manage().timeouts().implicitlyWait(15, SECONDS);
        return driver;


    }

    public static String rastgeleNumaraGir() {
        String randomNumbers = RandomStringUtils.randomNumeric(9);
        return 5 + randomNumbers;
    }

    public static String rastgeleNumaraGir_5ileBaslamayan() {
        String randomNumbers = RandomStringUtils.randomNumeric(9);
        return 9 + randomNumbers;
    }

    public static String getString(String string) throws IOException, ParseException {

        org.json.simple.parser.JSONParser parser = new JSONParser();
        Object ob1j = parser.parse(new FileReader("src/test/resources/values.json"));
        JSONObject elem = (JSONObject) ob1j;
        return (String) elem.get(string);
    }

    @BeforeMethod
    public void setUp() throws IOException {

        startAppiumServer();
        driver = BaseClass.initializeSetup();
        Log.info("Çalıştırma öncesi ayarlar uygulanıyor...");
    }

    @AfterMethod(alwaysRun = true)
    public void stopAppiumAndDriver() throws IOException {

        driver.quit();
        service.stop();
        Log.info("Closing Driver");
        //Runtime.getRuntime().exec("allure serve allure-results");


    }

    @Attachment(value = "Screenshot", type = "image/png")
    public void takeScreenShot() {

        Log.info("Ekran görüntüsü alınıyor...");
        Allure.addAttachment("Screenshot",
                new ByteArrayInputStream(((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES)));

    }

    public WebDriver getDriver() {
        return driver;
    }

}
