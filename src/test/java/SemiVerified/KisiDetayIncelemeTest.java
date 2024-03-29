package SemiVerified;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Pages.StringConstants.STEP_MESSAGE;


public class KisiDetayIncelemeTest extends BaseClass {


    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Kişi Detay İnceleme")
    public void KisiDetayInceleme() throws IOException, ParseException, InterruptedException {

        loginPage
                .semiVerifiedlogin()
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
