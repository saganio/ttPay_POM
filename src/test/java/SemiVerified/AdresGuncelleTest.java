package SemiVerified;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by uguryildiz on 21.11.2022
 */
public class AdresGuncelleTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Description("Adres Güncelleme Senaryosu")
    public void AdresGuncelle() throws IOException, ParseException, SQLException {

        loginPage
                .semiVerifiedlogin()
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
                .setOTP_SemiVerified();

    }

}
