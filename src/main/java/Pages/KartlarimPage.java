package Pages;

import Libraries.BaseClass;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static Libraries.TestUtils.clickElementBy;

public class KartlarimPage extends BaseClass {

    private final By pokusKartEkleOlustur = By.xpath("//android.widget.TextView[@text='Pokus Kart Ekle/Oluştur']");
    private final By pokusKartiniEkle = By.xpath("//android.widget.TextView[@text='Pokus Kartını Ekle']");
    private final By pokusSanalKartOlustur = By.xpath("//android.widget.TextView[@text='Pokus Sanal Kart Oluştur']");
    private final By krediBankaKartiEkle = By.xpath("//android.widget.TextView[@text='Kredi / Banka Kartı Ekle']");
    private final By pokusKartTalebiOlustur = By.xpath("//android.widget.TextView[@text='Pokus Kart Talebi Oluştur']");
    private final By kartlarMenusunuKapat = By.xpath("//android.widget.ImageButton");
    private final By errorText = By.id("tv_confirmation_dialog_message");


    //Constructor
    public KartlarimPage(AndroidDriver<MobileElement> driver) {
        BaseClass.driver = driver;
    }

    //Methods

    @Step("Pokus Kart Ekle / Olustur seçeneğine tıkla.")
    public KartlarimPage click_pokusKartEkleOlustur() {
        clickElementBy(pokusKartEkleOlustur);
        Log.info("I clicked" + getClass());
        return this;

    }

    @Step("KPokus kartını ekle seçeneğine tıkla.")
    public KartlarimPage click_pokusKartiniEkle() {
        clickElementBy(pokusKartiniEkle);
        return this;
    }

    @Step("Pokus Sanal kart Oluştur'a tıkla.")
    public KartlarimPage click_pokusSanalKartOlustur() {
        clickElementBy(pokusSanalKartOlustur);
        return this;
    }

    @Step("Kredi Banka kartı ekle'ye tıkla.")
    public KartlarimPage click_krediBankaKartiEkle() {
        clickElementBy(krediBankaKartiEkle);
        return this;
    }

    @Step("Pokus Kart Talebi Oluştur'a tıkla.")
    public KartlarimPage click_pokusKartTalebiOlustur() {
        clickElementBy(pokusKartTalebiOlustur);
        return this;
    }

    @Step("Çarpı işaretine tıkla.")
    public KartlarimPage click_kartlarMenusunuKapat() {
        clickElementBy(kartlarMenusunuKapat);
        return this;
    }

    @Step("Hata Mesajını çek.")
    public String getHataMesajiText() {
        return driver.findElement(errorText).getText();
    }

}
