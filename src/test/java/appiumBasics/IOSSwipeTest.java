package appiumBasics;

import pages.ios.PhotosApp.PhotosAppPage;
import testUtils.IOSBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import testUtils.IOSPhotosBaseTest;

import java.util.List;
import java.util.Set;

public class IOSSwipeTest extends IOSPhotosBaseTest {

    @Test
    public void IOSSwipeTestDemo() throws InterruptedException {

        PhotosAppPage photosAppPage = new PhotosAppPage(driver);

        photosAppPage.clickAllPhotosOption();
        photosAppPage.swipePhotos();

        driver.navigate().back();

        photosAppPage.clickAlbumsOption();

    }

}
