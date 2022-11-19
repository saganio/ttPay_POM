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
import java.io.PipedReader;

public class LoginLogOutTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Description("Kullancı Adı ve Şifre ile giriş yapma senaryosu.")
    public void LoginAndLogOut() throws IOException, ParseException {

        loginPage
                .login()
                .click_HamburgerMenu();
        leftPanelPage
                .click_cikisYap();
        globalPage
                .click_EvetDialog();

    }

}
