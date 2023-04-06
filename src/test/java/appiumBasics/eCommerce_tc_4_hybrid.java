package appiumBasics;

import testUtils.AndroidBaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.android.GeneralStore.CartPage;
import pages.android.GeneralStore.FormPage;
import pages.android.GeneralStore.ProductCataloguePage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class eCommerce_tc_4_hybrid extends AndroidBaseTest {


    @BeforeMethod(alwaysRun = true)
    public void preSetup() throws MalformedURLException {
//        FormPage formPage = new FormPage(driver);
//        formPage.setActivity();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("MobileAutomationPhone");
        options.setChromedriverExecutable("//Users//matheusfritzen//Downloads//chromedriver");
        options.setApp("/Users/matheusfritzen/AutomationProjects/Mobile/AppiumFramework/src/test/java/resources/apk/General-Store.apk");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test(dataProvider = "getData", groups = {"Smoke"})
    public void FillFormCorrecly(HashMap<String,String> input) throws InterruptedException {
        FormPage formPage = new FormPage(driver);
        // Selectors available for Android: xpath, id, accessibilityId, classname, androidUIAutomator

//        FormPage formPage = new FormPage(driver);

        formPage.setNameField(input.get("name"));
        formPage.setGender(input.get("gender"));
        formPage.selectCountry(input.get("country"));

        ProductCataloguePage productCataloguePage = formPage.clickLetsShopBtn();

//        productCataloguePage.addItemToCartByName("Air Jordan 4 Retro");
//        productCataloguePage.addItemToCartByName("Jordan 6 Rings");
        productCataloguePage.addItemToCartByIndex(0);
        productCataloguePage.addItemToCartByIndex(1);


        CartPage cartPage = productCataloguePage.goToCartPage();

//        cartPage.valiadateProductsInTheCart("Air Jordan 4 Retro");
//        cartPage.valiadateProductsInTheCart("Jordan 6 Rings");
        cartPage.validateCartTotalAmount();
//        cartPage.acceptTermsAndConditions();
        cartPage.submitOrder();
        Thread.sleep(6000);

        // hybrid app
        Set<String> contexts = driver.getContextHandles();

        // Verifying the name of the contexts available
        for (String contextName : contexts){

            System.out.println(contextName);
        }

        // Check chrome driver available according to the version installed in the machine
        // Setup chrome driver path in the BaseTest class
        // Moving context to interact with Google Chrome opened inside the application
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("test");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey( new KeyEvent(AndroidKey.BACK));

        // Returning the Context to the Application
        driver.context("NATIVE_APP");
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String,String>> data =  getJsonData(System.getProperty("user.dir")+"//src//test//java//resources//files//json//eCommerce.json");
        return new Object[][] {{data.get(0)}};

    }



}
