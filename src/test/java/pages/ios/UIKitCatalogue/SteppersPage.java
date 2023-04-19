package pages.ios.UIKitCatalogue;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.ios.BasePageIOS;

public class SteppersPage extends BasePageIOS {

    public SteppersPage(IOSDriver driver){
        super(driver);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Increment'`][3]")
    private WebElement customIncrementBtn;



    public void longPressCustomIncrementBtn(){
        longPressAction(customIncrementBtn);
    }

}
