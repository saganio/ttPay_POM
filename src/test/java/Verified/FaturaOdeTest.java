package Verified;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by uguryildiz on 17.11.2022
 */
public class FaturaOdeTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Şifreyi Gir, 3- Ödeme Yap, 4-Fatura Öde")
    @Description("Fatura Ödeme testi.")
    public void FaturaOde() throws IOException, ParseException, SQLException {

        dbQueries
                .bakiyeKontrol_Verified();

        loginPage
                .Verifiedlogin();

        homePage
                .click_OdemeYapButonu()
                .click_FaturaOde();


    }
}
