package Basic;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by uguryildiz on 20.11.2022
 */
public class SifreGuncelleTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Description("Şifre güncelleme testi. (Şifreyi güncellemez ekranı açar)")
    public void SifreGuncelle() throws IOException, ParseException {

        loginPage
                .login()
                .click_HamburgerMenu();

        leftPanelPage
                .click_ayarlarVeIzinler();

        ayarlarVeIzinlerPage
                .click_uygulamaParolasiText();

    }

}
