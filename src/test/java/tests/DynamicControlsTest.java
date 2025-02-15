package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class DynamicControlsTest {

    @Test (description = "Check that after click 'Remove' button checkbox is disappeared and correct message is displayed;" +
            "Check that initially input field is disabled, after click on 'Enable' button - enabled.")
    public void waitForRemoveOfCheckboxAndEnableOfInput() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()=\"Remove\"]")).click();
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's gone!"));
        int numberOfCheckboxes = driver.findElements(By.id("checkbox")).size();
        Assert.assertEquals(numberOfCheckboxes, 0);

        WebElement input = driver.findElement(By.xpath("//*[@type=\"text\"]"));
        Assert.assertFalse(input.isEnabled());

        driver.findElement(By.xpath("//button[text()=\"Enable\"]")).click();
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's enabled!"));
        Assert.assertTrue(input.isEnabled());

        driver.quit();
    }
}
