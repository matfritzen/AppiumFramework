package appiumBasics;

import testUtils.IOSBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSSlider extends IOSBaseTest {

    @Test
    public void IOSSliderTest() throws InterruptedException {

        testAppPage.setSlider("0%");
        Thread.sleep(1000);
        Assert.assertEquals(testAppPage.getSliderValue(), "0%");

        testAppPage.setSlider("0.5%");
        Thread.sleep(1000);
        Assert.assertEquals(testAppPage.getSliderValue(), "57%");

        testAppPage.setSlider("1%");
        Thread.sleep(1000);
        Assert.assertEquals(testAppPage.getSliderValue(), "100%");

    }

}
