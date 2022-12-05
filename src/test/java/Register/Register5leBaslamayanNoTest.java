package Register;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import static Pages.StringConstants.STEP_MESSAGE;

public class Register5leBaslamayanNoTest extends BaseClass {

    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Sisteme 5 ile başlamayan yeni kullanıcı kaydetme senaryosu.")
    public void Register5ileBaslamayanNo() {

        registerPage
                .click_HesabimYok()
                .click_HesapOlusturmayaTikla()
                .sendKeys_Msisdn(rastgeleNumaraGir_5ileBaslamayan());

    }

}
