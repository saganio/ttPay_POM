package SemiVerified;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by uguryildiz on 17.11.2022
 */
public class FaturaOdeTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Şifreyi Gir, 3- Ödeme Yap, 4-Fatura Öde")
    @Description("Fatura Ödeme testi.")
    public void FaturaOde() throws IOException, ParseException {

        loginPage
                .semiVerifiedlogin();

        homePage
                .click_OdemeYapButonu()
                .click_FaturaOde();


    }
}
