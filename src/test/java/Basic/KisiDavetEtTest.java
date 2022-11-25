package Basic;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static Libraries.TestUtils.testAssertFunctions;
import static Pages.StringConstants.DAVET_ET_TEXT;
import static Pages.StringConstants.STEP_MESSAGE;

/**
 * Created by uguryildiz on 17.11.2022
 */
public class KisiDavetEtTest extends BaseClass {

    @Test(priority = 0)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Kampanyaları görüntüleme testi.")
    public void KisiDavetEt() throws IOException, ParseException {

        loginPage
                .login()
                .click_HamburgerMenu();

        leftPanelPage
                .click_rehberimVeBankaHesaplarim();

        RehberimVeBankaHesaplarimPage
                .click_DavetEt()
                .click_devamEtButonu_dialog();

        testAssertFunctions(DAVET_ET_TEXT, RehberimVeBankaHesaplarimPage.getDavetEtText());


    }
}
