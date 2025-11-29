package pck;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class AccessBaseClass {

	
	//POM may be you need to use this class anywhere in the project
	
    // Protected variables accessible in child classes
//	private WebDriver driver;
//	
//	protected WebDriverWait wait;
	
    //Default access modifier
WebDriver driver;
WebDriverWait wait;
 
 
    // Default setup if child class doesn't pass driver
    @BeforeClass
    public void setupClass() {
        if (driver == null) {
            System.setProperty("webdriver.edge.driver",
                    "C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        
        
        }
    @Test
    public void google() {
    	driver.get("https://www.google.com/");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
