package pck;

import java.nio.file.*;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;

public class DownloadFile {

    private WebDriver driver;
    
    private final String downloadPath = "C:\\Users\\surinder.kumar\\Documents\\seleniumTraining\\seleniumProjects\\TrainingProjects\\trade\\downloads";

    @BeforeMethod
    public void setup() throws Exception {
        // Set up EdgeDriver path
        System.setProperty("webdriver.edge.driver", "C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        // Make sure the download folder exists
        Files.createDirectories(Paths.get(downloadPath));

        // Configure Edge to download files automatically
        EdgeOptions options = new EdgeOptions();
        options.setExperimentalOption("prefs", Map.of("download.default_directory", downloadPath,"download.prompt_for_download", false,"safebrowsing.enabled", true
        ));

        driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testFileDownload() throws Exception {
        driver.get("https://the-internet.herokuapp.com/download");

        // Click first file link
        WebElement fileLink = driver.findElement(By.cssSelector(".example a"));
        String fileName = fileLink.getText();
        fileLink.click();

        // Wait up to 30 seconds for the file to appear
        Path filePath = Paths.get(downloadPath, fileName);
        for (int i = 0; i < 30 && !Files.exists(filePath); i++) {
            Thread.sleep(1000);
        }

        // Print result
        if (Files.exists(filePath)) {
            System.out.println("✅ Download successful: " + filePath);
        } else {
            System.out.println("❌ File not downloaded within 30 seconds!");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
