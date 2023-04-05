package appiumBasics;

import testUtils.IOSBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class IOSSwipeTest extends IOSBaseTest {

    @Test
    public void IOSSwipeTestDemo() throws InterruptedException {
        launchPhotosApp();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'All Photos'")).click();
        List<WebElement> allPhotos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
        driver.findElement(By.xpath("//XCUIElementTypeCell[1]")).click();

        for (int i = 0; i < allPhotos.size(); i++){

           System.out.println(driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
           swipeAction("left");
        }

        driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("Albums")).click();

    }

}
