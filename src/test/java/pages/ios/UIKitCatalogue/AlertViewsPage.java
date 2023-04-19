package pages.ios.UIKitCatalogue;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.ios.BasePageIOS;

public class AlertViewsPage extends BasePageIOS {

    public AlertViewsPage(IOSDriver driver){
        super(driver);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")
    private WebElement textEntryMenu;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    private WebElement textBox;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")
    private WebElement confirmMenuItem;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement acceptPopUp;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'A message'")
    private WebElement confirmMessage;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm'")
    private WebElement submit;


    public void clickTextEntry(){
        textEntryMenu.click();
    }

    public void fillTextLabel(String name){
        textBox.sendKeys(name);
    }

    public void clickAcceptPopUp(){
        acceptPopUp.click();
    }

    public String getConfirmMessage(){
        confirmMenuItem.click();
        return confirmMessage.getText();
    }

    public void clickConfirmButton(){
        submit.click();
    }

    public void verifyConfirmMessage(){
        String message = confirmMessage.getText();
        Assert.assertEquals(message, "A message should be a short, complete sentence.");
    }

}
