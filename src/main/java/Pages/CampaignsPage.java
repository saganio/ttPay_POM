package Pages;

import Libraries.BaseClass;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static Libraries.TestUtils.clickElementBy;

public class CampaignsPage extends BaseClass {

    private final By switchButton = By.id("tglBtnActiveBonuses");
    private final By clickCampaign = By.id("bonusItemRoot");


    //Constructor
    public CampaignsPage(AndroidDriver<MobileElement> driver) {
        BaseClass.driver = driver;
    }

    //Methods
    public CampaignsPage clickSwitchButton() {
        clickElementBy(switchButton);
        Log.info("I clicked"+ getClass());
        return this;

    }

    public CampaignsPage clickCampaign() {
        clickElementBy(clickCampaign);
        return this;
    }


}
