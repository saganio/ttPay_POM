package Pages;

import Libraries.DBConnection;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import static Libraries.BaseClass.*;
import static Pages.GlobalPage.getNames;

/**
 * Created by uguryildiz on 20.11.2022
 */
public class DBQueries {

    public static final String registerNo = rastgeleNumaraGir();
    public static final String GET_SEMI_AMOUNT_SQL = "SELECT TOP (1) c.ACCOUNT_BALANCE FROM [TTPAY_TEST].[dbo].[ACC_USER] a, [TTPAY_TEST].[dbo].[EMN_MEMBER] b, [TTPAY_TEST].[dbo].[EMN_MEMBER_DETAIL_LOG] c WHERE a.USER_ID = b.USER_ID AND b.MEMBER_CODE = c.MEMBER_CODE AND a.ACTIVE_MSISDN = '905993152161' ORDER BY c.CREATED_DATE DESC";
    public static final String SET_SEMIVERIFIED_OTP_SQL;
    public static final String SET_BASIC_OTP_SQL;
    public static final String SET_VERIFIED_OTP_SQL;
    public static final String Set_OTPForNewAccount = "SELECT top (1) [OTP] FROM [TTPAY_TEST].[dbo].[OTP_TRANSACTION] where MSISDN='90" + registerNo + "' ORDER BY CREATION_DATE DESC";
    private static final String GET_OTP_SQL = "select TOP(1) TEXT from [TTPAY_TEST].[dbo].[SMS_TRANSACTION] ORDER BY CREATION_DATE DESC";
    private static final String GET_PN_SQL = "SELECT TOP(1) BODY FROM [TTPAY_TEST].[dbo].[PN_TRANSACTION] order by LOG_DATE desc";
    private static final String GET_TOTAL_TAX_AMOUNT_SEMI = "SELECT TOP(1) TOTAL_TAX_AMOUNT from PAY_BILL where RECEIVER_EMAIL_ADDRESS in (select ACTIVE_MAIL from ACC_USER where ACTIVE_MSISDN='905993152161')  order by CREATED_DATE desc";
    private static final String GET_TOTAL_TAX_AMOUNT_VERIFIED = "select top(1) TOTAL_TAX_AMOUNT from PAY_BILL where RECEIVER_EMAIL_ADDRESS in (select ACTIVE_MAIL from [TTPAY_TEST].[dbo].[ACC_USER] where ACTIVE_MSISDN='905997654321')  order by CREATED_DATE desc";
    private static final String GET_BASIC_AMOUNT_SQL = "SELECT TOP (1) c.ACCOUNT_BALANCE FROM [TTPAY_TEST].[dbo].[ACC_USER] a, [TTPAY_TEST].[dbo].[EMN_MEMBER] b, [TTPAY_TEST].[dbo].[EMN_MEMBER_DETAIL_LOG] c WHERE a.USER_ID = b.USER_ID AND b.MEMBER_CODE = c.MEMBER_CODE AND a.ACTIVE_MSISDN = '905550000012' ORDER BY c.CREATED_DATE DESC";
    private static final String GET_VERIFIED_AMOUNT_SQL = "SELECT TOP (1) c.ACCOUNT_BALANCE FROM [TTPAY_TEST].[dbo].[ACC_USER] a, [TTPAY_TEST].[dbo].[EMN_MEMBER] b, [TTPAY_TEST].[dbo].[EMN_MEMBER_DETAIL_LOG] c WHERE a.USER_ID = b.USER_ID AND b.MEMBER_CODE = c.MEMBER_CODE AND a.ACTIVE_MSISDN = '905997654321' ORDER BY c.CREATED_DATE DESC";


