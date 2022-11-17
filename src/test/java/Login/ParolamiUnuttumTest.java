package Login;

import Libraries.BaseClass;
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

public class ParolamiUnuttumTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Login, 2-Parolamı Unuttum")
    @Description("Parolamı Unuttum senaryosu.")
    public void ParolamiUnuttum() throws IOException, ParseException {

        LoginPage LP = new LoginPage(driver);

        LP
                .click_ParolamiUnuttum()
                .sendKeys_ParolamiUnuttumMsisdnTextBox(getString("id"))
                .click_DevamEtButton();
    }

}
