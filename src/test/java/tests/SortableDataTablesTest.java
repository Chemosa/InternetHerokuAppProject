package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class SortableDataTablesTest {

    @Test
    public void getDataFromTable() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<String> allCells = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 6; j++) {
                allCells.add(driver.findElement(By.xpath("//table//tr[" + i + "]//td[" + j + "]")).getText());
            }
        }
        Assert.assertEquals(allCells.get(0), "Smith");
        Assert.assertEquals(allCells.get(6), "Frank");
        Assert.assertEquals(allCells.get(12), "jdoe@hotmail.com");
        Assert.assertEquals(allCells.get(18), "$50.00");
        Assert.assertEquals(allCells.get(19), "http://www.timconway.com");

        driver.quit();
    }
}
