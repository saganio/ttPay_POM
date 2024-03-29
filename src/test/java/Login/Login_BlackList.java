package Login;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Pages.StringConstants.BLACKLIST_TEXT;
import static Pages.StringConstants.STEP_MESSAGE;

public class Login_BlackList extends BaseClass {

    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Kara Listede olan kullanıcı ile sisteme giriş senaryosu.")
    public void BlackList() throws IOException, ParseException {

        loginPage
                .login_BlackList();

        globalPage
                .CompareTexts(BLACKLIST_TEXT, loginPage.getBlackListText());
    }
}
