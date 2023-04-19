package testUtils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.ios.TestApp3.TestAppPage;
import pages.ios.UIKitCatalogue.HomePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class IOSBaseTest extends Utils {

    public IOSDriver driver;
    public AppiumDriverLocalService service;
    public HomePage homePage;

    public TestAppPage testAppPage;



    @BeforeClass(alwaysRun = true)
    public void ConfigureAppiumIOS() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//resources//files//properties//data.properties");
        prop.load(fis);

        String ipAddress = prop.getProperty("ipAddress");
        int port = Integer.parseInt(prop.getProperty("port"));
        String deviceName = prop.getProperty("iOSDeviceName");

        service = startAppiumServer(ipAddress,port);

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName(deviceName); // Emulator


        // Real Device
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
//
//        capabilities.setCapability("xcodeOrgId", ""); // you should ask to the Team about the orgId
//        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
//        capabilities.setCapability("udid", ""); // udid is tied up to real device, you should connect the phone on Mac via cable, and in iTunes app you can get the udid
//        capabilities.setCapability("updateWDABundleId", ""); // you should ask about the bundle id to the team


//        options.setApp("/Users/matheusfritzen/AutomationProjects/Mobile/AppiumFramework/src/test/java/resources/UIKitCatalog.app");
        options.setApp("/Users/matheusfritzen/AutomationProjects/Mobile/AppiumFramework/src/test/java/resources/TestApp 3.app");
        options.setPlatformVersion("16.2");

        // Appium -> Webdriver Agent -> IOS Apps.
        // Time that wait until th WebDriver install the application
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        // Appium Code -> Appium Server -> Mobile
//         driver = new IOSDriver(new URL("http://0.0.0.0:4723/"), capabilities); // Real Device
         driver = new IOSDriver(service.getUrl(), options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         homePage = new HomePage(driver);
         testAppPage = new TestAppPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
