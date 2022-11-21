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

import static Libraries.TestUtils.*;
import static Pages.StringConstants.OTP_MESSAGE;
import static Pages.StringConstants.girisOncesiOTPText;

public class ProfilPage extends BaseClass {


    private final By adresAlani = By.id("txtAddress");
    private final By eMailAlani = By.id("txtMail");
    private final By ilSecDialog = By.id("tvCity");
    private final By ilceSecDialog = By.id("tvProvince");
    private final By acikAdresTextBox = By.id("et_smart_textfield_text");
    private final By guncelleVetamamButton = By.id("apbRequestCard");
    private final By ilSecAdana = By.xpath("//android.widget.TextView[@text='Adana']");
    private final By ilSecAladag = By.xpath("//android.widget.TextView[@text='Aladağ']");
    private final By secButonu = By.id("abDone");
    private final By geriGit = By.id("ibBackButton");
    private final By clickOTPField = By.xpath("//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_otp_textfield_text']");
    private final By gonderButonu = By.xpath("//*[@text='GÖNDER']");
    private final By onayKoduText = By.id("tv_otp_title");

    //Constructor
    public ProfilPage(AndroidDriver<MobileElement> driver) {
        BaseClass.driver = driver;
    }

    //Methods
    @Step("{method}")
    public ProfilPage click_adresDuzenleButton() {
        swipeToElement("Adres");
        clickElementBy(adresAlani);
        return this;
    }

    @Step("{method}")
    public ProfilPage click_emailDuzenleButton() {
        swipeToElement("E-posta");
        clickElementBy(eMailAlani);
        return this;
    }

    @Step("{method}")
    public ProfilPage click_ilSecDialog() {
        clickElementBy(ilSecDialog);
        return this;

    }

    @Step("{method}")
    public ProfilPage click_Adana() {
        clickElementBy(ilSecAdana);
        return this;

    }

    @Step("{method}")
    public ProfilPage click_ilceSecDialog() {
        clickElementBy(ilceSecDialog);
        return this;
    }

    @Step("{method}")
    public ProfilPage click_Aladag() {
        clickElementBy(ilSecAladag);
        return this;
    }

    @Step("{method}")
    public ProfilPage click_secButton() {
        clickElementBy(secButonu);
        return this;
    }

    @Step("{method}")
    public ProfilPage sendkeys_acikAdresTextBox() throws IOException, ParseException {
        clearAndfillInFieldWith(acikAdresTextBox,getString("KKNo"));
        return this;
    }

    @Step("{method}")
    public ProfilPage click_tamamveGuncelleButton() {
        clickElementBy(guncelleVetamamButton);
        return this;
    }

    @Step("{method}")
    public ProfilPage click_gerigitButton() {
        clickElementBy(geriGit);
        return this;
    }

    @Step("{method}")
    public ProfilPage setOTP() {

        boolean OTPMessageExists = driver.findElements(onayKoduText).size() != 0;

        if (OTPMessageExists==true) {
            try {
                clickElementBy(clickOTPField);
                for (int i = 0; i < 6; i++) {
                    driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_1));
                }
                clickElementBy(gonderButonu);
            } catch (NoSuchElementException NSE) {
                Log.info("OTP ekranı gelmedi, OTP girişi yapılmayacak.");
            }
        } else {
            Log.info("OTP ekranı gelmedi, OTP girişi yapılmayacak.");
        }
        return this;
    }

    public CharSequence getTextOfOTPMessage() {
        return getTextFromElement(onayKoduText);
    }

}
