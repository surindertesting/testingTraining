package pck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class subClassMethodOverridding  extends BaseMethodOverridding {

    // Override the openBrowser() method for Chrome
  @Test  @Override
    public void openBrowser() {
    	 // Specify the path to the EdgeDriver executable
        System.setProperty("webdriver.edge.driver", 
            "C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        // Initialize the EdgeDriver and maximize the window
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        
        // Open a website (for example, Google)
        driver.get("https://www.google.com");
  
    }
}
