package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TyposTest {

    @Test
    public void checkTyposTest() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/typos");
        String secondParagraph = driver.findElement(By.xpath("//p[2]")).getText();
        String expectedText = "Sometimes you'll see a typo, other times you won't.";
        Assert.assertEquals(secondParagraph, expectedText);

        driver.quit();
    }
}
