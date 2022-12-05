package Login;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static Pages.StringConstants.STEP_MESSAGE;

public class ParolamiUnuttum_yanlisOTP extends BaseClass {

    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Parolamı Unuttum dedikten sonra gelen OTP'yi YANLIŞ girme senaryosu.")
    public void ParolamiUnuttum_yanlisOTP() throws IOException, SQLException {

        loginPage
                .click_ParolamiUnuttum()
                .sendKeys_ParolamiUnuttumMsisdnTextBox(rastgeleNumaraGir())
                .click_DevamEtButton()
                .click_OTPTextBox();
        dbQueries
                .Set_WrongOTPForNewAccount();

        loginPage
                .click_DevamEtButton();

        // TODO: 1.12.2022  
    }
}
