package appiumBasics;

import pages.android.ApiDemos.PreferenceDependenciesPage;
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
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();

        PreferenceDependenciesPage preferenceDependenciesPage = new PreferenceDependenciesPage(driver);

        preferenceDependenciesPage.clickWifiCheckbox();
        preferenceDependenciesPage.clickWifiSettings();

        preferenceDependenciesPage.verifyAlertTitle();
        preferenceDependenciesPage.fillWifiName("Matheus WiFi");
    }


}
