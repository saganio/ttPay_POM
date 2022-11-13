package Tests.Basic;

import Libraries.BaseClass;
import Pages.CampaignsPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class KampanyalarTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Şifreyi Gir, 3- Kampanyaları Kontrol et")
    @Description("Kampanyaları görüntüleme testi.")
    public void LoginAndCheckCampaigns() throws IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CampaignsPage campaignsPage = new CampaignsPage(driver);

        loginPage.login();
        homePage.click_Kampanyalar();
        campaignsPage.clickSwitchButton();
        campaignsPage.clickSwitchButton();
        campaignsPage.clickCampaign();

    }

}
