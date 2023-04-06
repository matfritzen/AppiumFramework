package testUtils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class AndroidBaseTest extends Utils {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;


    @BeforeClass(alwaysRun = true)
    public void ConfigureAppium() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//resources//files//properties//data.properties");
        prop.load(fis);


        // If the user execute the tests through CLI maven command,
        // the ipAddress can be passed as parameter like this: mvn test -PSmoke -DipAddress=213.42.322
        //if the ipAddress is null, then the system will get the value from the properties file
        String ipAddress = System.getProperty("ipAddress") !=  null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");

//        String ipAddress = prop.getProperty("ipAddress");
        int port = Integer.parseInt(prop.getProperty("port"));
        String deviceName = prop.getProperty("AndroidDeviceName");


        service = startAppiumServer(ipAddress,port);

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(deviceName); // Emulator

        //Connect the Device in the computer (USB)
        //Access https://developer.chrome.com/docs/devtools/remote-debugging/ and follow the steps
//        options.setDeviceName("Android Device");


        options.setChromedriverExecutable("//Users//matheusfritzen//Downloads//chromedriver");
//        options.setApp("/Users/matheusfritzen/AutomationProjects/Mobile/AppiumFramework/src/test/java/resources/apk/ApiDemos-debug.apk");
        options.setApp("/Users/matheusfritzen/AutomationProjects/Mobile/AppiumFramework/src/test/java/resources/apk/General-Store.apk");


        // Appium Code -> Appium Server -> Mobile
         driver = new AndroidDriver(service.getUrl(), options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    // gitHub with all the UIAutomator2 gestures
    // https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md


    public void longPressAction(WebElement element){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),"duration",2000));
    }

    public void androidScrollByText(String text){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
    }

    public void jsScrollDown(Double percentage){
        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", "down",
                "percent", percentage
        ));
    }

    public void jsScrollUp(Double percentage){
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 500, "width", 200, "height", 200,
                "direction", "up",
                "percent", percentage
        ));
    }

    public void jsScrollUntilTheEndOfTheScreen(){

        boolean canScrollMore;

       do {
           canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                   "left", 100, "top", 100, "width", 200, "height", 200,
                   "direction", "down",
                   "percent", 10.0
           ));
       }
       while (canScrollMore);

    }

    public void jsScrollUntilTheTopOfTheScreen(){

        boolean canScrollMore;

        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 500, "width", 200, "height", 200,
                    "direction", "up",
                    "percent", 10.0
            ));
        }
        while (canScrollMore);

    }

    public void jsSwipeByElementId(WebElement element, String direction){

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//                "left", 100, "top", 100, "width", 200, "height", 200,
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    public Double getFormatterAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }


    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
        service.stop();

    }
}
