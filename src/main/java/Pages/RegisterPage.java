package Pages;

import Libraries.BaseClass;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.io.IOException;

import static Libraries.TestUtils.*;
import static Pages.StringConstants.girisOncesiOTPText;


public class RegisterPage extends BaseClass {

    private final By hesabimYok = By.id("lrs_login_activity_register");
    private final By hesapOlusturmayaBasla = By.id("btn_login_register_submith");
    private final By msisdnField = By.id("et_smart_textfield_text");
    private final By devamEtButton = By.id("abtn_activity_register_continue");
    private final By clickOTPField = By.xpath("//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_otp_textfield_text']");
    private final By devamEtButtonAfterOTP = By.id("abtn_register_activation_sms_fragment_continue");

    //Constructor
    public RegisterPage(AndroidDriver<MobileElement> driver) {
        BaseClass.driver = driver;
    }

    //Methods
    public RegisterPage click_HesabimYok() {
        clickElementBy(hesabimYok);
        return this;
    }

    public RegisterPage click_HesapOlusturmayaTikla() {
        clickElementBy(hesapOlusturmayaBasla);
        return this;
    }

    public RegisterPage sendKeys_Msisdn(String text) {
        clearAndfillInFieldWith(msisdnField, text);
        Log.info("I clicked: " + this.getClass().getSimpleName());
        Log.info("Value: " + text);
        return this;
    }

    public RegisterPage click_devamEtButton() {
        clickElementBy(devamEtButton);
        return this;
    }

    public RegisterPage click_OTFField() {
        clickElementBy(clickOTPField);
        return this;
    }

    public RegisterPage click_devamEtButtonAfterOTP() {
        clickElementBy(devamEtButtonAfterOTP);
        return this;
    }
}
