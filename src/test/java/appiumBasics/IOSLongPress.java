package appiumBasics;

import testUtils.IOSBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IOSLongPress extends IOSBaseTest {

    @Test
    public void IOSLongPressTest(){

        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();

        //iosClassChain is faster than xpath
        WebElement element = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Increment'`][3]"));
        longPressAction(element);


    }

}
