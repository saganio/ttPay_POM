package Pages;

import Libraries.BaseClass;
import Utils.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static Libraries.TestUtils.clickElementBy;
import static Pages.GlobalPage.getNames;

public class CampaignsPage extends BaseClass {

    private final By switchButton = By.id("tglBtnActiveBonuses");
    private final By clickCampaign = By.id("bonusItemRoot");


    //Constructor
    public CampaignsPage(AndroidDriver<MobileElement> driver) {
        BaseClass.driver = driver;
    }

    //Methods

    @Step("{method}")
    public CampaignsPage clickSwitchButton() {
        clickElementBy(switchButton);
        Log.info(getNames());
        return this;
    }

    @Step("{method}")
    public CampaignsPage clickCampaign() {
        clickElementBy(clickCampaign);
        Log.info(getNames());
        return this;
    }


}
