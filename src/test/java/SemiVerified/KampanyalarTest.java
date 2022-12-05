package SemiVerified;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import static Pages.StringConstants.STEP_MESSAGE;

public class KampanyalarTest extends BaseClass {

    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Kampanyaları kontrol testi.")
    public void LoginAndCheckCampaigns() throws IOException, ParseException, SQLException {

        dbQueries
                .bakiyeKontrol_semi();

        loginPage
                .semiVerifiedlogin();

    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Kampanyaları görüntüleme testi.")
    @Step(STEP_MESSAGE)
    public void Step2() throws SQLException, IOException {

        homePage
                .click_Kampanyalar();
        campaignsPage
                .clickSwitchButton()
                .clickSwitchButton()
                .clickCampaign();

        dbQueries
                .otp_SMS_transaction_log()
                .bakiyeKontrol_semi()
                .push_Notification_log()
                .total_Tax_Amount_semi();

    }
}
