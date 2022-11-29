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

import static Libraries.TestUtils.testAssertFunctions;
import static Pages.StringConstants.STEP_MESSAGE;
import static Pages.StringConstants.hataMesaji_BANKAHESABI;

public class BankadanParaYukleTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Banka hesabından para yükleme testi.")
    public void BankaHesabindanParaYukle() throws IOException, ParseException, SQLException {

        dbQueries
                .bakiyeKontrol_semi();

        loginPage
                .semiVerifiedlogin();
        homePage.click_YukleButonu()
                .click_KrediBankaHesabimdan()
                .click_TamamButtonBefore()
                .click_TamamButtonAfter();

        dbQueries
                .otp_SMS_transaction_log()
                .bakiyeKontrol_semi()
                .push_Notification_log()
                .total_Tax_Amount_semi();
    }

}
