package appiumBasics;

import pages.ios.UIKitCatalogue.SteppersPage;
import testUtils.IOSBaseTest;
import org.testng.annotations.Test;

public class IOSLongPress extends IOSBaseTest {

    @Test
    public void IOSLongPressTest(){

        SteppersPage steppersPage = homePage.selectSteppers();

        //iosClassChain is faster than xpath
        steppersPage.longPressCustomIncrementBtn();


    }

}
