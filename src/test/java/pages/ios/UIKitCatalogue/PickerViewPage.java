package pages.ios.UIKitCatalogue;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.ios.BasePageIOS;

public class PickerViewPage extends BasePageIOS {

    public PickerViewPage(IOSDriver driver){
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "Red color component value")
    private WebElement number1;

    @iOSXCUITFindBy(accessibility = "Green color component value")
    private WebElement number2;

    @iOSXCUITFindBy(accessibility = "Blue color component value")
    private WebElement number3;



    public void setNumber1(String number1){
        this.number1.sendKeys(number1);
        Assert.assertEquals(this.number1.getText(), number1);
    }

    public void setNumber2(String number2){
        this.number2.sendKeys(number2);
        Assert.assertEquals(this.number2.getText(), number2);
    }

    public void setNumber3(String number3){
        this.number3.sendKeys(number3);
        Assert.assertEquals(this.number3.getText(), number3);
    }

}
