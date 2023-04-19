package stepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.android.ApiDemos.HomePage;
import testUtils.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class Hooks extends Utils {

    public static AndroidDriver androidDriver;
    public static IOSDriver iOSDriver;

    public static boolean isAndroid;

    public static boolean isIos;

    public static AppiumDriverLocalService service;

    private String deviceName;

    private String ipAddress;
    private int port;

    private static ArrayList<String> tags;


    //    @BeforeClass(alwaysRun = true)
    @Before()
    public void ConfigureAppiumCucumber(Scenario scenario) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//resources//files//properties//data.properties");
        prop.load(fis);


        // If the user execute the tests through CLI maven command,
        // the ipAddress can be passed as parameter like this: mvn test -PSmoke -DipAddress=213.42.322
        //if the ipAddress is null, then the system will get the value from the properties file
        ipAddress = System.getProperty("ipAddress") !=  null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");

//        String ipAddress = prop.getProperty("ipAddress");
        port = Integer.parseInt(prop.getProperty("port"));
        service = startAppiumServer(ipAddress,port);

        //Validating if it is Android or IOS
        Collection<String> tagsCollection = scenario.getSourceTagNames();
        tags = new ArrayList<>(tagsCollection);

        boolean isApiDemosApp = false;
        boolean isEcommerceApp = false;
        boolean isPhotoApp = false;
        boolean isUiKitCatalogueApp = false;
        boolean isTestApp3 = false;

        for (int i = 0; i < tags.size(); i++){
            String tagName = tags.get(i);

            if(tags.get(i).equalsIgnoreCase("@Android")) {
                isAndroid = true;
                isIos = false;
            }
            else if (tags.get(i).equalsIgnoreCase("@iOS")) {
                isIos = true;
                isAndroid = false;
            }
            else if (tags.get(i).equalsIgnoreCase("@ApiDemos")){
                isApiDemosApp = true;
            }
            else if (tags.get(i).equalsIgnoreCase("@Ecommerce")){
                isEcommerceApp = true;
            }
            else if (tags.get(i).equalsIgnoreCase("@UiKitCatalogue")){
                isUiKitCatalogueApp = true;
            }
            else if (tags.get(i).equalsIgnoreCase("@TestApp3")){
                isTestApp3 = true;
            }
            else if (tags.get(i).equalsIgnoreCase("@Photos")){
                isPhotoApp = true;
            }


            service.stop();
        }

        if(isAndroid){
            deviceName = prop.getProperty("AndroidDeviceName");

            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName(deviceName); // Emulator

            //Connect the Device in the computer (USB)
            //Access https://developer.chrome.com/docs/devtools/remote-debugging/ and follow the steps
//        options.setDeviceName("Android Device");
            options.setChromedriverExecutable("//Users//matheusfritzen//Downloads//chromedriver");

            if (isApiDemosApp){
                options.setApp("/Users/matheusfritzen/AutomationProjects/Mobile/AppiumFramework/src/test/java/resources/apk/ApiDemos-debug.apk");
            }
            else if (isEcommerceApp) {
                options.setApp("/Users/matheusfritzen/AutomationProjects/Mobile/AppiumFramework/src/test/java/resources/apk/General-Store.apk");
            }

            androidDriver = new AndroidDriver(service.getUrl(), options);
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        else if (isIos) {
            deviceName = prop.getProperty("iOSDeviceName");

            XCUITestOptions options = new XCUITestOptions();
            options.setDeviceName(deviceName); // Emulator

            if (isUiKitCatalogueApp){
                options.setApp("/Users/matheusfritzen/AutomationProjects/Mobile/AppiumFramework/src/test/java/resources/UIKitCatalog.app");
            }
            else if(isTestApp3) {
              options.setApp("/Users/matheusfritzen/AutomationProjects/Mobile/AppiumFramework/src/test/java/resources/TestApp 3.app");
            }
            else if (isPhotoApp){
                options.setApp("com.apple.mobileslideshow");
            }

            options.setPlatformVersion("16.2");

            // Appium -> Webdriver Agent -> IOS Apps.
            // Time that wait until th WebDriver install the application
            options.setWdaLaunchTimeout(Duration.ofSeconds(20));

            iOSDriver = new IOSDriver(service.getUrl(), options);
            iOSDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }


    public static ArrayList<String> getTags(){
        return tags;
    }

    public static void deviceRotation(){
        DeviceRotation landScape = new DeviceRotation(0, 0, 90);
        if (Hooks.isAndroid){
            Hooks.androidDriver.rotate(landScape);
        }
        else if (Hooks.isIos){
            Hooks.iOSDriver.rotate(landScape);
        }
    }

    @AfterStep
    public void addScreenshotOnFailure(Scenario scenario) throws IOException {
        if (scenario.isFailed()){

            if (isAndroid) {
                addScreenshot(scenario, androidDriver);
            }

            else if(isIos){
                addScreenshot(scenario, iOSDriver);
            }
        }
    }


    @After
    public void tearDown() throws IOException {

        for (int i = 0; i < tags.size(); i++){

            if(tags.get(i).equalsIgnoreCase("@Android")) {
                androidDriver.quit();
                break;
            }
            else if (tags.get(i).equalsIgnoreCase("@iOS")) {
                iOSDriver.quit();
            }

            service.stop();
        }

    }
}
