package Pages;

import Libraries.BaseClass;
import Libraries.DBConnection;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Reporter;

import java.io.IOException;
import java.sql.SQLException;

import static Libraries.TestUtils.*;
import static Pages.DBQueries.SET_SEMIVERIFIED_OTP_SQL;
import static Pages.StringConstants.girisOncesiOTPText;
import static Utils.TestListener.saveTextLog;


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
    private final By yanlisParolaText = By.id("tr.com.turktelekom.pokus.test:id/tv_confirmation_dialog_message");
    private final By tekrarDeneButton = By.id("btn_confirmation_dialog_confirm");
    private final By girisYapButton = By.id("btn_login_register_submith");
    private final By beniHatirla = By.id("cb_username_password");

    //Constructor
    public LoginPage(AndroidDriver<MobileElement> driver) {
        BaseClass.driver = driver;
    }


    //Methods

    @Step("{method} {0}")
    public LoginPage setUsername(String username) {
        driver.findElement(usernameTextBox).clear();
        driver.findElement(usernameTextBox).sendKeys(username);
        return this;
    }

    @Step("{method} {0}")
    public LoginPage setPassword(String password) {
        driver.findElement(passwordTextBox).sendKeys(password);
        return this;
    }

    @Step("{method}")
    public CharSequence getTextOfOTPMessage() {
        saveTextLog(getTextFromElement(loginOTPField));
        return getTextFromElement(loginOTPField);
    }

    @Step("{method}")
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
                Log.info("Giremedim.");
            }
        } else {
            Log.info("Giriş yapıldı.");
        }
        return this;
    }

    @Step("{method}")
    public LoginPage semiVerifiedlogin() throws IOException, ParseException {

        setUsername(getString("semi_Msisdn"));
        setPassword(getString("semi_Pass"));

        boolean otpText = driver.findElements(By.xpath("//*[@text='Farklı bir cihazdan oturum açtığınız için cep telefonu numaranızı doğrulamanız gerekmektedir.']")).size() > 0;

        if (otpText) {
            System.out.println("Giriş yapıldı.");
        } else if (!otpText) {
            try {
                clickElementBy(acceptOTPMessage);
                clickElementBy(clickOTPField);

                String sql = SET_SEMIVERIFIED_OTP_SQL;
                DBConnection dbConn = new DBConnection();

                int num = Integer.parseInt(dbConn.ttpayDev(sql));
                String number = String.valueOf(num);

                for (int ix = 0; ix < 1; ix++) {

                    String text = number;
                    String[] separated = text.split("");

                    for (String word : separated) {
                        if (!word.trim().isEmpty()) {
                        }
                    }

                    int jer = Character.digit(number.charAt(ix), 10);
                    MobileElement testDB = driver.findElementByXPath("//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_otp_textfield_text']");
                    testDB.sendKeys(separated[0]);

                    MobileElement testDB1 = driver.findElementByXPath("(//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_otp_textfield_text'])[2]");
                    testDB1.sendKeys(separated[1]);


                    MobileElement testDB2 = driver.findElementByXPath("(//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_otp_textfield_text'])[3]");
                    testDB2.sendKeys(separated[2]);


                    MobileElement testDB3 = driver.findElementByXPath("(//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_otp_textfield_text'])[4]");
                    testDB3.sendKeys(separated[3]);


                    MobileElement testDB4 = driver.findElementByXPath("(//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_otp_textfield_text'])[5]");
                    testDB4.sendKeys(separated[4]);


                    MobileElement testDB5 = driver.findElementByXPath("(//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_otp_textfield_text'])[6]");
                    testDB5.sendKeys(separated[5]);

                }

                clickElementBy(gonderButonu);
            } catch (NoSuchElementException NSE) {
                Log.info("Giremedim.");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            Log.info("Giriş yapıldı.");
        }
        return this;
    }

    public LoginPage Verifiedlogin() throws IOException, ParseException {

        setUsername(getString("msisdn"));
        setPassword(getString("pass1"));

        if (getTextOfOTPMessage().equals(girisOncesiOTPText)) {
            try {
                clickElementBy(acceptOTPMessage);
                clickElementBy(clickOTPField);

                for (int i = 0; i < 6; i++) {
                    driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_1));
                }
                clickElementBy(gonderButonu);
            } catch (NoSuchElementException NSE) {
                Log.info("Giremedim.");
            }
        } else {
            Log.info("Giriş yapıldı.");
        }
        return this;
    }


    @Step("{method}")
    public LoginPage beniHatirlaloginClass() throws IOException, ParseException {

        if (getTextOfOTPMessage().equals(girisOncesiOTPText)) {
            try {
                clickElementBy(acceptOTPMessage);
                clickElementBy(clickOTPField);

                for (int i = 0; i < 6; i++) {
                    driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_1));
                }
                clickElementBy(gonderButonu);
            } catch (NoSuchElementException NSE) {
                Log.info("Giremedim.");
            }
        } else {
            Log.info("Giriş yapıldı.");
        }
        return this;
    }


    @Step("{method}")
    public LoginPage click_HamburgerMenu() {
        clickElementBy(hamburgerMenu);
        Reporter.log("hamburger menü tıklandı");
        return this;
    }

    @Step("{method}")
    public LoginPage click_ParolamiUnuttum() {
        clickElementBy(parolamiUnuttum);
        return this;
    }

    @Step("{method} {0}")
    public LoginPage sendKeys_ParolamiUnuttumMsisdnTextBox(String text) {
        clearAndfillInFieldWith(parolamiUnuttum_msisdnGir, text);
        Log.info("Value: " + text);
        return this;
    }

    @Step("{method}")
    public LoginPage click_DevamEtButton() {
        clickElementBy(parolamiUnuttum_devamEtButton);
        return this;
    }

    @Step("{method}")
    public String getYanlisParolaText() {
        saveTextLog(getTextFromElement(yanlisParolaText));
        return driver.findElement(yanlisParolaText).getText();
    }

    @Step("{method}")
    public LoginPage click_TekrarDeneButton() {
        clickElementBy(tekrarDeneButton);
        return this;
    }

    @Step("{method}")
    public LoginPage click_girisYapButton() {
        clickElementBy(girisYapButton);
        return this;
    }

    @Step("{method}")
    public LoginPage click_beniHatirla() {
        clickElementBy(beniHatirla);
        return this;
    }

    @Step("{method} {0}")
    public LoginPage clickUsernameTextBox() {
        clickElementBy(usernameTextBox);
        return this;
    }


}
