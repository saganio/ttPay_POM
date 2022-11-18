package BasicT;

import Pages.LeftPanelPage;
import Pages.LoginPage;
import Pages.RehberimVeBankHspPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Libraries.BaseClass.driver;
import static Libraries.TestUtils.testAssertFunctions;
import static Pages.StringConstants.DAVET_ET_TEXT;

/**
 * Created by uguryildiz on 17.11.2022
 */
public class KisiDavetEtTest {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Şifreyi Gir, 3- Rehberim ve Banka Hesaplarima Tıkla, 4-Kisi Davet Et")
    @Description("Kampanyaları görüntüleme testi.")
    public void KisiDavetEt() throws IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        RehberimVeBankHspPage rehberimVeBankHspPage = new RehberimVeBankHspPage(driver);
        LeftPanelPage leftPanelPage = new LeftPanelPage(driver);

        loginPage
                .login()
                .click_HamburgerMenu();

        leftPanelPage
                .click_rehberimVeBankaHesaplarim();

        rehberimVeBankHspPage
                .click_DavetEt()
                .click_devamEtButonu_dialog();

        testAssertFunctions(DAVET_ET_TEXT, rehberimVeBankHspPage.getDavetEtText());


    }
}
