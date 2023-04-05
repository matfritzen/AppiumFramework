package appiumBasics;

import testUtils.IOSBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ios.AlertViewPage;

public class IOSBasics extends IOSBaseTest {

    @Test
    public void IOSBasics(){

        //IOS Locators: id, accessibility id, classname, xpath, IOS, iosClassChain, IOSPredicateString
        AlertViewPage alertViewPage = homePage.selectAlertView();

        //iosClassChain is faster than xpath
        alertViewPage.fillTextLabel("Hello World");
        alertViewPage.clickAcceptPopUp();


        // The [c] is referring that is case-sensitive
//        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel'")).click();
//        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'")).click();


        String message = alertViewPage.getConfirmMessage();
        Assert.assertEquals(message, "A message should be a short, complete sentence.");

        alertViewPage.clickConfirmButton();


    }

}
