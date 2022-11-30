package Pages;

import Libraries.BaseClass;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.io.IOException;
import java.sql.SQLException;

import static Libraries.TestUtils.*;
import static Pages.GlobalPage.getNames;
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
    private final By sifreAlani1 = By.xpath("(//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_password_text'])[1]");
    private final By sifreAlani2 = By.xpath("(//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_password_text'])[2]");
    private final By devamEtAfterSifre = By.id("abtn_register_password_continue");
    private final By isimAlani = By.xpath("(//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_smart_textfield_text'])[1]");
    private final By soyisimAlani = By.xpath("(//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_smart_textfield_text'])[2]");
    private final By ePostaAlani = By.xpath("(//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_smart_textfield_text'])[3]");
    private final By devamEtAfterAdSoyad = By.id("abtn_register_identity_continue");
    private final By checkBox1 = By.xpath("(//*[@resource-id='tr.com.turktelekom.pokus.test:id/cb_register_contracts_list_item'])[1]");
    private final By checkBox2 = By.xpath("(//*[@resource-id='tr.com.turktelekom.pokus.test:id/cb_register_contracts_list_item'])[2]");
    private final By checkBox3 = By.xpath("(//*[@resource-id='tr.com.turktelekom.pokus.test:id/cb_register_contracts_list_item'])[3]");
    private final By checkBox4 = By.xpath("(//*[@resource-id='tr.com.turktelekom.pokus.test:id/cb_register_contracts_list_item'])[4]");
    private final By devamEtCheckBox = By.id("abtn_register_activation_mail_continue");
    private final By devamEtAfterSuccess = By.id("fs_success_dialog_submith");
    private final By tanimitiAtla = By.id("btnskip");
    private final By otpTextAfterWrongOTP = By.id("tv_information_dialog_message");

    //Constructor
    public RegisterPage(AndroidDriver<MobileElement> driver) {
        BaseClass.driver = driver;
    }

    //Methods

    @Step("{method}")
    public RegisterPage click_HesabimYok() {
        clickElementBy(hesabimYok);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RegisterPage click_HesapOlusturmayaTikla() {
        clickElementBy(hesapOlusturmayaBasla);
        Log.info(getNames());
        return this;
    }

    @Step("{method} {0}")
    public RegisterPage sendKeys_Msisdn(String text) {
        clearAndfillInFieldWith(msisdnField, text);
        Log.info("Value: " + text);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RegisterPage click_devamEtButton() {
        clickElementBy(devamEtButton);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RegisterPage click_OTFField() {
        clickElementBy(clickOTPField);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RegisterPage click_devamEtButtonAfterOTP() {
        clickElementBy(devamEtButtonAfterOTP);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public String getVarOlanHesapErrorText() {
        saveTextLog(getTextFromElement(varOlanHesapErrorText));
        Log.info(getNames());
        return driver.findElement(varOlanHesapErrorText).getText();
    }

    @Step("{method}")
    public RegisterPage click_TamamDialog() {
        clickElementBy(confirmDialog);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RegisterPage yeniHesapOTPGir() throws IOException, ParseException {

        try {
            clickElementBy(clickOTPField);
            dbQueries.Set_OTPForNewAccount();
        } catch (NoSuchElementException NSE) {
            Log.info("OTP Girildi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RegisterPage yanlisOTPGir() throws IOException, ParseException {

        clickElementBy(clickOTPField);

        for (int i = 0; i < 6; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_9));
        }

        Log.info(getNames());
        return this;
    }


    @Step("{method}")
    public RegisterPage set_Sifre() throws IOException, ParseException {
        clearAndfillInFieldWith(sifreAlani1, getString("pass"));
        clearAndfillInFieldWith(sifreAlani2, getString("pass"));
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RegisterPage click_DevamEtAfterSifre() {
        clickElementBy(devamEtAfterSifre);
        Log.info(getNames());
        return this;
    }


    @Step("{method}")
    public RegisterPage click_DevamEtAfterAdSoyad() {
        clickElementBy(devamEtAfterAdSoyad);
        Log.info(getNames());
        return this;
    }

    @Step("{method}{0}{1}{2}")
    public RegisterPage set_IsimSoyIsimVeEmail(String ad, String soyad, String eposta) throws IOException, ParseException {
        clearAndfillInFieldWith(isimAlani, ad);
        clearAndfillInFieldWith(soyisimAlani, soyad);
        clearAndfillInFieldWith(ePostaAlani, eposta);
        Log.info(getNames());
        return this;
    }


    @Step("{method}")
    public RegisterPage click_CheckBoxes() {
        clickElementBy(checkBox1);
        clickElementBy(checkBox2);
        clickElementBy(checkBox3);
        clickElementBy(checkBox4);

        Log.info(getNames());
        return this;
    }


    @Step("{method}")
    public RegisterPage click_DevamEtAfterCheckBox() {
        clickElementBy(devamEtCheckBox);
        Log.info(getNames());
        return this;
    }


    @Step("{method}")
    public RegisterPage click_devamEtAfterSuccess() {
        clickElementBy(devamEtAfterSuccess);
        Log.info(getNames());
        return this;
    }


    @Step("{method}")
    public RegisterPage click_tanitimiAtla() {
        clickElementBy(tanimitiAtla);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public String get_OTPText() {
        Log.info(getNames());
        return getTextFromElement(otpTextAfterWrongOTP);
    }


}
