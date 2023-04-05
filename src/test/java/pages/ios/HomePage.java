package pages.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePageIOS{

    public HomePage(IOSDriver driver){
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "Alert Views")
    private WebElement alertView;

    public AlertViewPage selectAlertView(){
        alertView.click();
        return new AlertViewPage(driver);
    }



}
