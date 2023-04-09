package pages.android.ApiDemos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.android.BasePageAndroid;

import java.util.List;

public class PhotosPage extends BasePageAndroid {

    @AndroidFindBy(xpath = "(//android.widget.ImageView)[1]")
    private WebElement firstImage;

    @AndroidFindBy(xpath = "//android.widget.ImageView")
    private List<WebElement> listOfImages;



    public PhotosPage(AndroidDriver driver){super(driver);}

    public void swipeImage(){
        Assert.assertEquals(firstImage.getAttribute("focusable"), "true");
        jsSwipeByElementId(firstImage, "left");
        Assert.assertEquals(firstImage.getAttribute("focusable"), "false");
    }


}
