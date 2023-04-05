package appiumBasics;

import testUtils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import java.io.IOException;

public class ScrollDemo extends AndroidBaseTest {

    @Test
    public void ScrollDemoTest() throws IOException, InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
//        androidScrollByText("WebView");
//        jsScrollDown(5.0);
//        jsScrollUp(10.0);
//        jsScrollUntilTheEndOfTheScreen();
//        jsScrollUntilTheTopOfTheScreen();

    }


}
