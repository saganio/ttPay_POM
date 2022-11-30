package Register;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.IOException;
import static Pages.StringConstants.STEP_MESSAGE;
import static Pages.StringConstants.YANLIS_OTP_TEXT;

public class RegisterYanlisOTPTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Sisteme Yanlış OTP ile yeni kullanıcı kaydetme senaryosu.")
    public void RegisterYanlisOTP() throws IOException, ParseException {
        registerPage
                .click_HesabimYok()
                .click_HesapOlusturmayaTikla()
                .sendKeys_Msisdn(rastgeleNumaraGir())
                .click_devamEtButton()
                .click_OTFField()
                .yanlisOTPGir()
                .click_devamEtButtonAfterOTP();

        globalPage
                .CompareTexts(YANLIS_OTP_TEXT,registerPage.get_OTPText());
    }

}
