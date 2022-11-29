package Basic;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static Libraries.TestUtils.testAssertFunctions;
import static Pages.StringConstants.KREDIBANKAKARTIKAYDET_TEXT;
import static Pages.StringConstants.STEP_MESSAGE;

public class KrediBankaKartiEkleTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Kredi Banka Kartı Ekleme testi.")
    public void KrediBankaKartiEkle() throws IOException, ParseException, SQLException {

        dbQueries
                .bakiyeKontrol_Basic();
        loginPage
                .login();
        homePage
                .click_Kartlarim();
        kartlarimPage
                .click_krediBankaKartiEkle();

        testAssertFunctions(KREDIBANKAKARTIKAYDET_TEXT, kartlarimPage.getHataMesajiText());

        RehberimVeBankaHesaplarimPage
                .click_vazgecButonuDialog();

    }

}
