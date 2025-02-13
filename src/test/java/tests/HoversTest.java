package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTest {
    @Test
    public void user1ProfileRedirectionTest() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);

        WebElement user1 = driver.findElement(By.xpath("//*[@class=\"figure\"][1]"));
        WebElement user1Name = driver.findElement(By.xpath("//h5[text()=\"name: user1\"]"));
        WebElement user1Link = driver.findElement(By.xpath("//a[@href=\"/users/1\"]"));
        action.moveToElement(user1).build().perform();
        Assert.assertTrue(user1Name.isDisplayed());
        user1Link.click();
        WebElement userProfileError = driver.findElement(By.xpath("//h1[text() =\"Not Found\"]"));
        Assert.assertFalse(userProfileError.isDisplayed());

        driver.close();
    }
    @Test
    public void user2ProfileRedirectionTest() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);

        WebElement user2 = driver.findElement(By.xpath("//*[@class=\"figure\"][2]"));
        WebElement user2Name = driver.findElement(By.xpath("//h5[text()=\"name: user2\"]"));
        WebElement user2Link = driver.findElement(By.xpath("//a[@href=\"/users/2\"]"));
        action.moveToElement(user2).build().perform();
        Assert.assertTrue(user2Name.isDisplayed());
        user2Link.click();
        WebElement userProfileError = driver.findElement(By.xpath("//h1[text() =\"Not Found\"]"));
        Assert.assertFalse(userProfileError.isDisplayed());

        driver.close();
    }
    @Test
    public void user3ProfileRedirectionTest() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);

        WebElement user3 = driver.findElement(By.xpath("//*[@class=\"figure\"][3]"));
        WebElement user3Name = driver.findElement(By.xpath("//h5[text()=\"name: user3\"]"));
        WebElement user3Link = driver.findElement(By.xpath("//a[@href=\"/users/3\"]"));
        action.moveToElement(user3).build().perform();
        Assert.assertTrue(user3Name.isDisplayed());
        user3Link.click();
        WebElement userProfileError = driver.findElement(By.xpath("//h1[text() =\"Not Found\"]"));
        Assert.assertFalse(userProfileError.isDisplayed());

        driver.quit();
    }
}
