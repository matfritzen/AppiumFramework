package appiumBasics;

import testUtils.IOSBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ios.UIKitCatalogue.AlertViewsPage;

public class IOSBasics extends IOSBaseTest {

    @Test
    public void IOSBasics(){

        //IOS Locators: id, accessibility id, classname, xpath, IOS, iosClassChain, IOSPredicateString
        AlertViewsPage alertViewsPage = homePage.selectAlertView();

        //iosClassChain is faster than xpath
        alertViewsPage.clickTextEntry();
        alertViewsPage.fillTextLabel("Hello World");
        alertViewsPage.clickAcceptPopUp();


        // The [c] is referring that is case-sensitive
//        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel'")).click();
//        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'")).click();


        String message = alertViewsPage.getConfirmMessage();
        Assert.assertEquals(message, "A message should be a short, complete sentence.");

        alertViewsPage.clickConfirmButton();


    }

}
