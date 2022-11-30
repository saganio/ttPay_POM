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

public class RegisterTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Sisteme yeni kullanıcı kaydetme senaryosu.")
    public void Register() throws IOException, ParseException {

        registerPage
                .click_HesabimYok()
                .click_HesapOlusturmayaTikla()
                .sendKeys_Msisdn(rastgeleNumaraGir())
                .click_devamEtButton()
                .click_OTFField()
                .yeniHesapOTPGir()
                .click_devamEtButtonAfterOTP()
                .set_Sifre()
                .click_DevamEtAfterSifre()
                .set_IsimSoyIsimVeEmail(
                        getString("testAd"),
                        getString("testSoyad"),
                        getString("testEmail"))
                .click_DevamEtAfterAdSoyad()
                .click_CheckBoxes()
                .click_DevamEtAfterCheckBox();
                /*
                .click_devamEtAfterSuccess()
                .click_tanitimiAtla();
*/
    }

}
