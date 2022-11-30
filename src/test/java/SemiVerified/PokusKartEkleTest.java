package SemiVerified;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;


import static Pages.StringConstants.POKUSKART_KAYDET_TEXT;
import static Pages.StringConstants.STEP_MESSAGE;

public class PokusKartEkleTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Pokus Kart Ekleme testi.")
    public void PokusKartEkle() throws IOException, ParseException {

        loginPage
                .semiVerifiedlogin();
        homePage
                .click_Kartlarim();
        kartlarimPage
                .click_pokusKartEkleOlustur()
                .click_pokusKartiniEkle();

    }

}
