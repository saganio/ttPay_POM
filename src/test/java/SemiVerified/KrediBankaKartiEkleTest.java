package SemiVerified;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;


import static Pages.StringConstants.KREDIBANKAKARTIKAYDET_TEXT;
import static Pages.StringConstants.STEP_MESSAGE;

public class KrediBankaKartiEkleTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Kredi Banka Kartı Ekleme testi.")
    public void KrediBankaKartiEkle() throws IOException, ParseException {

        loginPage
                .semiVerifiedlogin();
        homePage
                .click_Kartlarim();
        kartlarimPage
                .click_krediBankaKartiEkle();

        globalPage
                .CompareTexts(KREDIBANKAKARTIKAYDET_TEXT, kartlarimPage.getHataMesajiText());

        RehberimVeBankaHesaplarimPage
                .click_vazgecButonuDialog();

    }

}
