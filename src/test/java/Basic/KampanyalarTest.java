package Basic;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.IOException;

public class KampanyalarTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Description("Giriş testi.")
    public void LoginAndCheckCampaigns() throws IOException, ParseException {

        loginPage
                .login();

    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Kampanyaları görüntüleme testi.")
    public void Step2(){

        homePage
                .click_Kampanyalar();
        campaignsPage
                .clickSwitchButton()
                .clickSwitchButton()
                .clickCampaign();

    }
}
