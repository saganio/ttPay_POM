package Pages;

import Libraries.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static Libraries.TestUtils.clickElementBy;
import static Libraries.TestUtils.getFluentWait;

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
    public LeftPanelPage click_Profil() {
        clickElementBy(profil);
        return this;
    }

    public LeftPanelPage click_hesabiniOnayla() {
        clickElementBy(hesabiniOnayla);
        return this;
    }

    public LeftPanelPage click_rehberimVeBankaHesaplarim() {
        clickElementBy(rehberimVeBankaHesaplarim);
        return this;

    }

    public LeftPanelPage click_ayarlarVeIzinler() {
        clickElementBy(ayarlarVeIzinler);
        return this;
    }

    public LeftPanelPage click_pokusKartEkleOlustur() {
        clickElementBy(pokusKartEkleOlustur);
        return this;
    }

    public LeftPanelPage click_formVeSozlesmeler() {
        clickElementBy(formVeSozlesmeler);
        return this;
    }

    public LeftPanelPage click_sikcaSorulanSorular() {
        clickElementBy(sikcaSorulanSorular);
        return this;
    }

    public LeftPanelPage click_musteriHizmetleri() {
        clickElementBy(musteriHizmetleri);
        return this;
    }

    public LeftPanelPage click_cikisYap() {
        clickElementBy(cikisYap);
        return this;
    }


    public LeftPanelPage goBack() {
        driver.navigate().back();
        getFluentWait();
        return this;
    }

    public LeftPanelPage clickIptal() {
        clickElementBy(iptal);
        getFluentWait();
        return this;
    }

    public LeftPanelPage wait2Sec() throws InterruptedException {
        Thread.sleep(2000);
        return this;
    }
}
