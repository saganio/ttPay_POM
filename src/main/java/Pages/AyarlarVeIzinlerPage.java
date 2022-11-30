package Pages;

import Libraries.BaseClass;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static Libraries.TestUtils.clickElementBy;
import static Pages.GlobalPage.getNames;

public class AyarlarVeIzinlerPage extends BaseClass {


    private final By uygulamaParolasi = By.xpath("//android.widget.TextView[@text='Uygulama Parolası']");
    private final By rehberimdekiKisilerPokusluOldugumuguGorsun = By.xpath("//android.widget.TextView[@text='Rehberimdeki kişilerin Pokus’lu olduğumu görmesine izin ver.']");
    private final By ePostaIzni = By.xpath("//android.widget.TextView[@text='E-posta izni']");
    private final By SMSIzni = By.xpath("//android.widget.TextView[@text='SMS izni']");
    private final By aramaIzni = By.xpath("//android.widget.TextView[@text='Arama izni']");
    private final By bildirimIzni = By.xpath("//android.widget.TextView[@text='Bildirim izni']");

    //Constructor
    public AyarlarVeIzinlerPage(AndroidDriver<MobileElement> driver) {
        BaseClass.driver = driver;
    }

    //Methods
    @Step("{method}")
    public AyarlarVeIzinlerPage click_uygulamaParolasiText() {
        clickElementBy(uygulamaParolasi);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public AyarlarVeIzinlerPage click_rehberimdekiKisilerPokusluOldugumuguGorsunSwitch() {
        clickElementBy(rehberimdekiKisilerPokusluOldugumuguGorsun);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public AyarlarVeIzinlerPage click_ePostaIzniSwitch() {
        Log.info(getNames());
        clickElementBy(ePostaIzni);
        return this;

    }

    @Step("{method}")
    public AyarlarVeIzinlerPage click_SMSIzniSwitch() {
        clickElementBy(SMSIzni);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public AyarlarVeIzinlerPage click_aramaIzniSwitch() {
        clickElementBy(aramaIzni);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public AyarlarVeIzinlerPage click_bildirimIzniSwitch() {
        clickElementBy(bildirimIzni);
        Log.info(getNames());
        return this;
    }

}
