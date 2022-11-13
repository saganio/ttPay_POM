package Tests.Basic;

import Libraries.BaseClass;
import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Libraries.TestUtils.testAssertFunctions;
import static Pages.StringConstants.hataMesaji_BANKAHESABI;

public class BankadanParaYukleTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Şifreyi Gir, 3- Banka hesabından para yükle")
    @Description("Banka hesabından para yükleme testi.")
    public void BankaHesabindanParaYukle() throws IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.click_YukleButonu();
        homePage.click_KrediBankaHesabimdan();

        testAssertFunctions(hataMesaji_BANKAHESABI, homePage.get_ConfirmationDialogText());
    }

}
