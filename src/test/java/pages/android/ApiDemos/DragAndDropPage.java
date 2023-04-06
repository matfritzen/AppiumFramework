package pages.android.ApiDemos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.android.BasePageAndroid;

public class DragAndDropPage extends BasePageAndroid {

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_1")
    private WebElement source;
    @AndroidFindBy(id = "io.appium.android.apis:id/drag_result_text")
    private WebElement message;

    public DragAndDropPage(AndroidDriver driver){super(driver);}

    public void dragAndDropTheImage(){
        jsDragAndDrop(source,837, 739);
        wait.until(ExpectedConditions.textToBePresentInElement(message,"Dropped!"));
    }

    public void verifyResultMessage(String resultMessage){
        Assert.assertEquals(message.getText(),resultMessage);
    }


}
