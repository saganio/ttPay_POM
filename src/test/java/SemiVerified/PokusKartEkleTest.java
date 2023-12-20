package SemiVerified;

import Libraries.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static Libraries.TestUtils.clickElementBy;
import static Pages.StringConstants.STEP_MESSAGE;

public class PokusKartEkleTest extends BaseClass {

    private final By sec = By.xpath("//android.widget.TextView[@text='Pokus Kartım 2']");
    private final By sec2 = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/androidx.appcompat.widget.LinearLayoutCompat[2]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ImageButton[2]");

    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Step(STEP_MESSAGE)
    @Description("Pokus Kart Ekleme testi.")
    public void PokusKartEkle() throws IOException, ParseException {

        loginPage
                .semiVerifiedlogin();
        homePage
                .click_Kartlarim();
                clickElementBy(sec);
                clickElementBy(sec2);
    /*   kartlarimPage
                .click_pokusKartEkleOlustur()
                .click_pokusKartiniEkle();
*/
    }

}
