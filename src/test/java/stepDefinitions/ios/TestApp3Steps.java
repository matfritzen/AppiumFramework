package stepDefinitions.ios;

import io.cucumber.java.en.Given;
import pages.ios.TestApp3.TestAppPage;
import static stepDefinitions.Hooks.*;

public class TestApp3Steps {

    TestAppPage testAppPage = new TestAppPage(iOSDriver);

    @Given("I slide {string} the slider")
    public void iSlideTheSlider(String percentage) {
        testAppPage.setSlider(percentage);
    }

}
