package Libraries;

import Pages.HomePage;
import Pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

    public AndroidDriver driver;
    public HomePage homePage;
    public LoginPage loginPagex;

    public AndroidDriver getDriver() {
        return driver;
    }


}