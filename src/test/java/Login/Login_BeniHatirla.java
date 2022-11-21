package Login;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.IOException;

public class Login_BeniHatirla extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Hesabim Yok 2- Yeni Hesap Oluştur")
    @Description("Sisteme yebi kullanıcı kaydetme senaryosu.")
    public void Login_Basic_TopUp() throws IOException, ParseException {

       loginPage
               .login();


        // TODO: 17.11.2022

    }
}
