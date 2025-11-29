
package pck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {
	
	WebDriver driver;
	
	@BeforeMethod

	public void setup() {

		 // Set path to EdgeDriver
        System.setProperty("webdriver.edge.driver", "C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        // Configure Edge to run headless
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        // ❌ FIX: You were creating a *local* driver variable instead of using the class one
        driver = new EdgeDriver(options);
    }
	
	@Test()
    public void upload() {
     
        // Navigate to example file upload page
        driver.get("https://the-internet.herokuapp.com/upload");

        // Locate the file input element
        WebElement uploadInput = driver.findElement(By.id("file-upload"));

        // Provide absolute path of the file to upload
        uploadInput.sendKeys("C:\\Users\\surinder.kumar\\Documents\\seleniumTraining\\seleniumProjects\\TrainingProjects\\trade\\utils\\example_screenshot.png");

        // Click the upload button
        driver.findElement(By.id("file-submit")).click();

        // Print confirmation text
        String message = driver.findElement(By.tagName("h3")).getText();
        System.out.println("Upload message: " + message);
	}
    	@AfterMethod
    	public void tearDown() {
 
       // driver.quit();
    }
}
