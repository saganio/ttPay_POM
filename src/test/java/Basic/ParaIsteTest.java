package Basic;

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
import static Pages.StringConstants.hataMesaji_PARAISTE;

public class ParaIsteTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Para İsteme senaryosu.")
    public void LoginAndClickParaIste() throws IOException, ParseException, SQLException {

        dbQueries
                .bakiyeKontrol_Basic();

        loginPage
                .login();

        homePage
                .click_ParaIsteButonu();

        globalPage
                .CompareTexts(hataMesaji_PARAISTE, homePage.get_ConfirmationDialogText());


    }

}
