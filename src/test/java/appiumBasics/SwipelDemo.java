package appiumBasics;

import pages.android.ApiDemos.GalleryPage;
import pages.android.ApiDemos.HomePage;
import pages.android.ApiDemos.PhotosPage;
import pages.android.ApiDemos.ViewsPage;
import testUtils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SwipelDemo extends AndroidBaseTest {

    @Test
    public void SwipeDemoTest() throws IOException, InterruptedException {
        ViewsPage viewsPage = homePage.clickViewsOption();
        GalleryPage galleryPage = viewsPage.clickGallery();
        PhotosPage photosPage = galleryPage.clickPhotosOption();

        photosPage.swipeImage();

    }


}
