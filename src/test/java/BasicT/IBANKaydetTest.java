package BasicT;

import Libraries.BaseClass;
import Pages.LeftPanelPage;
import Pages.LoginPage;
import Pages.RehberimVeBankHspPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Libraries.TestUtils.testAssertFunctions;
import static Pages.StringConstants.IBAN_KAYDETME_TEXT;

public class IBANKaydetTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Şifreyi Gir, 3- IBAN Kaydet")
    @Description("IBAN Kaydetme testi.")
    public void IBANKaydet() throws IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        LeftPanelPage leftPanelPage = new LeftPanelPage(driver);
        RehberimVeBankHspPage rehberimVeBankHspPage = new RehberimVeBankHspPage(driver);


        loginPage
                .login()
                .click_HamburgerMenu();
        leftPanelPage
                .click_rehberimVeBankaHesaplarim();
        rehberimVeBankHspPage
                .click_IbanSekmesi()
                .click_plusButton();

        testAssertFunctions(IBAN_KAYDETME_TEXT, rehberimVeBankHspPage.getErrorText());

        rehberimVeBankHspPage
                .click_vazgecButonuDialog();
    }

}
