package appiumBasics;

import org.testng.annotations.BeforeMethod;
import pages.android.ApiDemos.PreferenceDependenciesPage;
import testUtils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MiscellaneousAppiumActions extends AndroidBaseTest {

    @BeforeMethod
    public void preSetup(){
        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        driver.startActivity(activity);

    }

    @Test
    public void Miscellanous() throws IOException {

        //adb shell dumpsys window | grep -E 'mCurrentFocus'    - This command is for MAC
        //adb shell dumpsys window | find -E 'mCurrentFocus'    - This command is for Windows

        // Selectors available for Android: xpath, id, accessibilityId, classname, androidUIAutomator
        PreferenceDependenciesPage preferenceDependenciesPage = new PreferenceDependenciesPage(driver);
        preferenceDependenciesPage.clickWifiCheckbox();
        deviceRotation();


        preferenceDependenciesPage.clickWifiSettings();

        preferenceDependenciesPage.verifyAlertTitle();

        driver.setClipboardText("Matheus Wifi");

        preferenceDependenciesPage.fillWifiName(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

    }


}
