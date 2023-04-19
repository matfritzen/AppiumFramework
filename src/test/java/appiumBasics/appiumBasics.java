package appiumBasics;

import pages.android.ApiDemos.PreferenceDependenciesPage;
import pages.android.ApiDemos.PreferencePage;
import testUtils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class appiumBasics extends AndroidBaseTest {

//    @BeforeMethod
//    public void preSetup(){
//        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
//        driver.startActivity(activity);
//    }

    @Test
    public void WifiSettingName() throws IOException {

        // Selectors available for Android: xpath, id, accessibilityId, classname, androidUIAutomator
        PreferencePage preferencePage = homePage.clickPreferenceOption();

        PreferenceDependenciesPage preferenceDependenciesPage = preferencePage.clickPreferenceDependencies();

        preferenceDependenciesPage.clickWifiCheckbox();
        preferenceDependenciesPage.clickWifiSettings();

        preferenceDependenciesPage.verifyAlertTitle();
        preferenceDependenciesPage.fillWifiName("Matheus WiFi");
    }


}
