package pck;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAnnotations {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver(); // ✅ Assign to class-level driver
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void tradeDepot() throws InterruptedException, IOException {
        driver.get("https://tradedepot.co.nz/");
        System.out.println("Opened Trade Depot home page in Test 1");
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void tradeDepot1() throws InterruptedException, IOException {
        driver.get("https://tradedepot.co.nz/");
        System.out.println("Opened Trade Depot home page in Test 2");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully");
        }
    }
}
