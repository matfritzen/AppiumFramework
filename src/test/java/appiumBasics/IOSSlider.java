package appiumBasics;

import testUtils.IOSBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSSlider extends IOSBaseTest {

    @Test
    public void IOSSliderTest() throws InterruptedException {

        WebElement slider = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`label == 'AppElem'`]"));
        slider.sendKeys("0%");
        Thread.sleep(3000);
        Assert.assertEquals(slider.getAttribute("value"), "0%");

        slider.sendKeys("0.5%");
        Thread.sleep(3000);
        Assert.assertEquals(slider.getAttribute("value"), "57%");

        slider.sendKeys("1%");
        Thread.sleep(3000);
        Assert.assertEquals(slider.getAttribute("value"), "100%");

    }

}
