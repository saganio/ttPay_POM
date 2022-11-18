package BasicT;

import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Libraries.BaseClass.driver;

/**
 * Created by uguryildiz on 17.11.2022
 */
public class FaturaOdeTest {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Şifreyi Gir, 3- Ödeme Yap, 4-Fatura Öde")
    @Description("Fatura Ödeme testi.")
    public void FaturaOde() throws IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage
                .login();

        homePage
                .click_OdemeYapButonu()
                .click_FaturaOde();


    }
}
