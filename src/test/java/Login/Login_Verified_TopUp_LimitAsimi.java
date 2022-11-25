package Login;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Pages.StringConstants.STEP_MESSAGE;

public class Login_Verified_TopUp_LimitAsimi extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Verified Hesaba para yükle ve kontrol et.")
    public void Verified_TopUp_LimitAsimi() throws IOException, ParseException {

        loginPage
                .login();

        // TODO: 17.11.2022

    }

}
