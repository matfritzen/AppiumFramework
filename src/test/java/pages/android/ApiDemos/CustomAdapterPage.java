package pages.android.ApiDemos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.android.BasePageAndroid;

public class CustomAdapterPage extends BasePageAndroid {

    public CustomAdapterPage(AndroidDriver driver){
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='People Names']")
    private WebElement peopleNames;

    @AndroidFindBy(id = "android:id/title")
    private WebElement sampleMenu;



    public void validateSampleMenuTitle(){
        longPressAction(peopleNames);
        Assert.assertTrue(sampleMenu.isDisplayed());
        Assert.assertEquals(sampleMenu.getText(), "Sample menu");
    }

}
