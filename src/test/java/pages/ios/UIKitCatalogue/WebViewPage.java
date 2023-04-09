package pages.ios.UIKitCatalogue;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.ios.BasePageIOS;

public class WebViewPage extends BasePageIOS {

    public WebViewPage(IOSDriver driver){
        super(driver);
    }

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'UIKitCatalog' AND name == 'UIKitCatalog' AND type == 'XCUIElementTypeButton'")
    private WebElement uiKitCatalogBackBtn;



    public void clickUiKitCatalogBackButton(){
        uiKitCatalogBackBtn.click();
    }

}
