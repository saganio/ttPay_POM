package Pages;

import Libraries.BaseClass;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static Libraries.TestUtils.clickElementBy;
import static Libraries.TestUtils.getFluentWait;

public class GlobalPage extends BaseClass {

    private final By bildirimler = By.id("ibSecondButton");
    private final By cikisYap_EvetButonu = By.id("btn_confirmation_dialog_confirm");
    private final By cikisYap_HayirButonu = By.id("btn_confirmation_dialog_cancel");
    private final By islemlerim = By.xpath("//android.widget.FrameLayout[@content-desc=\"İşlemlerim\"]/android.widget.FrameLayout/android.widget.ImageView");
    private final By bekleyenIslemler = By.id("radioButtonPending");
    private final By tutarGir = By.xpath("//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_smart_textfield_text']");
    private final By tutarGirdiktenSonrakiDevamEtButonu = By.id("btnWantMoneyAmountSubmit");
    private final By tutarGirdiktenSonrakiOnaylaEtButonu = By.id("abtn_want_money_transfer_amount");
    private final By OTPGirdiktenSonrakiGonderButonu = By.id("abtn_activity_send_money_otp_continue");
    private final By OTPGirdiktenSonrakiBitirButonu = By.id("abtn_want_money_transfer_amount");
    private final By clickOTPField = By.xpath("//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_otp_textfield_text']");
    private final By bankaHesabinaParaGonderDevamEtButonu = By.id("abtn_bank_transfer_amount");
    private final By bankaHesabinaParaGonderOnaylaButonu = By.id("continueBTN");
    private final By bankaHesabinaParaGonderBitirButonu = By.xpath("//*[@text='BİTİR']");


    //Constructor
    public GlobalPage(AndroidDriver<MobileElement> driver) {
        BaseClass.driver = driver;
    }

    //Methods

    @Step("{method}")
    public GlobalPage check_Notifications() {
        clickElementBy(bildirimler);
        Log.info("I clicked" + getClass());
        return this;

    }

    @Step("{method}")
    public GlobalPage click_EvetDialog() {
        clickElementBy(cikisYap_EvetButonu);
        return this;
    }

    @Step("{method}")
    public GlobalPage click_HayirDialog() {
        clickElementBy(cikisYap_HayirButonu);
        return this;
    }


    @Step("{method}")
    public GlobalPage click_Islemlerim() {
        clickElementBy(islemlerim);
        return this;
    }

    @Step("{method}")
    public GlobalPage click_BekleyenIslemlerim() {
        clickElementBy(bekleyenIslemler);
        return this;
    }

    @Step("{method}")
    public GlobalPage goBack() {
        driver.navigate().back();
        getFluentWait();
        return this;
    }

    @Step("{method}")
    public GlobalPage wait2Sec() throws InterruptedException {
        Thread.sleep(2000);
        return this;
    }

    @Step("{method}")
    public GlobalPage tutarGir_ParaGonder() throws InterruptedException {

        clickElementBy(tutarGir);
        driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_6));
        clickElementBy(tutarGirdiktenSonrakiDevamEtButonu);
        clickElementBy(tutarGirdiktenSonrakiOnaylaEtButonu);
        return this;
    }

    @Step("{method}")
    public GlobalPage tutarGir_ParaIste() throws InterruptedException {

        clickElementBy(tutarGir);
        driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_6));
        clickElementBy(tutarGirdiktenSonrakiDevamEtButonu);
        clickElementBy(tutarGirdiktenSonrakiOnaylaEtButonu);
        clickElementBy(OTPGirdiktenSonrakiBitirButonu);

        return this;
    }

    @Step("{method}")
    public GlobalPage tutarGir_IBAN() throws InterruptedException {

        clickElementBy(tutarGir);
        driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_6));
        clickElementBy(bankaHesabinaParaGonderDevamEtButonu);
        clickElementBy(bankaHesabinaParaGonderOnaylaButonu);
        clickElementBy(bankaHesabinaParaGonderBitirButonu);

        return this;
    }

    public GlobalPage OTPGir_Verified() {
        clickElementBy(clickOTPField);
        for (int i = 0; i < 6; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_1));
        }
        clickElementBy(OTPGirdiktenSonrakiGonderButonu);
        clickElementBy(OTPGirdiktenSonrakiBitirButonu);
        return this;
    }

}
