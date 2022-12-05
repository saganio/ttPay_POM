package Register;

import Libraries.BaseClass;
import Libraries.TestUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Pages.StringConstants.STEP_MESSAGE;
import static Pages.StringConstants.VAR_OLAN_HESAP_ERROR_TEXT;

public class RegisterVarOlanKullaniciTest extends BaseClass {

    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Sistemde kayıtlı olan kullanıcıyı tekrar kaydetme senaryosu.")
    public void RegisterVarOlanKullanici() throws IOException, ParseException {

        registerPage
                .click_HesabimYok()
                .click_HesapOlusturmayaTikla()
                .sendKeys_Msisdn(getString("id"))
                .click_devamEtButton();

        globalPage
                .CompareTexts(VAR_OLAN_HESAP_ERROR_TEXT, registerPage.getVarOlanHesapErrorText());

        registerPage
                .click_TamamDialog();
    }

}
