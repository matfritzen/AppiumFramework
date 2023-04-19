package appiumBasics;

import pages.android.ApiDemos.CustomAdapterPage;
import pages.android.ApiDemos.ExpandableListsPage;
import pages.android.ApiDemos.ViewsPage;
import testUtils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LongPress extends AndroidBaseTest {

    @Test
    public void LongPressGesture() throws IOException, InterruptedException {


        ViewsPage viewsPage = homePage.clickViewsOption();
        ExpandableListsPage expandableListsPage = viewsPage.clickExpandableLists();
        CustomAdapterPage customAdapterPage = expandableListsPage.clickCustomAdapter();

        customAdapterPage.validateSampleMenuTitle();

    }


}
