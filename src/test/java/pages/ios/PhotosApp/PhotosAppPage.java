package pages.ios.PhotosApp;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.ios.BasePageIOS;

import java.util.List;

public class PhotosAppPage extends BasePageIOS {

    public PhotosAppPage(IOSDriver driver){
        super(driver);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"All Photos\"`]")
    private WebElement allPhotosOption;
    @iOSXCUITFindBy(accessibility = "Albums")
    private WebElement albumsOptiom;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    private List<WebElement> allPhotosImages;



    public void clickAllPhotosOption(){
        allPhotosOption.click();
    }

    public void swipePhotos(){

        int allPhotosImagesSize = allPhotosImages.size();

        for (int i = 0; i < allPhotosImagesSize; i++){
            if (i == 0) {
                allPhotosImages.get(i).click();
            }
            System.out.println(driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
            swipeAction("left");
        }
    }

    public void clickAlbumsOption(){
        albumsOptiom.click();
    }


}
