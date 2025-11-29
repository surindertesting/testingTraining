package pck;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 

public class Exceptions {

    WebDriver driver;

    // Set up method to initialize the WebDriver and maximize the window before each test
    @BeforeMethod
    public void setup() {
        // Specify the path to the EdgeDriver executable
        System.setProperty("webdriver.edge.driver", 
            "C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        // Initialize the EdgeDriver and maximize the window
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void tradeDepot(){
    	
    	
        try {
            // Open the website
            driver.get("https://tradedepot.co.nz");

            // Try to find the element and click it
            WebElement searchBox = driver.findElement(By.id("search_qry_new"));
            searchBox.click();

        } catch (NoSuchElementException e) {
            // Log the exception and rethrow it to fail the test
            System.out.println("Element not found: " + e.getMessage());
            throw e; // Re-throwing the exception to make the test fail
        }
    }

    // Tear down the WebDriver after each test
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
