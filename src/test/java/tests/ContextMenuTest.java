package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest {

    @Test (description = "Check that text in alert is correct.")
    public void getAlertText() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        Actions action = new Actions(driver);

        driver.get("https://the-internet.herokuapp.com/context_menu");
        action.contextClick(driver.findElement(By.id("hot-spot"))).build().perform();
        Alert alertFromContextMenu = driver.switchTo().alert();
        Assert.assertEquals(alertFromContextMenu.getText(), "You selected a context menu");
        alertFromContextMenu.accept();

        driver.quit();
    }
}
