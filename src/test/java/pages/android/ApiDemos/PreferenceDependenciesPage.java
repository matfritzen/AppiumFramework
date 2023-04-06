package pages.android.ApiDemos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.android.BasePageAndroid;

import java.util.List;

public class PreferenceDependenciesPage extends BasePageAndroid {

    @AndroidFindBy(id = "android:id/checkbox")
    private WebElement wifiCheckbox;

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
    private WebElement wifiSettings;

    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement alertTitleName;

    @AndroidFindBy(id = "android:id/edit")
    private WebElement wifiTextBox;
    @AndroidFindBy(className = "android.widget.Button")
    private List<WebElement> OkButton;

    public PreferenceDependenciesPage(AndroidDriver driver){super(driver);}


    public void clickWifiCheckbox(){
        wifiCheckbox.click();
    }

    public void clickWifiSettings(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]"))));
        wifiSettings.click();
    }

    public void verifyAlertTitle(){
        String alertTitle = alertTitleName.getText();
        Assert.assertEquals(alertTitle, "WiFi settings");
    }

    public void fillWifiName(String wifiName){
        wifiTextBox.sendKeys(wifiName);
        OkButton.get(1).click();
    }


}
