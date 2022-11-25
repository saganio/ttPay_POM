package SemiVerified;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Pages.StringConstants.STEP_MESSAGE;

public class GrupOlusturTest extends BaseClass {


    @Severity(SeverityLevel.MINOR)
    @Description("Grup oluşturma ve silme testi.")
    @Step(STEP_MESSAGE)
    @Test(priority = 0)
    public void GrupOlustur() throws IOException, ParseException {

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
                .click_grubuSil()
                .click_devamEtButonu_dialog();

    }
}
