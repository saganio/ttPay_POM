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

public class Register5leBaslamayanNoTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Hesabim Yok 2- 5'le başlamayan numara gir.")
    @Description("Sisteme 5 ile başlayan yeni kullanıcı kaydetme senaryosu.")
    public void Register5ileBaslamayanNo() throws IOException, ParseException {

        RegisterPage registerPage = new RegisterPage(driver);
        
        registerPage
                .click_HesabimYok()
                .click_HesapOlusturmayaTikla()
                .sendKeys_Msisdn(rastgeleNumaraGir_5ileBaslamayan());

    }

}