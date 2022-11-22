package Login;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.IOException;

public class Login_BeniHatirla extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Description("Beni hatırla butonu testi.")
    public void BeniHatirla() throws IOException, ParseException {

       loginPage
               .setUsername(getString("id"))
               .clickUsernameTextBox()
               .click_beniHatirla()
               .setPassword(getString("pass"))
               .beniHatirlaloginClass()
               .click_HamburgerMenu();

       leftPanelPage
               .click_cikisYap();

       globalPage
               .click_EvetDialog();

       loginPage
               .clickUsernameTextBox()
               .click_beniHatirla();




    }
}
