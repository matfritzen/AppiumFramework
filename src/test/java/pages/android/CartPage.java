package pages.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePageAndroid {


    // Selectors available for Android: xpath, id, accessibilityId, classname, androidUIAutomator


    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    private List<WebElement> productsNames;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productsPrices;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalAmount;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement termsAndConditionsBtn;
    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement termsAndConditionsCheckbox;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement acceptButton;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement proceedBtn;



    public CartPage(AndroidDriver driver){
        super(driver);
    }

    public void valiadateProductsInTheCart(String productName){

        //Both waits are validating the text of the Toolbar title
        wait.until(ExpectedConditions.textToBe(By.id("com.androidsample.generalstore:id/toolbar_title"),"Cart"));
        wait.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"),"text","Cart"));

        int cartProductItensQty = productsNames.size();
        String cartProductName = "";
        for (int i = 0; i<cartProductItensQty; i++){
            cartProductName = productsNames.get(i).getText();
            if (cartProductName.equals(productName)){
                break;
            }
        }

        Assert.assertEquals(cartProductName,productName);
    }

    public void validateCartTotalAmount(){

        wait.until(ExpectedConditions.visibilityOf(totalAmount));
        int count = productsPrices.size();
        double sum = 0;

        String totalAmountString = totalAmount.getText();
        double totalAmount = getFormatterAmount(totalAmountString);

        for (int i = 0; i < count; i++){

            String amountString = productsPrices.get(i).getText();
            // Removing Dollar sign to sum the values $160.07
            Double price = getFormatterAmount(amountString);
            sum = sum + price;
        }

        Assert.assertEquals(sum, totalAmount);

    }

    public void acceptTermsAndConditions(){

        longPressAction(termsAndConditionsBtn);

        String alertTitle = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "Terms Of Conditions");

        wait.until(ExpectedConditions.elementToBeClickable(acceptButton));
        acceptButton.click();
    }

    public void submitOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(proceedBtn));
        termsAndConditionsCheckbox.click();
        proceedBtn.click();
    }


}
