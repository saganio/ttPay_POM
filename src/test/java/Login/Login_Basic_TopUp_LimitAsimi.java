package Login;

import Libraries.BaseClass;
import Libraries.PostmanTopUp;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Pages.StringConstants.STEP_MESSAGE;

public class Login_Basic_TopUp_LimitAsimi extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Para Yükleme ve Kontrol Testi")
    public void Basic_TopUp_LimitAsimi() throws IOException, ParseException {

        PostmanTopUp
                .getToken_MakeTopUp(getString("id"), "12300");

        loginPage
                .login();

        globalPage
                .check_Notifications().goBack()
                .click_Islemlerim()
                .click_BekleyenIslemlerim();
    }


}
