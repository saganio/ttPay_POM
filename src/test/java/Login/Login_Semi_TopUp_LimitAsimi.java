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

public class Login_Semi_TopUp_LimitAsimi extends BaseClass {


    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Semi Hesaba para yükle ve kontrol et.")
    public void Semi_TopUp() throws IOException, ParseException, InterruptedException {

        PostmanTopUp
                .getToken_MakeTopUp(getString("semi_Msisdn"), "15220");

        loginPage
                .semiVerifiedlogin();

        globalPage
                .check_Notifications().wait2Sec().goBack()
                .click_Islemlerim()
                .click_BekleyenIslemlerim();

    }

}
