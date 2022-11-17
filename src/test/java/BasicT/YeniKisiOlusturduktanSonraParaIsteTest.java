package BasicT;

import Libraries.BaseClass;
import Pages.LeftPanelPage;
import Pages.LoginPage;
import Pages.RehberimVeBankHspPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Libraries.TestUtils.testAssertFunctions;
import static Pages.StringConstants.*;

public class YeniKisiOlusturduktanSonraParaIsteTest extends BaseClass {



    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Şifreyi Gir, 3- Para Gönder")
    @Description("Para Gönderme senaryosu")
    public void YeniKisiOlusturVeParaGonder() throws IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        RehberimVeBankHspPage RVBH = new RehberimVeBankHspPage(driver);
        LeftPanelPage leftPanelPage = new LeftPanelPage(driver);

        loginPage
                .login()
                .click_HamburgerMenu();

        leftPanelPage
                .click_rehberimVeBankaHesaplarim();

        RVBH
                .click_plusButton()
                .click_yeniKisiEkle()
                .sendkey_grupAdiGirTextBox(yeniKayitNo)
                .click_rehbereKaydet()
                .click_saveButton()
                .click_NewRecord()
                .click_paraIsteButonu();

        testAssertFunctions(hataMesaji_PARAISTE,RVBH.getErrorText());

        RVBH
                .click_vazgecButonuDialog();
    }


}
