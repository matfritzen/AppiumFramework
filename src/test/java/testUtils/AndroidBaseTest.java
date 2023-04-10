package testUtils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java.Before;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.*;
import pages.android.ApiDemos.HomePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class AndroidBaseTest extends Utils {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    public HomePage homePage;


//    @BeforeClass(alwaysRun = true)
    public void ConfigureAppiumAndroid() throws IOException {

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
        options.setApp("/Users/matheusfritzen/AutomationProjects/Mobile/AppiumFramework/src/test/java/resources/apk/ApiDemos-debug.apk");
//        options.setApp("/Users/matheusfritzen/AutomationProjects/Mobile/AppiumFramework/src/test/java/resources/apk/General-Store.apk");


        // Appium Code -> Appium Server -> Mobile
         driver = new AndroidDriver(service.getUrl(), options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         homePage = new HomePage(driver);

    }

        public void deviceRotation(){
        DeviceRotation landScape = new DeviceRotation(0, 0, 90);
        driver.rotate(landScape);
    }

    // gitHub with all the UIAutomator2 gestures
    // https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md



//    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
        service.stop();

    }
}
