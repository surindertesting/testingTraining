package pck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseMethodOverridding {
    WebDriver driver;

    // Base class method to open the browser
    public void openBrowser() {
        System.out.println("Opening a browser...");
    }

    public void closeBrowser() {
      driver.close();
    }
}
