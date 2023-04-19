package pages.android.ApiDemos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import pages.android.BasePageAndroid;

public class ExpandableListsPage extends BasePageAndroid {

    public ExpandableListsPage(AndroidDriver driver){
        super(driver);
    }

    @AndroidFindBy(accessibility = "1. Custom Adapter")
    private WebElement customAdapter;


    public CustomAdapterPage clickCustomAdapter(){
        customAdapter.click();
        return new CustomAdapterPage(driver);
    }

}
