package Tests.Basic;

import Libraries.BaseClass;
import Pages.HomePage;
import Pages.KartlarimPage;
import Pages.LoginPage;
import Pages.RehberimVeBankHspPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Libraries.TestUtils.testAssertFunctions;
import static Pages.StringConstants.KREDIBANKAKARTIKAYDET_TEXT;
import static Pages.StringConstants.POKUSKART_KAYDET_TEXT;

public class KrediBankaKartiEkleTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Şifreyi Gir, 3- Kredi Banka Kartı Ekle")
    @Description("Kredi Banka Kartı Ekleme testi.")
    public void KrediBankaKartiEkle() throws IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        KartlarimPage kartlarimPage = new KartlarimPage(driver);
        RehberimVeBankHspPage rehberimVeBankHspPage = new RehberimVeBankHspPage(driver);

        loginPage
                .login();
        homePage
                .click_Kartlarim();
        kartlarimPage
                .click_krediBankaKartiEkle();

        testAssertFunctions(KREDIBANKAKARTIKAYDET_TEXT, kartlarimPage.getHataMesajiText());

        rehberimVeBankHspPage
                .click_vazgecButonuDialog();

    }

}
