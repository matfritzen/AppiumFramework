package pages.ios.UIKitCatalogue;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.ios.BasePageIOS;

public class HomePage extends BasePageIOS {

    public HomePage(IOSDriver driver){
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "Alert Views")
    private WebElement alertView;

    @iOSXCUITFindBy(accessibility = "Steppers")
    private WebElement steppers;
    @iOSXCUITFindBy(accessibility = "Web View")
    private WebElement webView;
    @iOSXCUITFindBy(accessibility = "Picker View")
    private WebElement pickerView;

    public AlertViewsPage selectAlertView(){
        alertView.click();
        return new AlertViewsPage(driver);
    }

    public SteppersPage selectSteppers(){
        steppers.click();
        return new SteppersPage(driver);
    }
    public WebViewPage selectWebView(){
        scrollDownAction(webView);
        webView.click();
        return new WebViewPage(driver);
    }

    public PickerViewPage selectPickerView(){
        pickerView.click();
        return new PickerViewPage(driver);
    }



}
