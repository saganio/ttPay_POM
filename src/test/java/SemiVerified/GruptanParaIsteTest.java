package SemiVerified;

import Libraries.BaseClass;
import Libraries.TestUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Pages.StringConstants.hataMesaji_PARAISTE;

public class GruptanParaIsteTest extends BaseClass {


    @Severity(SeverityLevel.MINOR)
    @Description("Gruptan Para İsteme senaryosu")
    @Test(priority = 0)
    public void GruptanParaIste() throws IOException, ParseException {

        loginPage
                .semiVerifiedlogin()
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

        TestUtils.testAssertFunctions(hataMesaji_PARAISTE, hataMesaji_PARAISTE);

        RehberimVeBankaHesaplarimPage
                .click_vazgecButonuDialog()
                .click_grubuSil()
                .click_grubuSil_OnaylaButton()
                .click_grubuSil_TamamButton();
    }


}
