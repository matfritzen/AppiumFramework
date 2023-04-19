package appiumBasics;

import pages.ios.UIKitCatalogue.PickerViewPage;
import pages.ios.UIKitCatalogue.WebViewPage;
import testUtils.IOSBaseTest;
import org.testng.annotations.Test;

public class IOSScrollTest extends IOSBaseTest {

    @Test
    public void IOSScrollTest(){

        WebViewPage webViewPage = homePage.selectWebView();
        webViewPage.clickUiKitCatalogBackButton();

        PickerViewPage pickerViewPage = homePage.selectPickerView();

        // How to send values in a Picker.
        pickerViewPage.setNumber1("80");
        pickerViewPage.setNumber2("220");
        pickerViewPage.setNumber3("105");

    }
}
