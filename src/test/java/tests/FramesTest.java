package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest {

    private static final String IFRAME_PAGE_URL = "https://the-internet.herokuapp.com/iframe";

    @Test (description = "Check that text in frame is correct.")
    public void getTextFromFrame() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get(IFRAME_PAGE_URL);
        driver.switchTo().frame("mce_0_ifr");
        Assert.assertEquals(driver.findElement(By.id("tinymce")).getText(), "Your content goes here.");

        driver.quit();
    }
}
