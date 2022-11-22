package Pages;

import Libraries.BaseClass;
import Libraries.TestUtils;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import java.io.IOException;

import static Libraries.TestUtils.*;
import static Pages.StringConstants.yeniKayitNo;

public class RehberimVeBankHspPage extends BaseClass {

    private final By ibanSekmesi = By.id("radioButtonContacts2");
    private final By plusButton = By.id("ibSecondButton");
    private final By searchButton = By.id("ibFirstButton");
    private final By editButton = By.id("ibFirstButton");
    private final By searchBar = By.id("iSearchField");
    private final By closeSearchBar = By.id("iSearchCloseBtn");
    private final By yeniKisiEkle = By.xpath("//android.widget.TextView[@text='Yeni Kişi Ekle']");
    private final By yeniGrupOlustur = By.xpath("//android.widget.TextView[@text='Yeni Grup Oluştur']");
    private final By closeDialog = By.className("android.widget.ImageButton");
    private final By dialog_vazgecButonu = By.id("btn_confirmation_dialog_cancel");
    private final By dialog_devamEtButonu = By.id("btn_confirmation_dialog_confirm");
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
    private final By IBANText = By.id("tv_confirmation_dialog_message");
    private final By davetEt = By.xpath("(//*[@text='DAVET ET'])[2]");
    private final By davetEtTextAssert = By.id("tr.com.turktelekom.pokus.test:id/tv_information_dialog_message");
    private final By yeniKaydedilenKisi = By.xpath("//*[@text='" + yeniKayitNo + "']");
    private final By kisiAdiDegistirTextBox = By.xpath("//android.widget.EditText[@text='First name']");



    //Constructor
    public RehberimVeBankHspPage(AndroidDriver<MobileElement> driver) {
        BaseClass.driver = driver;
    }

    //Methods

    @Step("{method}")
    public RehberimVeBankHspPage click_IbanSekmesi() {
        clickElementBy(ibanSekmesi);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_plusButton() {
        clickElementBy(plusButton);
        Log.info("I clicked: " + this.getClass().getSimpleName());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_searchButton() {
        clickElementBy(searchButton);
        return this;
    }

    @Step("{method} {0}")
    public RehberimVeBankHspPage sendkeys_searchBar(String text) {
        TestUtils.clearAndfillInFieldWith(searchBar, text);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage close_SearchBar() {
        clickElementBy(closeSearchBar);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_Duzenle() {
        clickElementBy(editButton);
        return this;
    }
    @Step("{method}")
    public RehberimVeBankHspPage click_yeniKisiEkle() {
        clickElementBy(yeniKisiEkle);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_yeniGrupOlustur() {
        clickElementBy(yeniGrupOlustur);
        Log.info("I clicked: " + this.getClass().getSimpleName());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_closeDialog() {
        clickElementBy(closeDialog);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_vazgecButonuDialog() {
        clickElementBy(dialog_vazgecButonu);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_devamEtButonu_dialog() {
        clickElementBy(dialog_devamEtButonu);
        Log.info("I clicked: " + this.getClass().getSimpleName());
        return this;
    }

    @Step("{method} {0}")
    public RehberimVeBankHspPage sendkey_grupAdiGirTextBox(String text) {
        clearAndfillInFieldWith(grupAdiGirTextBox, text);
        System.out.println("Value: " + text);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_devamEtButonu() {
        clickElementBy(devamEtButonu);
        Log.info("I clicked: " + this.getClass().getSimpleName());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_kaydetButonu() {
        clickElementBy(kaydetButonu);
        Log.info("I clicked: " + this.getClass().getSimpleName());
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_grubaEklemekicinKisiSec() throws IOException, ParseException {
        clickElementBy(grubaEklemekicinKisiSec);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_paraIsteButonu() {
        clickElementBy(paraIsteButonu);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_paraGonderButonu() {
        clickElementBy(paraGonderButonu);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_silButonu() {
        clickElementBy(silButonu);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_grubaKisiEkle() {
        clickElementBy(grubaKisiEkle);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_grubuSil() {
        clickElementBy(grubuSil);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_grubuSil_OnaylaButton() {
        clickElementBy(grubuSil_OnaylaButton);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_grubuSil_TamamButton() {
        clickElementBy(grubuSil_TamamButton);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_grubuSil_VazgecButton() {
        clickElementBy(grubuSil_VazgecButton);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_rehbereKaydet() {
        clickElementBy(rehbereKaydet);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_saveButton() {
        clickElementBy(saveButton);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_DavetEt() {
        clickElementBy(davetEt);
        return this;
    }

    @Step("{method}")
    public String getErrorText() {
        return driver.findElement(IBANText).getText();
    }

    @Step("{method}")
    public String getDavetEtText() {
        return driver.findElement(davetEtTextAssert).getText();
    }

    @Step("{method}")
    public RehberimVeBankHspPage click_NewRecord() {
        swipeToElement(yeniKayitNo);
        clickElementBy(yeniKaydedilenKisi);
        return this;
    }

    @Step("{method}")
    public RehberimVeBankHspPage set_kisiAdiDegistirTextBox() throws IOException, ParseException {
        clearAndfillInFieldWith(kisiAdiDegistirTextBox,getString("aliciAdSoyad"));
        return this;
    }

}
