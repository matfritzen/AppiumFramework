package appiumBasics;

import pages.android.ApiDemos.DragAndDropPage;
import pages.android.ApiDemos.HomePage;
import pages.android.ApiDemos.ViewsPage;
import testUtils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DragAndDropDemo extends AndroidBaseTest {

    @Test
    public void DragDropTest() throws IOException, InterruptedException {

        HomePage homePage = new HomePage(driver);
        ViewsPage viewsPage = homePage.clickViewsOption();
        DragAndDropPage dragAndDropPage = viewsPage.clickDragAndDrop();

        dragAndDropPage.dragAndDropTheImage();
        dragAndDropPage.verifyResultMessage("Dropped!");

    }
}
