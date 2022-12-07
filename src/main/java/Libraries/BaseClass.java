package Libraries;

import Pages.*;
import Utils.Log;
import Utils.TestListener;
import com.google.common.collect.ImmutableMap;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static java.util.concurrent.TimeUnit.SECONDS;

@SuppressWarnings("ALL")
@Listeners(TestListener.class)
public class BaseClass {

    public static AndroidDriver<MobileElement> driver;
    private static final String CAPS_FILENAME = "src/test/resources/caps.properties";

    //Call Page Objects
    public static LoginPage loginPage = new LoginPage(driver);
    public static LeftPanelPage leftPanelPage = new LeftPanelPage(driver);
    public static GlobalPage globalPage = new GlobalPage(driver);
    public static HomePage homePage = new HomePage(driver);
    public static RehberimVeBankHspPage RehberimVeBankaHesaplarimPage;
    public static CampaignsPage campaignsPage = new CampaignsPage(driver);
    public static KartlarimPage kartlarimPage = new KartlarimPage(driver);
    public static RegisterPage registerPage = new RegisterPage(driver);
    public static AyarlarVeIzinlerPage ayarlarVeIzinlerPage = new AyarlarVeIzinlerPage(driver);
    public static ProfilPage profilPage = new ProfilPage(driver);
    public static DBQueries dbQueries = new DBQueries(driver);
    public static DBConnection dbConnection = new DBConnection();
    private static AppiumDriverLocalService service;

    static {
        try {
            RehberimVeBankaHesaplarimPage = new RehberimVeBankHspPage(driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    //Start Appium Server
    public static void startAppiumServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();

        builder.usingAnyFreePort();
    /*    // Tell builder where node is installed. Or set this path in an environment variable named NODE_PATH
       builder.usingDriverExecutable(new File("C:\\Users\\uyildiz\\AppData\\Local\\Programs\\Appium\\Appium.exe"));
        // Tell builder where Appium is installed. Or set this path in an environment variable named APPIUM_PATH
        builder.withAppiumJS(new File("C:\\Users\\uyildiz\\AppData\\Local\\Programs\\Appium"));
*/
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        service.clearOutPutStreams();
    }

    //Setup before app start
    public static AndroidDriver<MobileElement> initializeSetup() throws IOException {

        Properties prop = new Properties();
        prop.load(new FileInputStream(CAPS_FILENAME));

        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
        URL url = new URL(URL_STRING);

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("VERSION", prop.getProperty("VERSION"));
        capabilities.setCapability("deviceName", prop.getProperty("deviceName"));
        capabilities.setCapability("platformName", prop.getProperty("platformName"));
        capabilities.setCapability("appPackage", prop.getProperty("appPackage"));
        capabilities.setCapability("appActivity", prop.getProperty("appActivity"));
        capabilities.setCapability("noReset", prop.getProperty("noReset"));
        capabilities.setCapability("automationName", prop.getProperty("automationName"));
        capabilities.setCapability("disableWindowAnimation", prop.getProperty("disableWindowAnimation"));
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 6000);
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability("autoAcceptAlerts", prop.getProperty("autoAcceptAlerts"));
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, capabilities);
        driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 100);

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

    public static String getJiraString(String string) throws IOException, ParseException {

        org.json.simple.parser.JSONParser parser = new JSONParser();
        Object ob1j = parser.parse(new FileReader("src/test/resources/jiraProperties.json"));
        JSONObject elem = (JSONObject) ob1j;
        return (String) elem.get(string);
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {

        //startAppiumServer();
        driver = BaseClass.initializeSetup();
        setAllureEnvironment();
        Log.info("Engine started.");

    }

    @AfterClass(alwaysRun = true)
    public void stopAppiumAndDriver() throws IOException {

        driver.quit();
      //  service.stop();
        Log.info("Closing Driver");
        //Runtime.getRuntime().exec("allure serve allure-results");

    }

    @Attachment(value = "Screenshot", type = "image/png")
    public void takeScreenShot() {

        Log.info("Taking Screenshot...");
        Allure.addAttachment("Screenshot",
                new ByteArrayInputStream(((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES)));

    }


    public void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Author", "uyildiz")
                        .put("Project", "TTPay")
                        .put("URL", "https://pokus.com.tr/")
                        .build());
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static void readProperties(String props) throws IOException {



    }
}
