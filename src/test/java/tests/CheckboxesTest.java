package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest {

    @Test
    public void checkCheckboxTest() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.cssSelector("[type=checkbox]:nth-child(1)"));
        Assert.assertFalse(checkbox1.isSelected());
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());
        driver.close();
    }

    @Test
    public void uncheckCheckboxTest() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox2 = driver.findElement(By.cssSelector("[type=checkbox]:nth-child(3)"));
        Assert.assertTrue(checkbox2.isSelected());
        checkbox2.click();
        Assert.assertFalse(checkbox2.isSelected());
        driver.quit();
    }
}

