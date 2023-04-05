package appiumBasics;

import testUtils.IOSBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSScrollTest extends IOSBaseTest {

    @Test
    public void IOSScrollTest(){

        WebElement element = driver.findElement(AppiumBy.accessibilityId("Web View"));
        scrollDownAction(element);
        element.click();
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'UIKitCatalog' AND name == 'UIKitCatalog' AND type == 'XCUIElementTypeButton'")).click();
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();

        // How to send values in a Picker.
      WebElement number1 =  driver.findElement(AppiumBy.accessibilityId("Red color component value"));
      WebElement number2 =  driver.findElement(AppiumBy.accessibilityId("Green color component value"));
      WebElement number3 =   driver.findElement(AppiumBy.accessibilityId("Blue color component value"));

        number1.sendKeys("80");
        number2.sendKeys("220");
        number3.sendKeys("105");

        Assert.assertEquals(number1.getText(), "80");
        Assert.assertEquals(number2.getText(), "220");
        Assert.assertEquals(number3.getText(), "105");

    }
}
