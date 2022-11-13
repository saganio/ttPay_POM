package Tests.Basic;

import Libraries.BaseClass;
import Pages.HomePage;
import Pages.KartlarimPage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Libraries.TestUtils.testAssertFunctions;
import static Pages.StringConstants.*;

public class PokusKartEkleTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Şifreyi Gir, 3- Pokus Kart Ekle")
    @Description("Pokus Kart Ekleme testi.")
    public void PokusKartEkle() throws IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        KartlarimPage kartlarimPage = new KartlarimPage(driver);

        loginPage
                .login();
        homePage
                .click_Kartlarim();
        kartlarimPage
                .click_pokusKartEkleOlustur()
                .click_pokusKartiniEkle();

        testAssertFunctions(POKUSKART_KAYDET_TEXT, kartlarimPage.getHataMesajiText());
    }

}
