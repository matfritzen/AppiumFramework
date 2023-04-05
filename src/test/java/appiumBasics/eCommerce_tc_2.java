package appiumBasics;

import testUtils.AndroidBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class eCommerce_tc_2 extends AndroidBaseTest {


    @Test(groups = {"Smoke"})
    public void AddItemToCartTest() throws InterruptedException {

        // Selectors available for Android: xpath, id, accessibilityId, classname, androidUIAutomator

        driver.findElement(By.id("android:id/text1")).click();
        androidScrollByText("Argentina");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Matheus");
        driver.hideKeyboard();

        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        androidScrollByText("Jordan 6 Rings");

        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for (int i = 0; i<productCount; i++){
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productName.equalsIgnoreCase("Jordan 6 Rings")){
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Both waits are validating the text of the Toolbar title
        wait.until(ExpectedConditions.textToBe(By.id("com.androidsample.generalstore:id/toolbar_title"),"Cart"));
        wait.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"),"text","Cart"));

       String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
       Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
    }



}
