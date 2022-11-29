package Pages;

import Libraries.BaseClass;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static Libraries.TestUtils.*;
import static Utils.TestListener.saveTextLog;


public class RegisterPage extends BaseClass {

    private final By hesabimYok = By.id("lrs_login_activity_register");
    private final By hesapOlusturmayaBasla = By.id("btn_login_register_submith");
    private final By msisdnField = By.id("et_smart_textfield_text");
    private final By devamEtButton = By.id("abtn_activity_register_continue");
    private final By clickOTPField = By.xpath("//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_otp_textfield_text']");
    private final By devamEtButtonAfterOTP = By.id("abtn_register_activation_sms_fragment_continue");
    private final By varOlanHesapErrorText = By.id("tv_information_dialog_message");
    private final By confirmDialog = By.id("btn_information_dialog_confirm");

    //Constructor
    public RegisterPage(AndroidDriver<MobileElement> driver) {
        BaseClass.driver = driver;
    }

    //Methods

    @Step("{method}")
    public RegisterPage click_HesabimYok() {
        clickElementBy(hesabimYok);
        return this;
    }

    @Step("{method}")
    public RegisterPage click_HesapOlusturmayaTikla() {
        clickElementBy(hesapOlusturmayaBasla);
        return this;
    }

    @Step("{method} {0}")
    public RegisterPage sendKeys_Msisdn(String text) {
        clearAndfillInFieldWith(msisdnField, text);
        Log.info("Value: " + text);
        return this;
    }

    @Step("{method}")
    public RegisterPage click_devamEtButton() {
        clickElementBy(devamEtButton);
        return this;
    }

    @Step("{method}")
    public RegisterPage click_OTFField() {
        clickElementBy(clickOTPField);
        return this;
    }

    @Step("{method}")
    public RegisterPage click_devamEtButtonAfterOTP() {
        clickElementBy(devamEtButtonAfterOTP);
        return this;
    }

    @Step("{method}")
    public String getVarOlanHesapErrorText() {
        saveTextLog(getTextFromElement(varOlanHesapErrorText));
        return driver.findElement(varOlanHesapErrorText).getText();
    }

    @Step("{method}")
    public RegisterPage click_TamamDialog() {
        clickElementBy(confirmDialog);
        return this;
    }
}