    static {
        try {
            SET_VERIFIED_OTP_SQL = "SELECT top (1) [OTP] FROM [TTPAY_TEST].[dbo].[OTP_TRANSACTION] where MSISDN='90" + getString("msisdn") + "' ORDER BY CREATION_DATE DESC";
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            SET_SEMIVERIFIED_OTP_SQL = "SELECT top (1) [OTP] FROM [TTPAY_TEST].[dbo].[OTP_TRANSACTION] where MSISDN='90" + getString("semi_Msisdn") + "' ORDER BY CREATION_DATE DESC";
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            SET_BASIC_OTP_SQL = "SELECT top (1) [OTP] FROM [TTPAY_TEST].[dbo].[OTP_TRANSACTION] where MSISDN='90" + getString("id") + "' ORDER BY CREATION_DATE DESC";
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public DBQueries(AndroidDriver<MobileElement> driver) {
    }

    @Attachment(value = "{value}", type = "text/plain")
    public static String addStringAttachment(String SQL, String value) throws SQLException, FileNotFoundException {
        DBConnection dbConn = new DBConnection();
        return dbConn.ttpayDev(SQL);
    }

    @Step("{method}")
    public DBQueries bakiyeKontrol_semi() throws SQLException, IOException {
        String sql = GET_SEMI_AMOUNT_SQL;
        DBConnection dbConn = new DBConnection();
        dbConn.ttpayDev2(sql);
        addStringAttachment(GET_SEMI_AMOUNT_SQL, "SemiVerified Bakiye: ");
        return this;
    }

    @Step("{method}")
    public DBQueries bakiyeKontrol_Basic() throws SQLException, IOException {
        String sql = GET_BASIC_AMOUNT_SQL;
        DBConnection dbConn = new DBConnection();
        dbConn.ttpayDev2(sql);
        addStringAttachment(GET_BASIC_AMOUNT_SQL, "Basic Bakiye: ");
        return this;
    }

    @Step("{method}")
    public DBQueries bakiyeKontrol_Verified() throws SQLException, IOException {
        String sql = GET_VERIFIED_AMOUNT_SQL;
        DBConnection dbConn = new DBConnection();
        dbConn.ttpayDev2(sql);
        addStringAttachment(GET_VERIFIED_AMOUNT_SQL, "Verified Bakiye: ");
        return this;
    }

    @Step("{method}")
    public DBQueries otp_SMS_transaction_log() throws SQLException, FileNotFoundException {
        String sql = GET_OTP_SQL;
        DBConnection dbConn = new DBConnection();
        dbConn.ttpayDev2(sql);
        addStringAttachment(GET_OTP_SQL, "SMS Log: ");
        return this;
    }

    @Step("{method}")
    public DBQueries push_Notification_log() throws SQLException, FileNotFoundException {

        String sql = GET_PN_SQL;
        DBConnection dbConn = new DBConnection();
        dbConn.ttpayDev2(sql);
        addStringAttachment(GET_PN_SQL, "Push Notification Log: ");
        return this;
    }

    @Step("{method}")
    public DBQueries total_Tax_Amount_verified() throws SQLException, FileNotFoundException {
        String sql = GET_TOTAL_TAX_AMOUNT_VERIFIED;
        DBConnection dbConn = new DBConnection();
        dbConn.ttpayDev2(sql);
        addStringAttachment(GET_TOTAL_TAX_AMOUNT_VERIFIED, "Toplam Kesinti Miktarı - Verified: ");
        return this;
    }

    @Step("{method}")
    public DBQueries total_Tax_Amount_semi() throws SQLException, FileNotFoundException {
        String sql = GET_TOTAL_TAX_AMOUNT_SEMI;
        DBConnection dbConn = new DBConnection();
        dbConn.ttpayDev2(sql);
        addStringAttachment(GET_TOTAL_TAX_AMOUNT_SEMI, "Toplam Kesinti Miktarı - SemiVerified: ");
        return this;
    }

    @Step("{method}")
    public DBQueries Set_OTPForNewAccount() throws SQLException, FileNotFoundException {

        String sql = "SELECT top(1) [OTP] FROM [TTPAY_TEST].[dbo].[OTP_TRANSACTION] ORDER BY CREATION_DATE DESC";
        DBConnection dbConn = new DBConnection();

        int num = Integer.parseInt(dbConn.ttpayDev(sql));
        String number = String.valueOf(num);

        for (int i = 0; i < 1; i++) {
            try {
                String text = number;
                String[] separated = text.split("");

                for (String word : separated) {
                    if (!word.trim().isEmpty()) {
                    }
                }

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
            } catch (NumberFormatException e) {
                System.out.println("not a number");
            }
        }

        addStringAttachment(Set_OTPForNewAccount, "Yeni Hesap için Girilen OTP: ");
        return this;
    }

    @Step("{method}")
    public DBQueries Set_WrongOTPForNewAccount() throws SQLException, FileNotFoundException {

        for (int i = 0; i < 6; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_7));
        }
        Log.info(getNames());
        return this;
    }


    @Step("{method}")
    public String Set_OTP_Verified() throws SQLException, FileNotFoundException {
        String sql = SET_VERIFIED_OTP_SQL;
        DBConnection dbConn = new DBConnection();
        dbConn.ttpayDev2(sql);
        addStringAttachment(SET_VERIFIED_OTP_SQL,"OTP - Verified: ");
        return dbConn.ttpayDev2(sql);
    }

    @Step("{method}")
    public static String Set_OTP_Basic() throws SQLException, FileNotFoundException {
        String sql = SET_BASIC_OTP_SQL;
        DBConnection dbConn = new DBConnection();
        dbConn.ttpayDev2(sql);
        addStringAttachment(SET_BASIC_OTP_SQL,"OTP - Basic: ");
        return dbConn.ttpayDev2(sql);
    }

    @Step("{method}")
    public String Set_OTP_SemiVerified() throws SQLException, FileNotFoundException {
        String sql = SET_SEMIVERIFIED_OTP_SQL;
        DBConnection dbConn = new DBConnection();
        dbConn.ttpayDev2(sql);
        addStringAttachment(SET_SEMIVERIFIED_OTP_SQL,"OTP - SemiVerified: ");
        return dbConn.ttpayDev2(sql);
    }


}
