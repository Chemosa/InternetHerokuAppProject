package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputsTest {

    @Test
    public void inputsTest() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/inputs");

        WebElement field = driver.findElement(By.tagName("input"));
        field.sendKeys("0");
        field.sendKeys(Keys.ARROW_UP);
        String actualResult = field.getDomProperty("value");
        Assert.assertEquals(actualResult, "1");
        field.sendKeys(Keys.ARROW_DOWN);
        field.sendKeys(Keys.ARROW_DOWN);
        actualResult = field.getDomProperty("value");
        Assert.assertEquals(actualResult, "-1");

        driver.quit();
    }
}
