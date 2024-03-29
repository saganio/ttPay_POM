package Pages;

import Libraries.BaseClass;
import Libraries.TestUtils;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.io.IOException;

import static Libraries.TestUtils.*;
import static Pages.GlobalPage.getNames;
import static Pages.StringConstants.IBAN_KAYDETME_TEXT;
import static Pages.StringConstants.yeniKayitNo;
import static Utils.TestListener.saveTextLog;

public class RehberimVeBankHspPage extends BaseClass {

    private final By ibanSekmesi = By.id("radioButtonContacts2");
    private final By plusButton = By.id("tr.com.turktelekom.pokus.test:id/ibSecondButton");
    private final By searchButton = By.id("ibFirstButton");
    private final By editButton = By.id("tr.com.turktelekom.pokus.test:id/ibFirstButton");
    private final By searchBar = By.id("iSearchField");
    private final By closeSearchBar = By.id("iSearchCloseBtn");
    private final By yeniKisiEkle = By.xpath("//android.widget.TextView[@text='Yeni Kişi Ekle']");
    private final By yeniGrupOlustur = By.xpath("//android.widget.TextView[@text='Yeni Grup Oluştur']");
    private final By closeDialog = By.className("android.widget.ImageButton");
    private final By dialog_vazgecButonu = By.id("btn_confirmation_dialog_cancel");
    private final By dialog_devamEtButonu = By.id("btn_confirmation_dialog_confirm");
    private final By IBANKaydetmeText_devamEtButonu = By.id("btn_information_dialog_confirm");
    private final By grupAdiGirTextBox = By.id("et_smart_textfield_text");
    private final By devamEtButonu = By.id("abAddNewGroup");
    private final By kaydetButonu = By.id("abSaveNewGroup");
    private final By grubaEklemekicinKisiSec = By.xpath("(//android.widget.ImageView[@resource-id='tr.com.turktelekom.pokus.test:id/imgNoAvatar'])[1]");
    private final By paraIsteButonu = By.id("imgRequestMoney");
    private final By paraGonderButonu = By.id("imgSendtMoney");
    private final By silButonu = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.ImageButton[1]");
    private final By grubaKisiEkle = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.ImageButton[2]");
    private final By grubuSil = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.ImageButton[1]\n");
    private final By rehbereKaydet = By.id("abtn_activity_add_new_contact_continue");
    private final By saveButton = By.xpath("//android.widget.Button[@text='SAVE']");
    private final By grubuSil_OnaylaButton = By.xpath("//android.widget.Button[@text='ONAYLA']");
    private final By grubuSil_VazgecButton = By.xpath("//android.widget.Button[@text='VAZGEÇ']");
    private final By grubuSil_TamamButton = By.xpath("//android.widget.Button[@text='TAMAM']");
    private final By IBANSildiktenSonra_TamamButton = By.xpath("//android.widget.Button[@text='TAMAM']");
    private final By IBANText = By.id("tv_confirmation_dialog_message");
    private final By davetEt = By.xpath("(//*[@text='DAVET ET'])[2]");
    private final By davetEtTextAssert = By.id("tr.com.turktelekom.pokus.test:id/tv_information_dialog_message");
    private final By yeniKaydedilenKisi = By.xpath("//*[@text='" + yeniKayitNo + "']");
    private final By kisiAdiDegistirTextBox = By.xpath("//android.widget.EditText[@text='First name']");
    private final By grupSec = By.id("group_icon_non_avatar");
    private final By aliciAdSoyad = By.xpath("//*[@text='Alıcı Ad Soyad']");
    private final By aliciIBAN = By.xpath("//*[@text='Alıcı IBAN']");
    private final By IBANKaydetButton = By.id("btnSaveIban");
    private final By IBANKaydetTamamButton = By.id("fs_success_dialog_submith");
    private final By kaydedilenIBANiSec = By.id("imgNoAvatar");
    private final By IBANSilButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ImageButton");
    private final By rehberdenKisiSec = By.xpath("(//android.widget.ImageView[@resource-id='tr.com.turktelekom.pokus.test:id/imgNoAvatar'])[1]");
    private final By kisiSectiktenSonraDevamETButton = By.id("abtn_activity_want_money_continue");
    private final By semiIBANHataText = By.id("abtn_activity_want_money_continue");


    //Constructor
    public RehberimVeBankHspPage(AndroidDriver<MobileElement> driver) throws IOException, ParseException {
        BaseClass.driver = driver;
    }

    //Methods

