package pages.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import testUtils.Utils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BasePageIOS extends Utils {

    public IOSDriver driver;
    public WebDriverWait wait;

    public BasePageIOS(IOSDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void longPressAction(WebElement element){
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) element).getId());
        params.put("duration", 5);

        driver.executeScript("mobile: touchAndHold", params);
    }

    public void scrollDownAction(WebElement element){
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) element).getId());
        params.put("direction", "down");

        driver.executeScript("mobile: scroll", params);
    }

    public void scrollUpAction(WebElement element){
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) element).getId());
        params.put("direction", "up");

        driver.executeScript("mobile: scroll", params);
    }

    public void launchPhotosApp(){
        Map<String, String> params = new HashMap<String,String>();
        params.put("bundleId", "com.apple.mobileslideshow");
        driver.executeScript("mobile:launchApp", params);
    }

    public void swipeAction(String direction /*, WebElement element*/){

        Map<String,Object> params = new HashMap<String, Object>();
        params.put("direction", direction);
//        In case to swipe in a particular element
//        params.put("element", (RemoteWebElement) element).getId()));
        driver.executeScript("mobile:swipe", params);

    }


}
