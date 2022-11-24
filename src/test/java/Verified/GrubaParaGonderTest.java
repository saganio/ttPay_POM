package Verified;

import Libraries.BaseClass;
import Libraries.TestUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static Pages.StringConstants.hataMesaji_PARAGONDER;

public class GrubaParaGonderTest extends BaseClass {


    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Description("Gruba Para Gönderme senaryosu")
    public void GrubaParaGonder() throws IOException, ParseException, SQLException {

        dbQueries
                .bakiyeKontrol_Verified();

        loginPage
                .Verifiedlogin()
                .click_HamburgerMenu();

        leftPanelPage
                .click_rehberimVeBankaHesaplarim();

        RehberimVeBankaHesaplarimPage
                .click_plusButton()
                .click_yeniGrupOlustur()
                .sendkey_grupAdiGirTextBox(getString("groupName"))
                .click_devamEtButonu()
                .click_grubaEklemekicinKisiSec()
                .click_kaydetButonu()
                .click_paraGonderButonu();

        TestUtils.testAssertFunctions(hataMesaji_PARAGONDER, hataMesaji_PARAGONDER);

        RehberimVeBankaHesaplarimPage
                .click_vazgecButonuDialog()
                .click_grubuSil()
                .click_grubuSil_OnaylaButton()
                .click_grubuSil_TamamButton();

        dbQueries
                .otp_SMS_transaction_log()
                .bakiyeKontrol_Verified()
                .push_Notification_log();
    }
}
