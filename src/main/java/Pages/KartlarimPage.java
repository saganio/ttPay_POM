package Pages;

import Libraries.BaseClass;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static Libraries.TestUtils.clickElementBy;
import static Pages.GlobalPage.getNames;

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

    @Step("{method}")
    public KartlarimPage click_pokusKartEkleOlustur() {
        clickElementBy(pokusKartEkleOlustur);
        Log.info(getNames());
        return this;

    }

    @Step("{method}")
    public KartlarimPage click_pokusKartiniEkle() {
        clickElementBy(pokusKartiniEkle);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public KartlarimPage click_pokusSanalKartOlustur() {
        clickElementBy(pokusSanalKartOlustur);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public KartlarimPage click_krediBankaKartiEkle() {
        clickElementBy(krediBankaKartiEkle);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public KartlarimPage click_pokusKartTalebiOlustur() {
        clickElementBy(pokusKartTalebiOlustur);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public KartlarimPage click_kartlarMenusunuKapat() {
        clickElementBy(kartlarMenusunuKapat);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public String getHataMesajiText() {
        Log.info(getNames());
        return driver.findElement(errorText).getText();
    }

}
