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

import static Pages.StringConstants.STEP_MESSAGE;

public class KisidenParaIsteTest extends BaseClass {
    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Kayıtlı Kişiden Para İsteme senaryosu")
    public void KayitliKisidenParaIste() throws IOException, ParseException, InterruptedException, SQLException {

        loginPage
                .Verifiedlogin()
                .click_HamburgerMenu();

        leftPanelPage
                .click_rehberimVeBankaHesaplarim();

        RehberimVeBankaHesaplarimPage
                .click_grubaEklemekicinKisiSec()
                .click_paraIsteButonu();

        globalPage
                .tutarGir_ParaIste();

        dbQueries
                .otp_SMS_transaction_log()
                .bakiyeKontrol_Verified()
                .push_Notification_log()
                .total_Tax_Amount_verified();

    }


}
