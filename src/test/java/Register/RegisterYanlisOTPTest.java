package Register;

import Libraries.BaseClass;
import Pages.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterYanlisOTPTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Hesabim Yok 2- Yeni Hesap Oluştur")
    @Description("Sisteme Yanlış OTP ile yeni kullanıcı kaydetme senaryosu.")
    public void RegisterYanlisOTP() throws IOException, ParseException {

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage
                .click_HesabimYok()
                .click_HesapOlusturmayaTikla()
                .sendKeys_Msisdn(rastgeleNumaraGir())
                .click_devamEtButton()
                .click_OTFField()
                .click_devamEtButtonAfterOTP();
        // TODO: 17.11.2022  

    }

}
