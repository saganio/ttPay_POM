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

/**
 * Created by uguryildiz on 17.11.2022
 */
public class FaturaOdeTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Fatura Ödeme testi.")
    public void FaturaOde() throws IOException, ParseException, SQLException {

        dbQueries
                .bakiyeKontrol_semi();

        loginPage
                .semiVerifiedlogin();

        homePage
                .click_OdemeYapButonu()
                .click_FaturaOde();

        dbQueries
                .otp_SMS_transaction_log()
                .bakiyeKontrol_semi()
                .push_Notification_log()
                .total_Tax_Amount_semi();

    }
}
