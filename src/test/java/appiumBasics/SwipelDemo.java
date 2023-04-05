package appiumBasics;

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

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        Assert.assertEquals(firstImage.getAttribute("focusable"), "true");
        jsSwipeByElementId(firstImage, "left");
        Assert.assertEquals(firstImage.getAttribute("focusable"), "false");

    }


}
