package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.time.Duration;

public class FileUploadTest {

    private static final String UPLOAD_FILE_PAGE_URL = "https://the-internet.herokuapp.com/upload";
    private static final String FILE_LOCATION = "src/test/resources/FileToUpload.txt";
    private static final String UPLOADED_FILE_NAME = "FileToUpload.txt";
    private static final By UPLOADED_FILE_LIST = By.id("uploaded-files");
    private static final By CHOOSE_FILE_BUTTON = By.id("file-upload");
    private static final By UPLOAD_BUTTON = By.id("file-submit");
    private static final By SUCCESSFUL_UPLOADING_TEXT = By.xpath("//h3[text()=\"File Uploaded!\"]");

    @Test (description = "Check that user can upload file and filename is correct.")
    public void uploadFile() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get(UPLOAD_FILE_PAGE_URL);
        driver.findElement(CHOOSE_FILE_BUTTON).sendKeys(new File(FILE_LOCATION).getAbsolutePath());
        driver.findElement(UPLOAD_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESSFUL_UPLOADING_TEXT));
        Assert.assertEquals(driver.findElement(UPLOADED_FILE_LIST).getText(), UPLOADED_FILE_NAME);
    }
}
