package pages.android.GeneralStore;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.android.BasePageAndroid;
import pages.android.GeneralStore.CartPage;

import java.util.List;

public class ProductCataloguePage extends BasePageAndroid {


    // Selectors available for Android: xpath, id, accessibilityId, classname, androidUIAutomator

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
    private List<WebElement> addToCartBtn;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    private List<WebElement> productNameList;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cartBtn;



    public ProductCataloguePage(AndroidDriver driver){
        super(driver);
    }

    public void addItemToCartByName(String productName){

        androidScrollByText(productName);

        for (int i = 0; i<productNameList.size(); i++){
            String productNameInList = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productNameInList.equals(productName)){
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }
    }

    public void addItemToCartByIndex(int index){
        addToCartBtn.get(index).click();
    }

    public CartPage goToCartPage() throws InterruptedException {
        cartBtn.click();
        Thread.sleep(2000);
        return new CartPage(driver);
    }



}
