package Basic.paraGonder_iste;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import libraries.functions.menuElemanlari;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import other.baseClass;

import java.io.IOException;

import static libraries.functions.menuElemanlari.bekle;


public class paraIste_KayitliKisi extends baseClass {

    static ExtentHtmlReporter htmlReporter;
    static ExtentReports extent;
    static AndroidDriver<MobileElement> androidDriver;

    @BeforeClass
    public void setUp() throws Exception {

        androidDriver = baseClass.desiredCaps();

        htmlReporter = new ExtentHtmlReporter("report\\basicReport/Para İste - Kayıtlı Kişi.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "TTPAY");
        extent.setSystemInfo("Environment", "TTPAY Automation");
        extent.setSystemInfo("User Name", "Uğur Yıldız");
        htmlReporter.config().setDocumentTitle("Para İste - Kayıtlı Kişi");
        htmlReporter.config().setReportName("Para İste - Kayıtlı Kişi");
        htmlReporter.config().setTheme(Theme.STANDARD);
        String css = ".r-img {width: 50%;}";
        htmlReporter.config().setCSS(css);
    }

    @Test
    public void step1() throws IOException, ParseException, InterruptedException {

        ExtentTest TTPay = extent.createTest("Step1");

        menuElemanlari.basic_loginClass(androidDriver);


        TTPay.log(Status.INFO, "Uygulama açıldı ve giriş yapıldı.");

    }

    @Test
    public void step2() throws IOException {

        ExtentTest TTPay = extent.createTest("Step2");

        try {
            MobileElement menu = androidDriver.findElementById("tr.com.turktelekom.pokus.test:id/ibtn_user_home_fragment_request_money");
            menu.click();

            TTPay.log(Status.PASS, "Para İste'ye tıklandı.");
            TTPay.log(Status.PASS, "Ekran Görüntüsü: ", MediaEntityBuilder.createScreenCaptureFromPath(capture(androidDriver)).build());


        } catch (Exception e) {
            TTPay.log(Status.FAIL, "Hata Oluştu" + e);
            e.printStackTrace();
            throw e;
        }

    }


    @Test
    public void step3() throws IOException, InterruptedException {

        ExtentTest TTPay = extent.createTest("Step3");

        try {

            MobileElement assertion = androidDriver.findElementById("tv_confirmation_dialog_message");

            TTPay.log(Status.PASS, assertion.getText() + "uyarısı görüldü");
            TTPay.log(Status.PASS, "Ekran Görüntüsü: ", MediaEntityBuilder.createScreenCaptureFromPath(capture(androidDriver)).build());

            System.out.println(assertion.getText());

            androidDriver.findElementByXPath("//*[@text='VAZGEÇ']").click();
            bekle(androidDriver);


        } catch (Exception e) {
            TTPay.log(Status.FAIL, "Hata Oluştu" + e);
            e.printStackTrace();
            throw e;
        }

    }


    @AfterTest(alwaysRun = true)
    public void reportTearDown() {

        extent.flush();
        androidDriver.quit();

    }


}
