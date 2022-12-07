package Login;

import Jira.JiraPolicy;
import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Pages.StringConstants.STEP_MESSAGE;

public class LoginLogOutTest extends BaseClass {

    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
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
