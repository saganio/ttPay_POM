package Pages;

import Libraries.BaseClass;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import static Libraries.TestUtils.clickElementBy;
import static Libraries.TestUtils.getTextFromElement;


public class HomePage extends BaseClass {

    private final By islemlerim = By.id("bottom_navigation_transactions");
    private final By yukleButonu = By.id("drop_shape_title");
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

    //Constructor
    public HomePage(AndroidDriver<MobileElement> driver) {
        BaseClass.driver = driver;
    }

    //Methods
    public HomePage clickIslemlerim() {
        clickElementBy(islemlerim);
        Log.info(islemlerim + "Clicked");
        return this;

    }

    public HomePage click_YukleButonu() {
        clickElementBy(yukleButonu);
        return this;
    }

    public HomePage click_ParaGonderButonu() {
        clickElementBy(paraGonderButonu);
        return this;

    }

    public HomePage click_ParaIsteButonu() {
        clickElementBy(paraIsteButonu);
        return this;

    }

    public HomePage click_OdemeYapButonu() {
        clickElementBy(odemeYapButonu);
        return this;

    }

    public HomePage click_Kampanyalar() {
        clickElementBy(kampanyalar);
        return this;

    }

    public HomePage click_Bildirimler() {
        clickElementBy(bildirimler);
        return this;
    }

    public HomePage click_Kartlarim() {
        clickElementBy(kartlarim);
        return this;
    }

    public String get_ConfirmationDialogText() {
        return getTextFromElement(confirmationDialog);
    }

    public HomePage accept_ConfirmationDialog() {
        clickElementBy(confirmation_dialog_confirm);
        return this;
    }

    public HomePage reject_ConfirmationDialog() {
        clickElementBy(confirmation_dialog_reject);
        return this;
    }

    public HomePage click_KrediBankaHesabimdan() {
        clickElementBy(chooseKrediBankaHesabimdan);
        return this;
    }

}
