package Verified;

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

public class YeniKisiOlusturduktanSonraParaGonderTest extends BaseClass {

    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Yeni Kişi ekledikten sonra Para Gönderme senaryosu")
    public void YeniKisiOlusturVeParaGonder() throws IOException, ParseException, InterruptedException, SQLException {

        dbQueries
                .bakiyeKontrol_Verified();

        loginPage
                .Verifiedlogin()
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
                .click_paraGonderButonu();

        globalPage
                .tutarGir_ParaGonder()
                .OTPGir_Verified()
                .check_Notifications().wait2Sec().goBack()
                .click_Islemlerim()
                .click_BekleyenIslemlerim();

        dbQueries
                .otp_SMS_transaction_log()
                .bakiyeKontrol_Verified()
                .push_Notification_log()
                .total_Tax_Amount_verified();
    }


}
