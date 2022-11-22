package Login;

import Libraries.BaseClass;
import Libraries.PostmanTopUp;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.SQLException;
import static Pages.DBQueries.bakiyeKontrol_basic;

public class Login_Basic_TopUp extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Description("Para Yükleme ve Kontrol Testi")
    public void Basic_TopUp() throws IOException, ParseException, InterruptedException, SQLException {

        dbQueries.bakiyeKontrol_verified();

        PostmanTopUp
                .getToken_MakeTopUp(getString("id"),"20");

        loginPage
                .login();

        globalPage
                .check_Notifications().wait2Sec().goBack()
                .click_Islemlerim()
                .click_BekleyenIslemlerim();

    }


}
