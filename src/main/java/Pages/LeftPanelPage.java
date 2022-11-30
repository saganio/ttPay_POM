package Pages;

import Libraries.BaseClass;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static Libraries.TestUtils.clickElementBy;
import static Libraries.TestUtils.getFluentWait;
import static Pages.GlobalPage.getNames;

public class LeftPanelPage extends BaseClass {


    private final By profil = By.xpath("//android.widget.TextView[@text='Profil']");
    private final By hesabiniOnayla = By.xpath("//android.widget.TextView[@text='Hesabını Onayla']");
    private final By rehberimVeBankaHesaplarim = By.xpath("//android.widget.TextView[@text='Rehberim ve Banka Hesaplarım']");
    private final By ayarlarVeIzinler = By.xpath("//android.widget.TextView[@text='Ayarlar ve İzinler']");
    private final By pokusKartEkleOlustur = By.xpath("//android.widget.TextView[@text='Pokus Kart Ekle/Oluştur']");
    private final By formVeSozlesmeler = By.xpath("//android.widget.TextView[@text='Form ve Sözleşmeler']");
    private final By sikcaSorulanSorular = By.xpath("//android.widget.TextView[@text='Sıkça Sorulan Sorular']");
    private final By musteriHizmetleri = By.xpath("//android.widget.TextView[@text='Müşteri Hizmetleri']");
    private final By cikisYap = By.xpath("//android.widget.TextView[@text='Çıkış Yap']");
    private final By iptal = By.xpath("//*[@text='İPTAL']");

    //Constructor
    public LeftPanelPage(AndroidDriver<MobileElement> driver) {
        BaseClass.driver = driver;
    }

    //Methods
    @Step("{method}")
    public LeftPanelPage click_Profil() {
        clickElementBy(profil);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public LeftPanelPage click_hesabiniOnayla() {
        clickElementBy(hesabiniOnayla);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public LeftPanelPage click_rehberimVeBankaHesaplarim() {
        clickElementBy(rehberimVeBankaHesaplarim);
        Log.info(getNames());
        return this;

    }

    @Step("{method}")
    public LeftPanelPage click_ayarlarVeIzinler() {
        clickElementBy(ayarlarVeIzinler);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public LeftPanelPage click_pokusKartEkleOlustur() {
        clickElementBy(pokusKartEkleOlustur);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public LeftPanelPage click_formVeSozlesmeler() {
        clickElementBy(formVeSozlesmeler);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public LeftPanelPage click_sikcaSorulanSorular() {
        clickElementBy(sikcaSorulanSorular);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public LeftPanelPage click_musteriHizmetleri() {
        clickElementBy(musteriHizmetleri);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public LeftPanelPage click_cikisYap() {
        clickElementBy(cikisYap);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public LeftPanelPage goBack() {
        driver.navigate().back();
        getFluentWait();
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public LeftPanelPage clickIptal() {
        clickElementBy(iptal);
        getFluentWait();
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public LeftPanelPage wait2Sec() throws InterruptedException {
        Thread.sleep(2000);
        Log.info(getNames());
        return this;
    }
}
