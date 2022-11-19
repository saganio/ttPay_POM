package Login;

import Libraries.BaseClass;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class ParolamiUnuttumTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Description("Parolamı Unuttum senaryosu.")
    public void ParolamiUnuttum() throws IOException, ParseException {

        loginPage
                .click_ParolamiUnuttum()
                .sendKeys_ParolamiUnuttumMsisdnTextBox(getString("id"))
                .click_DevamEtButton();
    }

}
