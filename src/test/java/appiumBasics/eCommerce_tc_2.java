package appiumBasics;

import pages.android.GeneralStore.CartPage;
import pages.android.GeneralStore.FormPage;
import pages.android.GeneralStore.ProductCataloguePage;
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

        FormPage formPage = new FormPage(driver);

        formPage.selectCountry("Argentina");
        formPage.setNameField("Matheus");
        formPage.setGender("Female");
        ProductCataloguePage productCataloguePage  = formPage.clickLetsShopBtn();

        productCataloguePage.androidScrollByText("Jordan 6 Rings");

        productCataloguePage.addItemToCartByName("Jordan 6 Rings");

        CartPage cartPage = productCataloguePage.goToCartPage();

        cartPage.valiadateProductsInTheCart("Jordan 6 Rings");
    }



}
