package appiumBasics;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserBaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;



    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {

        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("0.0.0.0").usingPort(4723).build();

        service.start();


        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("MobileAutomationPhone");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.setChromedriverExecutable("//Users//matheusfritzen//Downloads//chromedriver");
//        options.setCapability("browserName", "Chrome");

        // Appium Code -> Appium Server -> Mobile
         driver = new AndroidDriver(new URL("http://0.0.0.0:4723/"), options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public Double getFormatterAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }


    @AfterClass
    public void tearDown(){

        driver.quit();
        service.stop();

    }
}