    @Step("{method}")
    public RehberimVeBankHspPage click_IbanSekmesi() {
        clickElementBy(ibanSekmesi);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_plusButton() {
        clickElementBy(plusButton);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_searchButton() {
        clickElementBy(searchButton);
        Log.info(getNames());
        return this;
    }

    @Step("{method} {0}")
    public RehberimVeBankHspPage sendkeys_searchBar(String text) {
        TestUtils.clearAndfillInFieldWith(searchBar, text);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage close_SearchBar() {
        clickElementBy(closeSearchBar);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_Duzenle() {
        clickElementBy(editButton);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_yeniKisiEkle() {
        clickElementBy(yeniKisiEkle);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_yeniGrupOlustur() {
        clickElementBy(yeniGrupOlustur);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_closeDialog() {
        clickElementBy(closeDialog);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_vazgecButonuDialog() {
        clickElementBy(dialog_vazgecButonu);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_devamEtButonu_dialog() {
        clickElementBy(dialog_devamEtButonu);
        clickElementBy(IBANSildiktenSonra_TamamButton);
        Log.info(getNames());
        return this;
    }

    @Step("{method} {0}")
    public RehberimVeBankHspPage sendkey_grupAdiGirTextBox(String text) {
        clearAndfillInFieldWith(grupAdiGirTextBox, text);
        Log.info("Value: " + text);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_devamEtButonu() {
        clickElementBy(devamEtButonu);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_kaydetButonu() {
        clickElementBy(kaydetButonu);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_grubaEklemekicinKisiSec() throws IOException, ParseException {
        clickElementBy(grubaEklemekicinKisiSec);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_paraIsteButonu() {
        clickElementBy(paraIsteButonu);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_paraGonderButonu() {
        clickElementBy(paraGonderButonu);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_silButonu() {
        clickElementBy(silButonu);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_grubaKisiEkle() {
        clickElementBy(grubaKisiEkle);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_grubuSil() {
        clickElementBy(grubuSil);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_grubuSil_OnaylaButton() {
        clickElementBy(grubuSil_OnaylaButton);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_grubuSil_TamamButton() {
        clickElementBy(grubuSil_TamamButton);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_grubuSil_VazgecButton() {
        clickElementBy(grubuSil_VazgecButton);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_rehbereKaydet() {
        clickElementBy(rehbereKaydet);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_saveButton() {
        clickElementBy(saveButton);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_DavetEt() {
        clickElementBy(davetEt);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_GrupSec() {
        clickElementBy(grupSec);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public String getErrorText() {
        saveTextLog(getTextFromElement(IBANText));
        Log.info(getNames());
        return driver.findElement(IBANText).getText();
    }

    public String getErrorText_Semi() {
        saveTextLog(getTextFromElement(semiIBANHataText));
        Log.info(getNames());
        return driver.findElement(semiIBANHataText).getText();
    }

    @Step("{method}")
    public String getDavetEtText() {
        saveTextLog(getTextFromElement(davetEtTextAssert));
        Log.info(getNames());
        return driver.findElement(davetEtTextAssert).getText();
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_NewRecord() {
        swipeToElement(yeniKayitNo);
        clickElementBy(yeniKaydedilenKisi);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage set_kisiAdiDegistirTextBox() throws IOException, ParseException {
        clearAndfillInFieldWith(kisiAdiDegistirTextBox, getString("aliciAdSoyad"));
        Log.info(getNames());
        return this;
    }


    @Step("{method}")
    public RehberimVeBankHspPage IbanBilgileriniDoldur() throws IOException, ParseException {

        clearAndfillInFieldWith(aliciAdSoyad, getString("aliciAdSoyad"));
        clearAndfillInFieldWith(aliciIBAN, getString("iban"));
        clickElementBy(IBANKaydetButton);

        boolean ibanText = driver.findElements(By.id("tv_information_dialog_message")).size() > 0;

        if (ibanText) {
            try {
                clickElementBy(IBANKaydetmeText_devamEtButonu);
                boolean tamamText = driver.findElements(By.id("fs_success_dialog_submith")).size() > 0;
                if (tamamText) {
                    clickElementBy(IBANKaydetTamamButton);
                } else {
                    Log.info("Devam");
                }
            } catch (NoSuchElementException noSuchElementException) {
                Log.info(IBAN_KAYDETME_TEXT + " uyarısı gelmedi, devam ediliyor.");
            }
        } else {
            clickElementBy(IBANKaydetTamamButton);
        }

        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage IbanBilgileriniDoldur_Semi() throws IOException, ParseException {
        clearAndfillInFieldWith(aliciIBAN, getString("yanlisIban"));
        clickElementBy(IBANKaydetButton);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage IBANKaydedilenKisiyiSec() {
        clickElementBy(kaydedilenIBANiSec);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_IBANSilButton() {
        clickElementBy(IBANSilButton);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage rehberdenKisiSec() {
        clickElementBy(rehberdenKisiSec);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage kisiSectiktenSonraDevamEt() {
        clickElementBy(kisiSectiktenSonraDevamETButton);
        Log.info(getNames());
        return this;
    }

}
