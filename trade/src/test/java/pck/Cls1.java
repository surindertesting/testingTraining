package pck;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

public class Cls1 {

	WebDriver driver;

	@BeforeMethod

	public void setup() {

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		driver = new EdgeDriver();

	}

	@Test()

	public void tradeDepot() throws InterruptedException, IOException {

		// Step-1 Open the Trade Depot url
		driver.get("https://tradedepot.co.nz/");

		// Take screenshot and store it as a file
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Define destination file
		File destination = new File("C:\\Users\\surinder.kumar\\Documents\\seleniumTraining\\seleniumProjects\\TrainingProjects\\trade\\screenshots\\example_screenshot.png");

		// Copy screenshot to destination
		FileHandler.copy(screenshot, destination);

		 // Create a FluentWait instance
	
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))      // Total wait time
                .pollingEvery(Duration.ofSeconds(5))       // Check every 5 seconds
                .ignoring(NoSuchElementException.class);   // Ignore if element not found

        // Wait for the element to become visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"s-fe0eeb25-b97f-48e2-bb34-481c8e858654\"]/div/h3")));
		
		// Get the text
		String actualText = driver.findElement(By.xpath("//*[@id=\"s-fe0eeb25-b97f-48e2-bb34-481c8e858654\"]/div/h3")).getText();

		// Expected text to validate
		String expText = "Current Deals";

		// If-Else condition implementation
		if (actualText.contains(expText)) {
			System.out.println("Text is present and TC is pass" + expText);
		} else {
			System.out.println("Text not present and TC is fail" + expText);

		}

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {

			driver.quit();

		}

	}

}