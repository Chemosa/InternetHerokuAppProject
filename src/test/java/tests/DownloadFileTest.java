package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

public class DownloadFileTest {

    private static final String DOWNLOAD_PAGE_URL = "https://the-internet.herokuapp.com/download";
    private static final String FILE_TO_DOWNLOAD_NAME = "random_data.txt";
    private static final String FILE_TO_DOWNLOAD_PATH = "//a[text()='%s']";

    @Test (description = "Check that file can be downloaded and present in user directory")
    public void downloadFile () throws InterruptedException {
        EdgeOptions options = new EdgeOptions();

        HashMap<String, Object> edgePreferences = new HashMap<>();
        edgePreferences.put("profile.default_content_settings.popups", 0);
        edgePreferences.put("download.default_directory", System.getProperty("user.dir"));
        options.setExperimentalOption("prefs", edgePreferences);
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver(options);
        driver.get(DOWNLOAD_PAGE_URL);
        driver.findElement(By.xpath(String.format(FILE_TO_DOWNLOAD_PATH, FILE_TO_DOWNLOAD_NAME))).click();

        Thread.sleep(5000);

        File userFolder = new File(System.getProperty("user.dir"));
        File[] filesInDirectory = userFolder.listFiles();
        File f = null;
        boolean found = false;
        for (File file : filesInDirectory) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (fileName.matches(FILE_TO_DOWNLOAD_NAME)) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }

        Assert.assertTrue(found);
        f.deleteOnExit();
        driver.quit();
    }
}
