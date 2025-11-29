package pck;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class MethodOverloading {

    WebDriver driver;

    // This method will run before any test method, setting up the WebDriver
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver", 
                "C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @Test
    // This is the main test where we call all overloaded methods
    public void testOpenGoogle() {
        openGoogle();                  // Default method (opens Google with default window size)
        openGoogle(1024, 768);          // Overloaded method (opens Google with a custom size)
        openGoogle(true);               // Overloaded method (opens Google and maximizes the window)
    }

    // Overloaded method 1: Open Google without any window size options (default size)
    public void openGoogle() {
        driver.get("https://www.google.com");
        System.out.println("Google opened with default window size.");
    }

    // Overloaded method 2: Open Google with a specific window size (e.g., 1024x768)
    public void openGoogle(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));  // Setting a custom size
        driver.get("https://www.google.com");
        System.out.println("Google opened with window size: " + width + "x" + height);
    }

    // Overloaded method 3: Open Google and maximize the window
    public void openGoogle(boolean maximize) {
        driver.get("https://www.google.com");
        if (maximize) {
            driver.manage().window().maximize();
            System.out.println("Google opened with maximized window.");
        }
    }

    // Close the browser after the test
    @AfterClass
    public void tearDown() {
     //driver.close();
        }
}
