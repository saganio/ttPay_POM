package Basic;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Libraries.TestUtils.testAssertFunctions;
import static Pages.StringConstants.hataMesaji_PARAISTE;

public class ParaIsteTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Description("Para İsteme senaryosu.")
    public void LoginAndClickParaIste() throws IOException, ParseException {

        loginPage
                .login();

        homePage
                .click_ParaIsteButonu();

        testAssertFunctions(hataMesaji_PARAISTE, homePage.get_ConfirmationDialogText());


    }

}
