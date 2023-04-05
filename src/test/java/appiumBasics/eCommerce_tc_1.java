package appiumBasics;

import testUtils.AndroidBaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.android.GeneralStore.FormPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class eCommerce_tc_1 extends AndroidBaseTest {

    FormPage formPage;
//
    @BeforeMethod
    public void preSetup() throws MalformedURLException {
//        formPage = new FormPage(driver);
//        formPage.setActivity();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("MobileAutomationPhone");
        options.setChromedriverExecutable("//Users//matheusfritzen//Downloads//chromedriver");
        options.setApp("//Users//matheusfritzen//AutomationProjects//MobileAutomation//src//test//java//resources//apk//General-Store.apk");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void FillFormWithNoName() throws InterruptedException {
        formPage = new FormPage(driver);
        // Selectors available for Android: xpath, id, accessibilityId, classname, androidUIAutomator
        formPage.selectCountry("Argentina");
        formPage.setGender("Female");
        formPage.setGender("Male");
        formPage.clickLetsShopBtn();

        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        Assert.assertEquals(toastMessage, "Please enter your name");

    }

    @Test
    public void FillFormCorrecly() throws InterruptedException {

        // Selectors available for Android: xpath, id, accessibilityId, classname, androidUIAutomator
        formPage = new FormPage(driver);

        formPage.selectCountry("Argentina");
        formPage.setNameField("Matheus");
        formPage.setGender("Female");
        formPage.clickLetsShopBtn();
    }





}
