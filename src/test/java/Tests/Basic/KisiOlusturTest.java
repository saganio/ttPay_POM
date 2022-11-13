package Tests.Basic;

import Libraries.BaseClass;
import Pages.LeftPanelPage;
import Pages.LoginPage;
import Pages.RehberimVeBankHspPage;
import Utils.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(TestListener.class)
public class KisiOlusturTest extends BaseClass {


    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Şifreyi Gir, Kişi Oluştur")
    @Description("Kişi Oluşturma senaryosu")

    public void KisiOlustur() throws IOException, ParseException {

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
                .click_yeniKisiEkle()
                .sendkey_grupAdiGirTextBox(rastgeleNumaraGir())
                .click_rehbereKaydet()
                .click_saveButton();

    }


}
