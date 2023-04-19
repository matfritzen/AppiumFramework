package appiumBasics;

import pages.android.GeneralStore.CartPage;
import pages.android.GeneralStore.FormPage;
import pages.android.GeneralStore.ProductCataloguePage;
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

    @Test
    public void FillFormCorrecly() throws InterruptedException {

        // Selectors available for Android: xpath, id, accessibilityId, classname, androidUIAutomator
        FormPage formPage = new FormPage(driver);

        formPage.selectCountry("Argentina");
        formPage.setNameField("Matheus");
        formPage.setGender("Female");
        ProductCataloguePage productCataloguePage  = formPage.clickLetsShopBtn();

        productCataloguePage.addItemToCartByName("Jordan 6 Rings");
        productCataloguePage.addItemToCartByName("Air Jordan 4 Retro");

        CartPage cartPage = productCataloguePage.goToCartPage();


        cartPage.valiadateProductsInTheCart("Air Jordan 4 Retro");
        cartPage.valiadateProductsInTheCart("Jordan 6 Rings");

        cartPage.validateCartTotalAmount();
        cartPage.acceptTermsAndConditions();
        cartPage.submitOrder();

    }



}
