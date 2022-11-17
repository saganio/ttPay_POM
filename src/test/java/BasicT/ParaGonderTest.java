package BasicT;

import Libraries.BaseClass;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static Libraries.TestUtils.testAssertFunctions;
import static Pages.StringConstants.hataMesaji_PARAGONDER;

public class ParaGonderTest extends BaseClass {
    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Şifreyi Gir, 3- Para Gönder")
    @Description("Para Gönderme senaryosu")
    public void LoginAndClickParaGonder() throws IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        homePage.click_ParaGonderButonu();
        testAssertFunctions(hataMesaji_PARAGONDER, homePage.get_ConfirmationDialogText());

    }


}