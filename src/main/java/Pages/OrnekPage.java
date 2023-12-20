package Pages;

import Libraries.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import java.io.IOException;

import static Libraries.TestUtils.clearAndfillInFieldWith;

public class OrnekPage extends BaseClass {

    //Buton tanımlamaları
    private final By cepTelefonuGirmeAlani = By.id("tr.com.turktelekom.pokus.dev:id/et_username_password_text");
    private final By sifreGirmeAlani = By.id("tr.com.turktelekom.pokus.dev:id/et_password_text");

    //Constructor
    public OrnekPage (AndroidDriver<MobileElement> driver){
        BaseClass.driver = driver;
    }

    //Methodlar
    public  OrnekPage cepNoGir(String text) {
        clearAndfillInFieldWith(cepTelefonuGirmeAlani, text);
        return this;
    }

    public OrnekPage sifreGir() throws IOException, ParseException {
        clearAndfillInFieldWith(sifreGirmeAlani,getString("pass"));
        return this;
    }



}
