package SemiVerified;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Libraries.TestUtils.testAssertFunctions;
import static Pages.StringConstants.IBAN_KAYDETME_TEXT;
import static Pages.StringConstants.STEP_MESSAGE;

public class IBANKaydetTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("IBAN Kaydetme testi.")
    public void IBANKaydet() throws IOException, ParseException {


        loginPage
                .semiVerifiedlogin()
                .click_HamburgerMenu();
        leftPanelPage
                .click_rehberimVeBankaHesaplarim();
        RehberimVeBankaHesaplarimPage
                .click_IbanSekmesi()
                .click_plusButton();

        testAssertFunctions(IBAN_KAYDETME_TEXT, RehberimVeBankaHesaplarimPage.getErrorText());

        RehberimVeBankaHesaplarimPage
                .click_vazgecButonuDialog();
    }

}
