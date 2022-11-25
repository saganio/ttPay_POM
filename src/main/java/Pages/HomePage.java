package Pages;

import Libraries.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static Libraries.TestUtils.*;


public class HomePage extends BaseClass {

    private final By islemlerim = By.id("bottom_navigation_transactions");
    private final By yukleButonu = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ImageButton");
    private final By paraGonderButonu = By.id("ibtn_user_home_fragment_send_money");
    private final By paraIsteButonu = By.id("ibtn_user_home_fragment_request_money");
    private final By odemeYapButonu = By.id("ibPayment");
    private final By kampanyalar = By.xpath("//android.widget.FrameLayout[@content-desc=\"Kampanyalar\"]/android.view.ViewGroup/android.widget.TextView");
    private final By bildirimler = By.id("ibSecondButton");
    private final By kartlarim = By.id("ibFirstButton");
    private final By confirmationDialog = By.id("tv_confirmation_dialog_message");
    private final By confirmation_dialog_confirm = By.id("btn_confirmation_dialog_confirm");
    private final By confirmation_dialog_reject = By.id("btn_confirmation_dialog_cancel");
    private final By chooseKrediBankaHesabimdan = By.id("tv_fragment_top_up_select_bank_title");
    private final By faturaOde = By.xpath("//*[@text='Fatura Öde']");
    private final By bankaHesabindanYukle_tamamButonu = By.id("abtnTopUpBeforeInfoOkay");
    private final By bankaHesabindanYukle_tamamButonu2 = By.id("abtnTopUpBankTransferOkay");
    private final By kisiyeSecenegi = By.id("tv_payment_method_qr");

    //Constructor
    public HomePage(AndroidDriver<MobileElement> driver) {
        BaseClass.driver = driver;
    }

    //Methods

    @Step("{method}")
    public HomePage clickIslemlerim() {
        clickElementBy(islemlerim);
        return this;
    }

    @Step("{method}")
    public HomePage click_YukleButonu() {
        clickElementBy(yukleButonu);
        return this;
    }

    @Step("{method}")
    public HomePage click_ParaGonderButonu() {
        clickElementBy(paraGonderButonu);
        return this;

    }

    @Step("{method}")
    public HomePage click_ParaIsteButonu() {
        clickElementBy(paraIsteButonu);
        return this;

    }

    @Step("Ödeme Yap'a tıkla.")
    public HomePage click_OdemeYapButonu() {
        clickElementBy(odemeYapButonu);
        return this;

    }

    @Step("{method}")
    public HomePage click_Kampanyalar() {
        clickElementBy(kampanyalar);
        return this;
    }

    @Step("{method}")
    public HomePage click_Bildirimler() {
        clickElementBy(bildirimler);
        return this;
    }

    @Step("{method}")
    public HomePage click_Kartlarim() {
        clickElementBy(kartlarim);
        return this;
    }

    @Step("{method}")
    public String get_ConfirmationDialogText() {
        return getTextFromElement(confirmationDialog);
    }

    @Step("{method}")
    public HomePage accept_ConfirmationDialog() {
        clickElementBy(confirmation_dialog_confirm);
        return this;
    }

    @Step("{method}")
    public HomePage reject_ConfirmationDialog() {
        clickElementBy(confirmation_dialog_reject);
        return this;
    }

    @Step("{method}")
    public HomePage click_KrediBankaHesabimdan() {
        clickElementBy(chooseKrediBankaHesabimdan);
        return this;
    }

    @Step("{method}")
    public HomePage click_FaturaOde() {
        clickElementBy(faturaOde);
        return this;
    }


    @Step("{method}")
    public HomePage click_TamamButtonBefore() {
        clickElementBy(bankaHesabindanYukle_tamamButonu);
        return this;
    }

    @Step("{method}")
    public HomePage click_KisiyeSecenegi() {
        clickElementBy(kisiyeSecenegi);
        return this;
    }

    @Step("{method}")
    public HomePage click_TamamButtonAfter() {
        swipeToElement("TAMAM");
        clickElementBy(bankaHesabindanYukle_tamamButonu2);
        return this;
    }
}
