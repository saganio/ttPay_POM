package Basic;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.SQLException;
import static Pages.StringConstants.SEMI_IBAN_KAYDETME_TEXT;
import static Pages.StringConstants.STEP_MESSAGE;

public class IBANKaydetTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("IBAN Kaydetme testi.")
    public void IBANKaydet() throws IOException, ParseException, SQLException {

        dbQueries
                .bakiyeKontrol_Basic();

        loginPage
                .login()
                .click_HamburgerMenu();
        leftPanelPage
                .click_rehberimVeBankaHesaplarim();
        RehberimVeBankaHesaplarimPage
                .click_IbanSekmesi()
                .click_plusButton()
                .IbanBilgileriniDoldur_Semi();

        globalPage
                .CompareTexts(SEMI_IBAN_KAYDETME_TEXT, RehberimVeBankaHesaplarimPage.getErrorText_Semi());

        RehberimVeBankaHesaplarimPage
                .click_vazgecButonuDialog();
    }

}
