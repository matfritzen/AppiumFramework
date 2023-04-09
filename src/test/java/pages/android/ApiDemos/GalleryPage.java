package pages.android.ApiDemos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.android.BasePageAndroid;

public class GalleryPage extends BasePageAndroid {

    @AndroidFindBy(accessibility = "1. Photos")
    private WebElement photosOption;

    public GalleryPage(AndroidDriver driver){super(driver);}

    public PhotosPage clickPhotosOption(){
        photosOption.click();
        return new PhotosPage(driver);
    }


}
