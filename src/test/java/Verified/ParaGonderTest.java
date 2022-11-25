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

public class ParaGonderTest extends BaseClass {
    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Para Gönderme senaryosu")
    public void LoginAndClickParaGonder() throws IOException, ParseException, InterruptedException, SQLException {

        loginPage
                .Verifiedlogin();

        homePage
                .click_ParaGonderButonu()
                .click_KisiyeSecenegi();

        RehberimVeBankaHesaplarimPage

                .rehberdenKisiSec()
                .kisiSectiktenSonraDevamEt();

        globalPage
                .tutarGir_ParaGonder()
                .OTPGir_Verified();

        dbQueries
                .otp_SMS_transaction_log()
                .bakiyeKontrol_Verified()
                .push_Notification_log();

    }


}
