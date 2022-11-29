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

import static Libraries.TestUtils.testAssertFunctions;
import static Pages.StringConstants.STEP_MESSAGE;
import static Pages.StringConstants.hataMesaji_PARAGONDER;

public class ParaGonderTest extends BaseClass {
    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Para Gönderme senaryosu")
    public void LoginAndClickParaGonder() throws IOException, ParseException, SQLException {

        dbQueries
                .bakiyeKontrol_Basic();

        loginPage
                .login();

        homePage
                .click_ParaGonderButonu();

        testAssertFunctions(hataMesaji_PARAGONDER, homePage.get_ConfirmationDialogText());

    }


}
