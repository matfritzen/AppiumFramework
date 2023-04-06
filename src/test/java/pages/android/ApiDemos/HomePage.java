package pages.android.ApiDemos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.android.BasePageAndroid;

import java.util.List;

public class HomePage extends BasePageAndroid {

    @AndroidFindBy(accessibility = "Views")
    private WebElement views;

    public HomePage(AndroidDriver driver){super(driver);}

    public ViewsPage clickViewsOption(){
        views.click();
        return new ViewsPage(driver);
    }


}
