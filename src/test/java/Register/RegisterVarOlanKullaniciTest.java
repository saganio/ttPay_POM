package Register;

import Libraries.BaseClass;
import Libraries.TestUtils;
import Pages.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Pages.StringConstants.VAR_OLAN_HESAP_ERROR_TEXT;

public class RegisterVarOlanKullaniciTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Hesabim Yok, 2- Hesap Oluşturmaya Başla, 3-Var Olan Kullanicinin numarasini gir..")
    @Description("Sistemde kayıtlı olan kullanıcıyı tekrar kaydetme senaryosu.")
    public void RegisterVarOlanKullanici() throws IOException, ParseException {

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage
                .click_HesabimYok()
                .click_HesapOlusturmayaTikla()
                .sendKeys_Msisdn(getString("id"))
                .click_devamEtButton();

        TestUtils
                .testAssertFunctions(VAR_OLAN_HESAP_ERROR_TEXT, registerPage.getVarOlanHesapErrorText());

        registerPage
                .click_TamamDialog();
    }

}
