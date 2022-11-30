package Pages;

import Libraries.BaseClass;
import Libraries.DBConnection;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.io.IOException;
import java.sql.SQLException;

import static Libraries.TestUtils.*;
import static Pages.DBQueries.*;
import static Pages.GlobalPage.getNames;
import static Pages.StringConstants.OTP_LOG_MESSAGE;
import static Utils.TestListener.saveTextLog;

public class ProfilPage extends BaseClass {


    private final By adresAlani = By.id("txtAddress");
    private final By eMailAlani = By.id("txtMail");
    private final By ilSecDialog = By.id("tvCity");
    private final By ilceSecDialog = By.id("tvProvince");
    private final By acikAdresTextBox = By.id("et_smart_textfield_text");
    private final By guncelleVetamamButton = By.id("apbRequestCard");
    private final By ilSecAdana = By.xpath("//android.widget.TextView[@text='Adana']");
    private final By ilSecAladag = By.xpath("//android.widget.TextView[@text='Aladağ']");
    private final By secButonu = By.id("abDone");
    private final By geriGit = By.id("ibBackButton");
    private final By clickOTPField = By.xpath("//*[@resource-id='tr.com.turktelekom.pokus.test:id/et_otp_textfield_text']");
    private final By gonderButonu = By.xpath("//*[@text='GÖNDER']");
    private final By onayKoduText = By.id("tv_otp_title");

    //Constructor
    public ProfilPage(AndroidDriver<MobileElement> driver) {
        BaseClass.driver = driver;
    }

    //Methods
    @Step("{method}")
    public ProfilPage click_adresDuzenleButton() {
        swipeToElement("Adres");
        clickElementBy(adresAlani);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public ProfilPage click_emailDuzenleButton() {
        swipeToElement("E-posta");
        clickElementBy(eMailAlani);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public ProfilPage click_ilSecDialog() {
        clickElementBy(ilSecDialog);
        Log.info(getNames());
        return this;

    }

    @Step("{method}")
    public ProfilPage click_Adana() {
        clickElementBy(ilSecAdana);
        Log.info(getNames());
        return this;

    }

    @Step("{method}")
    public ProfilPage click_ilceSecDialog() {
        clickElementBy(ilceSecDialog);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public ProfilPage click_Aladag() {
        clickElementBy(ilSecAladag);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public ProfilPage click_secButton() {
        clickElementBy(secButonu);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public ProfilPage sendkeys_acikAdresTextBox() throws IOException, ParseException {
        clearAndfillInFieldWith(acikAdresTextBox, getString("KKNo"));
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public ProfilPage click_tamamveGuncelleButton() {
        clickElementBy(guncelleVetamamButton);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public ProfilPage click_gerigitButton() {
        clickElementBy(geriGit);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public ProfilPage setOTP_Verified() {

        boolean OTPMessageExists = driver.findElements(onayKoduText).size() != 0;

        if (OTPMessageExists) {
            try {
                clickElementBy(clickOTPField);

                String sql = SET_VERIFIED_OTP_SQL;
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
                Log.info(OTP_LOG_MESSAGE);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            Log.info(OTP_LOG_MESSAGE);
        }
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public ProfilPage setOTP_SemiVerified() {

        boolean OTPMessageExists = driver.findElements(onayKoduText).size() != 0;

        if (OTPMessageExists) {
            try {
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
                Log.info(OTP_LOG_MESSAGE);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            Log.info(OTP_LOG_MESSAGE);
        }
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public ProfilPage setOTP_Basic() {

        boolean OTPMessageExists = driver.findElements(onayKoduText).size() != 0;

        if (OTPMessageExists) {
            try {
                clickElementBy(clickOTPField);

                String sql = SET_BASIC_OTP_SQL;
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
                Log.info(OTP_LOG_MESSAGE);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            Log.info(OTP_LOG_MESSAGE);
        }
        Log.info(getNames());
        return this;
    }


    public CharSequence getTextOfOTPMessage() {
        Log.info(getNames());
        return getTextFromElement(onayKoduText);
    }

}
