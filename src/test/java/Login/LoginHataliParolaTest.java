package Login;

import Libraries.BaseClass;
import Libraries.TestUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Pages.StringConstants.HATALI_PAROLA_TEXT;
import static Pages.StringConstants.STEP_MESSAGE;

public class LoginHataliParolaTest extends BaseClass {

    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Kullancı Adı ve Yanlış Şifre ile giriş yapma senaryosu.")
    public void LoginHataliParola() throws IOException, ParseException {

        loginPage
                .setUsername(getString("id"))
                .setPassword(getString("wrongPass"));

        globalPage
                .CompareTexts(HATALI_PAROLA_TEXT, loginPage.getYanlisParolaText());

        loginPage
                .click_TekrarDeneButton()
                .login()
                .click_girisYapButton();

    }

}
