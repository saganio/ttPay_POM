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

public class ParaIsteTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Para İsteme senaryosu.")
    public void ParaIste() throws IOException, ParseException, SQLException, InterruptedException {

        dbQueries
                .bakiyeKontrol_Verified();

        loginPage
                .Verifiedlogin();

        homePage
                .click_ParaIsteButonu();

        RehberimVeBankaHesaplarimPage
                .rehberdenKisiSec()
                .kisiSectiktenSonraDevamEt();

        globalPage
                .tutarGir_ParaIste();

        dbQueries
                .otp_SMS_transaction_log()
                .bakiyeKontrol_Verified()
                .push_Notification_log();

    }

}
