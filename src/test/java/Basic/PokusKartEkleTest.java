package Basic;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Libraries.TestUtils.testAssertFunctions;
import static Pages.StringConstants.POKUSKART_KAYDET_TEXT;

public class PokusKartEkleTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Description("Pokus Kart Ekleme testi.")
    public void PokusKartEkle() throws IOException, ParseException {

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
