package Basic;

import Jira.JiraPolicy;
import Libraries.BaseClass;
import Libraries.ShellCommandExecutor;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static Libraries.ShellCommandExecutor.executeCommand;
import static Pages.StringConstants.*;

public class IBANKaydetTest extends BaseClass {


    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("IBAN Kaydetme testi.")
    public void IBANKaydet() throws IOException, ParseException, SQLException {

       // dbQueries
        //        .bakiyeKontrol_Basic();

        loginPage
                .login()
                .click_HamburgerMenu();
        leftPanelPage
                .click_rehberimVeBankaHesaplarim();
        RehberimVeBankaHesaplarimPage
                .click_IbanSekmesi()
                .click_plusButton();

        globalPage
                .CompareTexts(IBAN_KAYDETME_TEXT, RehberimVeBankaHesaplarimPage.getErrorText());

        RehberimVeBankaHesaplarimPage
                .click_vazgecButonuDialog();

    }

}
