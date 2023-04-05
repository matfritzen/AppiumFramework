package appiumBasics;

import testUtils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class eCommerce_tc_3 extends AndroidBaseTest {

    public void addItemToCart(String productName){

        androidScrollByText(productName);

        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for (int i = 0; i<productCount; i++){
            String productNameInList = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productNameInList.equals(productName)){
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }
    }

    public void valiadateProductsInTheCart(String productName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Both waits are validating the text of the Toolbar title
        wait.until(ExpectedConditions.textToBe(By.id("com.androidsample.generalstore:id/toolbar_title"),"Cart"));
        wait.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"),"text","Cart"));

        int cartProductItensQty = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        String cartProductName = "";
        for (int i = 0; i<cartProductItensQty; i++){
            cartProductName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (cartProductName.equals(productName)){
                break;
            }
        }

        Assert.assertEquals(cartProductName,productName);
    }

    public void validateCartTotalAmount(){
        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count = productPrices.size();
        double sum = 0;

        String totalAmountString = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        double totalAmount = getFormatterAmount(totalAmountString);

        for (int i = 0; i < count; i++){

            String amountString = productPrices.get(i).getText();
            // Removing Dollar sign to sum the values $160.07
            Double price = getFormatterAmount(amountString);
            sum = sum + price;
        }

        Assert.assertEquals(sum, totalAmount);

    }

    @Test
    public void FillFormCorrecly() throws InterruptedException {

        // Selectors available for Android: xpath, id, accessibilityId, classname, androidUIAutomator

        driver.findElement(By.id("android:id/text1")).click();
        androidScrollByText("Argentina");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Matheus");
        driver.hideKeyboard();

        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        addItemToCart("Air Jordan 4 Retro");
        addItemToCart("Jordan 6 Rings");

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        valiadateProductsInTheCart("Air Jordan 4 Retro");
        valiadateProductsInTheCart("Jordan 6 Rings");

        validateCartTotalAmount();

        WebElement termsAndConditions = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(termsAndConditions);
        String alertTitle = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "Terms Of Conditions");

        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();


    }



}
