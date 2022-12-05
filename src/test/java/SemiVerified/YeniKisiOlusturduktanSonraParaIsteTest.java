package SemiVerified;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;


import static Pages.StringConstants.*;

public class YeniKisiOlusturduktanSonraParaIsteTest extends BaseClass {


    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Yeni kişi oluşturduktan sonra Para Gönderme senaryosu")
    public void YeniKisiOlusturVeParaGonder() throws IOException, ParseException, SQLException {

        dbQueries
                .bakiyeKontrol_semi();

        loginPage
                .semiVerifiedlogin()
                .click_HamburgerMenu();

        leftPanelPage
                .click_rehberimVeBankaHesaplarim();

        RehberimVeBankaHesaplarimPage
                .click_plusButton()
                .click_yeniKisiEkle()
                .sendkey_grupAdiGirTextBox(yeniKayitNo)
                .click_rehbereKaydet()
                .click_saveButton()
                .click_NewRecord()
                .click_paraIsteButonu();

        globalPage
                .CompareTexts(hataMesaji_PARAISTE, RehberimVeBankaHesaplarimPage.getErrorText());

        RehberimVeBankaHesaplarimPage
                .click_vazgecButonuDialog();

        dbQueries
                .otp_SMS_transaction_log()
                .bakiyeKontrol_semi()
                .push_Notification_log()
                .total_Tax_Amount_semi();

    }


}
