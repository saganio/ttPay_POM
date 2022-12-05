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

public class ParolamiUnuttumTest extends BaseClass {

    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Parolamı Unuttum senaryosu.")
    public void ParolamiUnuttum() throws IOException, ParseException {

        loginPage
                .click_ParolamiUnuttum()
                .sendKeys_ParolamiUnuttumMsisdnTextBox(rastgeleNumaraGir())
                .click_DevamEtButton();
    }

}
