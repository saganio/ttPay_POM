package Pages;

import Libraries.BaseClass;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static Libraries.TestUtils.clickElementBy;

public class GlobalPage extends BaseClass {

    private final By bildirimler = By.id("ibSecondButton");
    private final By cikisYap_EvetButonu = By.id("btn_confirmation_dialog_confirm");
    private final By cikisYap_HayirButonu = By.id("btn_confirmation_dialog_cancel");

    //Constructor
    public GlobalPage(AndroidDriver<MobileElement> driver) {
        BaseClass.driver = driver;
    }

    //Methods

    @Step("Bildirimlere tıkla.")
    public GlobalPage check_Notifications() {
        clickElementBy(bildirimler);
        Log.info("I clicked" + getClass());
        return this;

    }
    @Step("Çıkış Yap / Evet'e tıkla.")
    public GlobalPage click_EvetDialog() {
        clickElementBy(cikisYap_EvetButonu);
        return this;
    }

    @Step("Çıkış Yap / Hayır'a tıkla.")
    public GlobalPage click_HayirDialog() {
        clickElementBy(cikisYap_HayirButonu);
        return this;
    }

}
