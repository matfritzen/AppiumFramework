package pages.ios.TestApp3;

import com.beust.jcommander.StringKey;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.ios.BasePageIOS;

public class TestAppPage extends BasePageIOS {

    public TestAppPage(IOSDriver driver){
        super(driver);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSlider[`label == 'AppElem'`]")
    private WebElement slider;

    public String getSliderValue(){
        return slider.getAttribute("value");
    }

    public void setSlider(String slidePercentage) {
        slider.sendKeys(slidePercentage);
    }
}
