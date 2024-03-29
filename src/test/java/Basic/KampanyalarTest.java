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

public class KampanyalarTest extends BaseClass {

    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Giriş testi.")
    public void LoginAndCheckCampaigns() throws IOException, ParseException, SQLException {
        dbQueries
                .bakiyeKontrol_Basic();
        loginPage
                .login();

    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Kampanyaları görüntüleme testi.")
    public void Step2() {

        homePage
                .click_Kampanyalar();
        campaignsPage
                .clickSwitchButton()
                .clickSwitchButton()
                .clickCampaign();

    }
}
