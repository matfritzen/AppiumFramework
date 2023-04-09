package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.android.ApiDemos.HomePage;

import java.io.IOException;

public class ApiDemosSteps{


    HomePage homePage = new HomePage(Hooks.androidDriver);

    @Given("I select {string} option in the Home menu")
    public void iSelectOptionInTheHomeMenu(String arg0) throws IOException {
        System.out.println("test");
    }

    @And("I select {string} in the Preference menu")
    public void iSelectInThePreferenceMenu(String arg0) {
        System.out.println("test");
    }

    @And("I select the {string} checkbox")
    public void iSelectTheCheckbox(String arg0) {
        System.out.println("test");
    }

    @When("I click on {string} button")
    public void iClickOnButton(String arg0) {
        System.out.println("test");
    }

    @And("Verify the alert title")
    public void verifyTheAlertTitle() {
        System.out.println("test");
    }

    @Then("I fill the WiFi Name as {string}")
    public void iFillTheWiFiNameAs(String arg0) {
        System.out.println("test");
    }
}
