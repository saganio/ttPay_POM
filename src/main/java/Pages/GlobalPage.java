package Pages;

import Libraries.BaseClass;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
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
}
