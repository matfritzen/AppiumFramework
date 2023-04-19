package stepDefinitions.ios;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ios.UIKitCatalogue.AlertViewsPage;
import pages.ios.UIKitCatalogue.HomePage;
import pages.ios.UIKitCatalogue.PickerViewPage;
import pages.ios.UIKitCatalogue.SteppersPage;

import static stepDefinitions.Hooks.*;

public class UIKitCatalogueSteps {

    HomePage homePage = new HomePage(iOSDriver);
    AlertViewsPage alertViewsPage;
    SteppersPage steppersPage;
    PickerViewPage pickerViewPage;

    @Given("I select {string} option in the Home Page")
    public void iSelectOptionInTheHomePage(String menuOption) throws Exception {
        switch (menuOption){
            case "Alert Views":
                alertViewsPage = homePage.selectAlertView();
                break;
            case "Steppers":
                steppersPage = homePage.selectSteppers();
                break;
            case "Picker View":
                pickerViewPage = homePage.selectPickerView();
                break;
            default:
                throw new Exception("The "+menuOption+" option is not available in the Home menu");
        }

    }

    @And("I select {string} in the Alert Views screen")
    public void iSelectInTheAlertViewsScreen(String menuOption) throws Exception {
        switch (menuOption){
            case "Text Entry":
                alertViewsPage.clickTextEntry();
                break;
            default:
                throw new Exception("The "+menuOption+" option is not available in the Alert Views menu");
        }
    }

    @When("I fill the text label with {string}")
    public void iFillTheTextLabelWith(String entry) {
        alertViewsPage.fillTextLabel(entry);
    }

    @Then("I click to {string} the pop up")
    public void iClickToThePopUp(String actionPopUp) throws Exception {
        switch (actionPopUp){
            case "accept":
                alertViewsPage.clickAcceptPopUp();
                break;
            default:
                throw new Exception("The "+actionPopUp+" action is not available in the pop up");
        }
    }

    @And("I get the {string} message")
    public void iGetTheMessage(String statusMessage) throws Exception {
        switch (statusMessage){
            case "confirm":
                alertViewsPage.verifyConfirmMessage();
                break;
            default:
                throw new Exception("The "+statusMessage+" status is not available");
        }
    }

    @Then("I click on {string} button")
    public void iClickOnButton(String buttonName) throws Exception {
        switch (buttonName){
            case "confirm":
                alertViewsPage.clickConfirmButton();
                break;
            default:
                throw new Exception("The "+buttonName+" button is not available");
        }
    }

    @Then("I long press the increment in {string} field")
    public void iLongPressTheIncrementInField(String fieldName) throws Exception {
        switch (fieldName){
            case "Custom":
                steppersPage.longPressCustomIncrementBtn();
                break;
            default:
                throw new Exception("The "+fieldName+" field is not available");
        }
    }

    @Then("I scroll the {string} number to {int}")
    public void iScrollTheNumberTo(String numberColumn, int numberValue) {
        switch (numberColumn){
            case "first":
                pickerViewPage.setNumber1(String.valueOf(numberValue));
                break;
            case "second":
                pickerViewPage.setNumber2(String.valueOf(numberValue));
                break;
            case "third":
                pickerViewPage.setNumber3(String.valueOf(numberValue));
                break;

        }
    }

}
