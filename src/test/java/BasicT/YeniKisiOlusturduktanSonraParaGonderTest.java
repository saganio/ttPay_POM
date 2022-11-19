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
import static Pages.StringConstants.hataMesaji_PARAGONDER;
import static Pages.StringConstants.yeniKayitNo;

public class YeniKisiOlusturduktanSonraParaGonderTest extends BaseClass {


    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step("1-Kullanıcı adını gir, 2-Şifreyi Gir, 3- Para Gönder")
    @Description("Para Gönderme senaryosu")
    public void YeniKisiOlusturVeParaGonder() throws IOException, ParseException {

        loginPage
                .login()
                .click_HamburgerMenu();

        leftPanelPage
                .click_rehberimVeBankaHesaplarim();

        RehberimVeBankaHesaplarimPage
                .click_plusButton()
                .click_yeniKisiEkle()
                .sendkey_grupAdiGirTextBox(yeniKayitNo)
                .click_rehbereKaydet()
                .click_saveButton()
                .click_NewRecord()
                .click_paraGonderButonu();

        testAssertFunctions(hataMesaji_PARAGONDER, RehberimVeBankaHesaplarimPage.getErrorText());

        RehberimVeBankaHesaplarimPage
                .click_vazgecButonuDialog();
    }


}
