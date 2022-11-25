package Basic;

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
 * Created by uguryildiz on 21.11.2022
 */
public class AdresGuncelleTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Kayıtlı Kişiye Para Gönderme senaryosu")
    public void AdresGuncelle() throws IOException, ParseException {

        loginPage
                .login()
                .click_HamburgerMenu();

        leftPanelPage
                .click_Profil();

        profilPage
                .click_adresDuzenleButton()
                .click_ilSecDialog()
                .click_Adana()
                .click_secButton()
                .click_ilceSecDialog()
                .click_Aladag()
                .click_secButton()
                .sendkeys_acikAdresTextBox()
                .click_tamamveGuncelleButton()
                .setOTP_Basic();
    }

}
