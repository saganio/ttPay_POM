package BasicT;

import Libraries.BaseClass;
import Libraries.TestUtils;
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

import static Pages.StringConstants.hataMesaji_PARAGONDER;

public class GrubaParaGonderTest extends BaseClass {


    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Description("Gruba Para Gönderme senaryosu")
    public void GrubaParaGonder() throws IOException, ParseException {

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
                .click_paraGonderButonu();

        TestUtils.testAssertFunctions(hataMesaji_PARAGONDER, hataMesaji_PARAGONDER);

        RehberimVeBankaHesaplarimPage
                .click_vazgecButonuDialog()
                .click_grubuSil()
                .click_grubuSil_OnaylaButton()
                .click_grubuSil_TamamButton();
    }


}
