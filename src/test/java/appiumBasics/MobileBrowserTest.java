package appiumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest{

    @Test
    public void browserTest() throws InterruptedException {

        // To inspect the elements in this case, you should open the browser and change to the Mobile view inside the browser.
        // And inspect like you were inspecting a web element.


        driver.navigate().to("http://google.com");
//        System.out.println(driver.getTitle());



        driver.context("WEBVIEW_chrome");
        Thread.sleep(5000);

//        String declineButtonText = driver.findElement(By.xpath("//button[text()='No thanks']")).getText();
//        Assert.assertEquals(declineButtonText, "No thanks");
//
//        if (driver.findElement(By.cssSelector("button[data-dismiss='n']")).isDisplayed()){
//            driver.findElement(By.cssSelector("button[data-dismiss='n']")).click();
//        }

        driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
        driver.findElement(By.cssSelector("a[routerlink='/products']")).click();

        //scroll down
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");

        // The * in the expression href*='products/3' represents that the code will search for all href elements that contains products/3
        String product3text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
        Assert.assertEquals(product3text,"Devops");
    }

}
