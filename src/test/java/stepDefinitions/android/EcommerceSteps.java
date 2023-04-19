package stepDefinitions.android;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.android.GeneralStore.CartPage;
import pages.android.GeneralStore.FormPage;
import pages.android.GeneralStore.ProductCataloguePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static stepDefinitions.Hooks.*;

public class EcommerceSteps {

    FormPage formPage = new FormPage(androidDriver);
    ProductCataloguePage productCataloguePage;
    CartPage cartPage;

    List<String> products;

    @Given("I select the country {string}")
    public void iSelectTheCountry(String country) throws Exception {
        formPage.selectCountry(country);
    }

    @Given("I fill the form correctly")
    public void iFillTheFormCorrectly() throws Exception {
        iSelectTheCountry("Argentina");
        iFillTheNameFieldWith("Matheus");
        iSelectTheGender("Male");
        iClickOnLetsShopButton();
        iVerifyUserIsOnPage("Products");
    }

    @And("I fill the Name field with {string}")
    public void iFillTheNameFieldWith(String name) {
        formPage.setNameField(name);
    }

    @And("I select the gender {string}")
    public void iSelectTheGender(String gender) {
        formPage.setGender(gender);
    }

    @And("I validate the total amount")
    public void iValidateTheTotalAmount() {
        cartPage.validateCartTotalAmount();
    }

    @When("I click on Lets Shop button")
    public void iClickOnLetsShopButton() {
        productCataloguePage = formPage.clickLetsShopBtn();
    }
    @When("I add the product {string} in the cart")
    public void iAddTheProductInTheCart(String product) {
        products = new ArrayList<>();
        products.add(product);
        productCataloguePage.androidScrollByText(product);
        productCataloguePage.addItemToCartByName(product);

    }


    @When("I accept the terms and conditions")
    public void iAcceptTheTermsAndConditions() {
        cartPage.acceptTermsAndConditions();
    }

    @Then("I verify user is on {string} page")
    public void iVerifyUserIsOnPage(String pageName) throws Exception {
        switch (pageName){
            case "Products":
                productCataloguePage.verifyProductsPage();
                break;
            default:
                throw new Exception("The "+pageName+" page does not exist");
        }
    }

    @Then("I verify the error message for {string}")
    public void iVerifyTheErrorMessageFor(String errorCause) throws Exception {
        switch (errorCause){
            case "user with no name":
                formPage.verifyErrorMessageEmptyName();
                break;
            default:
                throw new Exception("The "+errorCause+" error cause does not exist");
        }
    }

    @Then("I validate the products in the cart")
    public void iValidateTheProductsInTheCart() throws InterruptedException {
         cartPage = productCataloguePage.goToCartPage();

        for (int i = 0; i<products.size(); i++) {
            cartPage.valiadateProductsInTheCart(products.get(i));
        }

    }

    @Then("I submit the order")
    public void iSubmitTheOrder() {
        cartPage.submitOrder();
    }

    @And("I search {string} in the google page")
    public void iSearchInTheGooglePage(String search) throws InterruptedException {

        Thread.sleep(4000);

        Set<String> contexts = androidDriver.getContextHandles();

        // Verifying the name of the contexts available
        for (String contextName : contexts){

            System.out.println(contextName);
        }

        // Check chrome driver available according to the version installed in the machine
        // Setup chrome driver path in the BaseTest class
        // Moving context to interact with Google Chrome opened inside the application
        androidDriver.context("WEBVIEW_com.androidsample.generalstore");
        androidDriver.findElement(By.name("q")).sendKeys(search);
        androidDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        androidDriver.pressKey( new KeyEvent(AndroidKey.BACK));

        // Returning the Context to the Application
        androidDriver.context("NATIVE_APP");
    }

}
