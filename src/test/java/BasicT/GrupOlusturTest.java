package BasicT;

import Libraries.BaseClass;
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

public class GrupOlusturTest extends BaseClass {


    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Şifreyi Gir, 3- Para Gönder")
    @Description("Para Gönderme senaryosu")

    public void GrupOlustur() throws IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        RehberimVeBankHspPage RehberimVeBankaHesaplarimPage = new RehberimVeBankHspPage(driver);
        LeftPanelPage leftPanelPage = new LeftPanelPage(driver);

        loginPage
                .login()
                .click_HamburgerMenu();

        leftPanelPage
                .click_rehberimVeBankaHesaplarim();

        RehberimVeBankaHesaplarimPage
                .click_plusButton()
                .click_yeniGrupOlustur()
                .sendkey_grupAdiGirTextBox(getString("groupName"))
                .click_devamEtButonu()
                .click_grubaEklemekicinKisiSec()
                .click_kaydetButonu()
                .click_grubuSil()
                .click_devamEtButonu_dialog();

    }
}
