package SemiVerified;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.SQLException;
import static Libraries.TestUtils.testAssertFunctions;
import static Pages.DBQueries.GET_SEMI_AMOUNT_SQL;
import static Pages.DBQueries.SET_SEMIVERIFIED_OTP_SQL;
import static Pages.StringConstants.hataMesaji_PARAISTE;

public class ParaIsteTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Description("Para İsteme senaryosu.")
    public void ParaIste() throws IOException, ParseException, SQLException {

        dbQueries
                .bakiyeKontrol_semi();

        loginPage
                .semiVerifiedlogin();

        homePage
                .click_ParaIsteButonu();

        testAssertFunctions(hataMesaji_PARAISTE, homePage.get_ConfirmationDialogText());

        dbQueries
                .bakiyeKontrol_semi();

    }

}
