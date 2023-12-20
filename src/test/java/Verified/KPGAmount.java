package Verified;

import Libraries.BaseClass;
import Utils.Log;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import static Libraries.TestUtils.getTextFromElement;
import static Pages.GlobalPage.getNames;
import static Pages.StringConstants.STEP_MESSAGE;

public class KPGAmount extends BaseClass {


    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Kayıtlı Kişiye Para Gönderme senaryosu")
    public void KayitliKisiyeParaGonder() throws IOException, ParseException, InterruptedException, SQLException {

        loginPage
                .Verifiedlogin();

        Thread.sleep(10000);

        globalPage
                .firstB();
        globalPage
                .lastB();
        globalPage
                .getToplam();




    }

}