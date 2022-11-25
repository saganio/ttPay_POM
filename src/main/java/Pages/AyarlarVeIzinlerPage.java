package Pages;

import Libraries.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static Libraries.TestUtils.clickElementBy;

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
        return this;
    }

    @Step("{method}")
    public AyarlarVeIzinlerPage click_rehberimdekiKisilerPokusluOldugumuguGorsunSwitch() {
        clickElementBy(rehberimdekiKisilerPokusluOldugumuguGorsun);
        return this;
    }

    @Step("{method}")
    public AyarlarVeIzinlerPage click_ePostaIzniSwitch() {
        clickElementBy(ePostaIzni);
        return this;

    }

    @Step("{method}")
    public AyarlarVeIzinlerPage click_SMSIzniSwitch() {
        clickElementBy(SMSIzni);
        return this;
    }

    @Step("{method}")
    public AyarlarVeIzinlerPage click_aramaIzniSwitch() {
        clickElementBy(aramaIzni);
        return this;
    }

    @Step("{method}")
    public AyarlarVeIzinlerPage click_bildirimIzniSwitch() {
        clickElementBy(bildirimIzni);
        return this;
    }

}
