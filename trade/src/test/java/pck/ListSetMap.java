package pck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ListSetMap {

    WebDriver driver;

    // This method will run before any test method, setting up the WebDriver
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver", 
                "C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @Test
 //List implementation
//    public void openGoogle() {
//        driver.get("https://www.google.com");
//        List<WebElement> links = driver.findElements(By.tagName("a"));
//        List<String> linkTexts = new ArrayList<>();
//
//        for (WebElement link : links) {
//            linkTexts.add(link.getText());
//            
//            System.out.println(link.getText());
//        }
//
//    }
//Set implementation
//    public void openGoogle() {
//        driver.get("https://www.google.com");
//
//        // Find elements (example: all links on the page)
//        List<WebElement> elements = driver.findElements(By.tagName("a"));
//
//        // Store unique text values
//        Set<String> uniqueTexts = new HashSet<>();
//
//        for (WebElement element : elements) {
//            uniqueTexts.add(element.getText().trim());
//        }
//
//        // Optional: print the unique texts
//        for (String text : uniqueTexts) {
//            System.out.println(text);
//        }
//    }
    
//Map implementation
    public void loginTrade() {
    driver.get("https://tradedepot.co.nz/login.php");

 // Test data stored in a Map
 Map<String, String> data = new HashMap<>();
 data.put("username", "testuser");
 data.put("password", "1231231231");
 

 // Enter login credentials
 driver.findElement(By.id("login_email")).sendKeys(data.get("username"));
 driver.findElement(By.id("login_pass")).sendKeys(data.get("password"));
}


    // Close the browser after the test
    @AfterClass
    public void tearDown() {
     //driver.close();
        }
}
