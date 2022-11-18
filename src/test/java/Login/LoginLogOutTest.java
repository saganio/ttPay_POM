package Login;

import Libraries.BaseClass;
import Pages.GlobalPage;
import Pages.LeftPanelPage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginLogOutTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Şifreyi Gir")
    @Description("Kullancı Adı ve Şifre ile giriş yapma senaryosu.")
    public void LoginAndLogOut() throws IOException, ParseException {

        LoginPage LP = new LoginPage(driver);
        LeftPanelPage leftPanelPage = new LeftPanelPage(driver);
        GlobalPage globalPage = new GlobalPage(driver);

        LP
                .login();
        leftPanelPage
                .click_cikisYap();
        globalPage
                .click_EvetDialog();

    }

}
