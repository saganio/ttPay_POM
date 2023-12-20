package Example;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.IOException;
import static Pages.StringConstants.STEP_MESSAGE;

public class Odevb {
    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Sisteme yeni kullanıcı kaydetme senaryosu.")
    public void Register() throws IOException, ParseException {


    }



}
