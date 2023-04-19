package stepDefinitions.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.android.ApiDemos.*;
import stepDefinitions.Hooks;
import testUtils.Utils;

import java.io.IOException;
import java.time.Duration;

import static stepDefinitions.Hooks.*;

public class ApiDemosSteps{


    // Home page objects
    HomePage homePage = new HomePage(androidDriver);
    PreferencePage preferencePage;
    ViewsPage viewsPage;

    // Preference page objects
    PreferenceDependenciesPage preferenceDependenciesPage;

    // Views page objects
    DragAndDropPage dragAndDropPage;
    ExpandableListsPage expandableListsPage;

    // Expandable Lists page objects
    CustomAdapterPage customAdapterPage;

    @Given("I select {string} option in the Home menu")
    public void iSelectOptionInTheHomeMenu(String homeMenu) throws Exception {
        switch (homeMenu){
            case "Preference":
                preferencePage = homePage.clickPreferenceOption();
                break;
            case "Views":
                viewsPage = homePage.clickViewsOption();
                break;

            default:
                throw new Exception("The "+homeMenu+" option is not available in the Home menu");
        }
    }

    @And("I select {string} in the Preference menu")
    public void iSelectInThePreferenceMenu(String preferenceMenu) throws Exception {
        switch (preferenceMenu){
            case "Preference Dependencies":
                preferenceDependenciesPage = preferencePage.clickPreferenceDependencies();
                break;
            default:
                throw new Exception("The "+preferenceMenu+" is not available in the Preference menu");
        }
    }

    @And("I select {string} in the Views menu")
    public void iSelectInTheViewsMenu(String viewsMenu) throws Exception {
        switch (viewsMenu){
            case "Drag and Drop":
                 dragAndDropPage = viewsPage.clickDragAndDrop();
                break;
            case "Expandable Lists":
                 expandableListsPage = viewsPage.clickExpandableLists();
                 break;
            default:
                throw new Exception("The "+viewsMenu+" option is not available in the Views menu");
        }
    }

    @And("I select the {string} checkbox")
    public void iSelectTheCheckbox(String checkboxName) throws Exception {
        switch (checkboxName){
            case "WiFi":
                preferenceDependenciesPage.clickWifiCheckbox();
                break;
            default:
                throw new Exception("The "+checkboxName+" checkbox is not available in the screen");
        }
    }

    @And("I rotate the device")
    public void iRotateTheDevice() {
        Hooks.deviceRotation();
    }

    @When("I click on Wifi Settings button")
    public void iClickOnWifiSettingsButton() {
        preferenceDependenciesPage.clickWifiSettings();
    }

    @When("I drag and drop the image")
    public void iDragAndDropTheImage() {
        dragAndDropPage.dragAndDropTheImage();
    }

    @When("I select {string} in the Expandable Lists menu")
    public void iSelectInTheExpandableListsMenu(String expandableListsMenu) throws Exception {
        switch (expandableListsMenu){
            case "Custom Adapter":
                customAdapterPage = expandableListsPage.clickCustomAdapter();
                break;
            default:
                throw new Exception("The "+expandableListsMenu+" option is not available in the Expandable Lists menu");
        }
    }

    @When("I copy the wifi name {string} and paste")
    public void iCopyTheWifiNameAndPaste(String wifiName) {
        if (isAndroid) {
            androidDriver.setClipboardText(wifiName);
            preferenceDependenciesPage.fillWifiName(androidDriver.getClipboardText());
        }
        else if (isIos){
            iOSDriver.setClipboardText(wifiName);
            preferenceDependenciesPage.fillWifiName(iOSDriver.getClipboardText());
        }

    }

    @And("Verify the alert title")
    public void verifyTheAlertTitle() {
        preferenceDependenciesPage.verifyAlertTitle();
    }

    @Then("I fill the WiFi Name as {string}")
    public void iFillTheWiFiNameAs(String wifiName) {
        preferenceDependenciesPage.fillWifiName(wifiName);
    }

    @Then("I verify the result message {string}")
    public void iVerifyTheResultMessage(String message) {
        dragAndDropPage.verifyResultMessage(message);
    }

    @Then("I validate the {string} title")
    public void iValidateTheTitle(String titleName) throws Exception {
        switch (titleName){
            case "Sample menu":
                customAdapterPage.validateSampleMenuTitle();
                break;
            default:
                throw new Exception("The "+titleName+" title is not available in the screen");
        }
    }

    @Then("I back to Home page of Android")
    public void iBackToHomePageOfAndroid() {
        if (isAndroid){
            androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
            androidDriver.pressKey(new KeyEvent(AndroidKey.HOME));
        }
    }
}
