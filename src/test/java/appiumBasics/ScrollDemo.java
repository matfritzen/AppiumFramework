package appiumBasics;

import pages.android.ApiDemos.ViewsPage;
import testUtils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import java.io.IOException;

public class ScrollDemo extends AndroidBaseTest {

    @Test
    public void ScrollDemoTest() throws IOException, InterruptedException {

        ViewsPage viewsPage = homePage.clickViewsOption();
        viewsPage.androidScrollByText("WebView");
        viewsPage.jsScrollDown(5.0);
        viewsPage.jsScrollUp(10.0);
        viewsPage.jsScrollUntilTheEndOfTheScreen();
        viewsPage.jsScrollUntilTheTopOfTheScreen();

    }


}
