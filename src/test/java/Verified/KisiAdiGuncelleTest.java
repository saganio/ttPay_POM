package Verified;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Pages.StringConstants.STEP_MESSAGE;

/**
 * Created by uguryildiz on 20.11.2022
 */
public class KisiAdiGuncelleTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Kişi Adı güncelleme testi.")
    public void KisiAdiGuncelle() throws IOException, ParseException {

        loginPage
                .Verifiedlogin()
                .click_HamburgerMenu();

        leftPanelPage
                .click_rehberimVeBankaHesaplarim();

        RehberimVeBankaHesaplarimPage
                .click_grubaEklemekicinKisiSec()
                .click_Duzenle()
                .set_kisiAdiDegistirTextBox()
                .click_saveButton();


    }

}
