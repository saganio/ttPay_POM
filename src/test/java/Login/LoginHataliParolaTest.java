package Login;

import Libraries.BaseClass;
import Libraries.TestUtils;
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

import static Pages.StringConstants.HATALI_PAROLA_TEXT;

public class LoginHataliParolaTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Yanlış Şifreyi Gir")
    @Description("Kullancı Adı ve Yanlış Şifre ile giriş yapma senaryosu.")
    public void LoginHataliParola() throws IOException, ParseException {

        LoginPage LP = new LoginPage(driver);

            LP
                .setUsername(getString("id"))
                .setPassword(getString("wrongPass"));

            TestUtils
                .testAssertFunctions(HATALI_PAROLA_TEXT, LP.getYanlisParolaText());

            LP
                .click_TekrarDeneButton()
                .login();

    }

}
