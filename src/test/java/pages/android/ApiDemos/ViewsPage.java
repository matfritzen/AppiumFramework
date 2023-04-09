package pages.android.ApiDemos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.android.BasePageAndroid;

public class ViewsPage extends BasePageAndroid {

    @AndroidFindBy(accessibility = "Drag and Drop")
    private WebElement dragAndDrop;

    @AndroidFindBy(accessibility = "Gallery")
    private WebElement gallery;
    @AndroidFindBy(accessibility = "Expandable Lists")
    private WebElement expandableLists;

    public ViewsPage(AndroidDriver driver){super(driver);}

    public DragAndDropPage clickDragAndDrop(){
        dragAndDrop.click();
        return new DragAndDropPage(driver);
    }

    public GalleryPage clickGallery(){
        gallery.click();
        return new GalleryPage(driver);
    }
    public ExpandableListsPage clickExpandableLists(){
        expandableLists.click();
        return new ExpandableListsPage(driver);
    }


}
