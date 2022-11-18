package BasicT;

import Libraries.BaseClass;
import Pages.LeftPanelPage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;


public class KisiDetayIncelemeTest extends BaseClass {


    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Şifreyi Gir, 3- Kişi Detay İncele")
    @Description("Kişi Detay İnceleme")

    public void KisiDetayInceleme() throws IOException, ParseException, InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        LeftPanelPage leftPanelPage = new LeftPanelPage(driver);

        loginPage
                .login()
                .click_HamburgerMenu();

        leftPanelPage
                .click_Profil().wait2Sec().goBack()
                .click_hesabiniOnayla().wait2Sec().goBack()
                .click_rehberimVeBankaHesaplarim().wait2Sec().goBack()
                .click_pokusKartEkleOlustur().wait2Sec().goBack()
                .click_formVeSozlesmeler().wait2Sec().goBack()
                .click_sikcaSorulanSorular().wait2Sec().goBack()
                .click_musteriHizmetleri().wait2Sec().clickIptal()
                .click_cikisYap();

    }

}
