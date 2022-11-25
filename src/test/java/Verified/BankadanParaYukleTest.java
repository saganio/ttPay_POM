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

public class BankadanParaYukleTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Banka hesabından para yükleme testi.")
    public void BankaHesabindanParaYukle() throws IOException, ParseException {

        loginPage
                .Verifiedlogin();
        homePage.click_YukleButonu()
                .click_KrediBankaHesabimdan()
                .click_TamamButtonBefore()
                .click_TamamButtonAfter();
    }

}
