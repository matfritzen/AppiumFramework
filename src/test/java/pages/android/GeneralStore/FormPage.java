package pages.android.GeneralStore;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.android.BasePageAndroid;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class FormPage extends BasePageAndroid {


    // Selectors available for Android: xpath, id, accessibilityId, classname, androidUIAutomator

    @AndroidFindBy(id = "android:id/text1")
    private WebElement countryDropdown;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleOption;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleOption;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement btnLetsShop;

    @AndroidFindBy(xpath = "(//android.widget.Toast)[1]")
    private WebElement errorMessage;


    public FormPage(AndroidDriver driver){
        super(driver);
    }

    public void selectCountry(String country){
        countryDropdown.click();
        androidScrollByText(country);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
    }

    public void setActivity() throws MalformedURLException {
//        Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
//        driver.startActivity(activity);


// |------------------------------------------------------------------------------------------------------------------|
// |      THE BEFORE METHOD SHOULD BE ONLY THE TEXT ABOVE, BUT AS THE AndroidManifest.xml OF THE APPLICATION IS NOT   |
// |      READY TO BE STARTED AS THE ACTIVITY, I HAD TO PUT THE CODE BELOW                                            |
// |------------------------------------------------------------------------------------------------------------------|

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("MobileAutomationPhone"); // Emulator
        options.setChromedriverExecutable("//Users//matheusfritzen//Downloads//chromedriver");
        options.setApp("//Users//matheusfritzen//AutomationProjects//MobileAutomation//src//test//java//resources//General-Store.apk");

        // Appium Code -> Appium Server -> Mobile
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    public void setNameField(String name){

        nameField.sendKeys(name);
        driver.hideKeyboard();
    }

    public void setGender(String gender){
        if (gender.equalsIgnoreCase("female")){
            femaleOption.click();
        }
        else {
            maleOption.click();
        }

    }

    public void verifyErrorMessageEmptyName(){
        String toastMessage = errorMessage.getAttribute("name");
        Assert.assertEquals(toastMessage, "Please enter your name");
    }

    public ProductCataloguePage clickLetsShopBtn(){
        btnLetsShop.click();
        return new ProductCataloguePage(driver);
    }


}
