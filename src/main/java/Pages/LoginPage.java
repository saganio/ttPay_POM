package Pages;

import Libraries.BaseClass;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.io.IOException;

import static Libraries.TestUtils.*;
import static Pages.StringConstants.girisOncesiOTPText;


public class LoginPage extends BaseClass {

    private final By usernameTextBox = By.id("tr.com.turktelekom.pokus.test:id/et_username_password_text");
    private final By passwordTextBox = By.id("tr.com.turktelekom.pokus.test:id/et_password_text");
    private final By loginOTPField = By.id("tv_information_dialog_message");
    private final By acceptOTPMessage = By.id("btn_information_dialog_confirm");
    private final By clickOTPField = By.xpath("//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_otp_textfield_text']");
    private final By gonderButonu = By.xpath("//*[@text='GÖNDER']");
    private final By hamburgerMenu = By.id("ibBackButton");
    private final By parolamiUnuttum = By.id("btn_login_activity_forgot_password");
    private final By parolamiUnuttum_msisdnGir = By.id("et_smart_textfield_text");
    private final By parolamiUnuttum_devamEtButton = By.id("abtn_forgot_password_identity_continue");

    //Constructor
    public LoginPage(AndroidDriver<MobileElement> driver) {
        BaseClass.driver = driver;
    }

    //Methods
    public LoginPage setUsername(String username) {
        driver.findElement(usernameTextBox).clear();
        driver.findElement(usernameTextBox).sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        driver.findElement(passwordTextBox).sendKeys(password);
        return this;
    }

    public CharSequence getTextOfOTPMessage() {
        return getTextFromElement(loginOTPField);
    }

    public LoginPage login() throws IOException, ParseException {

        setUsername(getString("id"));
        setPassword(getString("pass"));

        if (getTextOfOTPMessage().equals(girisOncesiOTPText)) {
            try {
                clickElementBy(acceptOTPMessage);
                clickElementBy(clickOTPField);

                for (int i = 0; i < 6; i++) {
                    driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_1));
                }
                clickElementBy(gonderButonu);
            } catch (NoSuchElementException NSE) {
                Log.error("Giremedim.");
            }
        } else {
            Log.info("Giriş yapıldı.");
        }
        return this;
    }

    public LoginPage click_HamburgerMenu() {
        clickElementBy(hamburgerMenu);
        return this;
    }

    public LoginPage click_ParolamiUnuttum() {
        clickElementBy(parolamiUnuttum);
        return this;
    }

    public LoginPage sendKeys_ParolamiUnuttumMsisdnTextBox(String text){
        clearAndfillInFieldWith(parolamiUnuttum_msisdnGir,text);
        Log.info("I clicked: "+this.getClass().getSimpleName());
        Log.info("Girilen değer: " + text );
        return this;
    }

    public LoginPage click_DevamEtButton() {
        clickElementBy(parolamiUnuttum_devamEtButton);
        return this;
    }
}
