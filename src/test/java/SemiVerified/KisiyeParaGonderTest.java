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


import static Pages.StringConstants.STEP_MESSAGE;
import static Pages.StringConstants.hataMesaji_PARAGONDER;

public class KisiyeParaGonderTest extends BaseClass {
    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Kayıtlı Kişiye Para Gönderme senaryosu")
    public void KayitliKisiyeParaGonder() throws IOException, ParseException, SQLException {

        dbQueries
                .bakiyeKontrol_semi();

        loginPage
                .semiVerifiedlogin()
                .click_HamburgerMenu();

        leftPanelPage
                .click_rehberimVeBankaHesaplarim();

        RehberimVeBankaHesaplarimPage
                .click_grubaEklemekicinKisiSec()
                .click_paraGonderButonu();

        globalPage
                .CompareTexts(hataMesaji_PARAGONDER, homePage.get_ConfirmationDialogText());

        dbQueries
                .otp_SMS_transaction_log()
                .bakiyeKontrol_semi()
                .push_Notification_log()
                .total_Tax_Amount_semi();

    }


}
