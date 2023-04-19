package stepDefinitions.ios;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ios.PhotosApp.PhotosAppPage;

import static stepDefinitions.Hooks.*;

public class PhotosAppSteps {

    PhotosAppPage photosAppPage = new PhotosAppPage(iOSDriver);
    @Given("I click on {string} option in Photos app")
    public void iClickOnOptionInPhotosApp(String menuOption) throws Exception {
        switch (menuOption){
            case "All Photos":
                photosAppPage.clickAllPhotosOption();
                break;
            case "Albums":
                photosAppPage.clickAlbumsOption();
                break;
            default:
                throw new Exception("The "+menuOption+" option is not available");
        }
    }

    @Then("I swipe the photos")
    public void iSwipeThePhotos() {
        photosAppPage.swipePhotos();
    }

    @And("I click on {string} button in Photos app")
    public void iClickOnButtonInPhotosApp(String buttonName) throws Exception {
        switch (buttonName){
            case "Back":
                iOSDriver.navigate().back();
                break;
            default:
                throw new Exception("The "+buttonName+" button is not available");
        }
    }
}
