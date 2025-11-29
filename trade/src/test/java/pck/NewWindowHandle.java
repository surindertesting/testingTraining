package pck;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.Set;

public class NewWindowHandle {

	WebDriver driver;

	@BeforeMethod

	public void setup() {

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		driver = new EdgeDriver();

	}

	@Test()
	public void tradeDepot() throws InterruptedException, IOException {

	    // Step-1 Open the W3Schools URL
	    driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

	    // Switch to the iframe where the "Try it" button exists
	    driver.switchTo().frame("iframeResult");

	    // Step 2: Store current window handle BEFORE clicking
	    String mainWindow = driver.getWindowHandle();

	    // Step 3: Click the button that opens a new window
	    driver.findElement(By.tagName("button")).click();
	    Thread.sleep(2000); // small wait for new window to open

	    // Step 4: Switch to the new window
	    Set<String> allWindows = driver.getWindowHandles();
	    allWindows.remove(mainWindow); // remove main window, the rest is the new window
	    String newWindowHandle = allWindows.iterator().next();
	    driver.switchTo().window(newWindowHandle);

	    // Step 5: Do something in the new window
	    // Example: if it's a search field, just for demo
	    // Note: adjust XPath if the new page has different elements
	     driver.findElement(By.xpath("//*[@id=\"search2\"]")).sendKeys("test");
	     driver.findElement(By.xpath("//*[@id=\"learntocode_searchbtn\"]")).click();

	    // Step 6: Print new window details
	    System.out.println("New window URL: " + driver.getCurrentUrl());
	    System.out.println("New window title: " + driver.getTitle());

	    // Step 7: Close new window
	    driver.close();

	    // Step 8: Switch back to main window
	    driver.switchTo().window(mainWindow);
	    Thread.sleep(1000);
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {

			driver.quit();

		}

	}

}