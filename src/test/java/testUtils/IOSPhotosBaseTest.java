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

public class IOSPhotosBaseTest extends Utils {

    public IOSDriver driver;
    public AppiumDriverLocalService service;
    public HomePage homePage;

    public TestAppPage testAppPage;



    @BeforeClass(alwaysRun = true)
    public void ConfigureAppium() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//resources//files//properties//data.properties");
        prop.load(fis);

        String ipAddress = prop.getProperty("ipAddress");
        int port = Integer.parseInt(prop.getProperty("port"));
        String deviceName = prop.getProperty("iOSDeviceName");

        service = startAppiumServer(ipAddress,port);

        XCUITestOptions options = new XCUITestOptions();

        options.setDeviceName(deviceName); // Emulator
        options.setApp("com.apple.mobileslideshow");
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
