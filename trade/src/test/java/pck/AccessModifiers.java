package pck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pck.GooglePage;

public class AccessModifiers {

    private WebDriver driver;

    @BeforeClass
    public void setupClass() {
    	System.setProperty("webdriver.edge.driver",
                "C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void testGoogleSearch() {
    	GooglePage google = new GooglePage(driver);
    	google.search("Selenium WebDriver");
     
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
