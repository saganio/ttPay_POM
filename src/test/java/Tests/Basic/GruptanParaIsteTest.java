package Tests.Basic;

import Libraries.BaseClass;
import Libraries.TestUtils;
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

import static Pages.StringConstants.hataMesaji_PARAGONDER;
import static Pages.StringConstants.hataMesaji_PARAISTE;

@Listeners(TestListener.class)
public class GruptanParaIsteTest extends BaseClass {


    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Şifreyi Gir, 3- Gruptan Para İste")
    @Description("Gruptan Para İsteme senaryosu")

    public void GruptanParaIste() throws IOException, ParseException {

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
                .click_paraIsteButonu();
                 TestUtils.testAssertFunctions(hataMesaji_PARAISTE,hataMesaji_PARAISTE);

        RehberimVeBankaHesaplarimPage
                .click_vazgecButonuDialog()
                .click_grubuSil()
                .click_grubuSil_OnaylaButton()
                .click_grubuSil_TamamButton();
    }


}
