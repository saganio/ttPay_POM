package Verified;

import Libraries.BaseClass;
import com.sun.xml.bind.v2.TODO;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static Pages.StringConstants.STEP_MESSAGE;

public class KrediBankaKartiEkleTest extends BaseClass {

    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Kredi Banka Kartı Ekleme testi.")
    public void KrediBankaKartiEkle() throws IOException, ParseException, SQLException {

        loginPage
                .Verifiedlogin();
        homePage
                .click_Kartlarim();
        kartlarimPage
                .click_krediBankaKartiEkle();

        // TODO: 25.11.2022

        dbQueries
                .otp_SMS_transaction_log()
                .bakiyeKontrol_Verified()
                .push_Notification_log();
    }

}
