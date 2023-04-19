package pages.android.ApiDemos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.android.BasePageAndroid;

import java.util.List;

public class PreferencePage extends BasePageAndroid {

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='3. Preference dependencies']")
    private WebElement preferenceDependencies;

    public PreferencePage(AndroidDriver driver){super(driver);}


    public PreferenceDependenciesPage clickPreferenceDependencies(){
        preferenceDependencies.click();
        return new PreferenceDependenciesPage(driver);
    }


}
