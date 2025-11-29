package pck;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class TestsGrouping {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    // ====== SMOKE TEST ======
    @Test(groups = {"smoke"})
    public void openGoogle() {
        driver.get("https://www.google.com");
        System.out.println("Google opened: " + driver.getTitle());
    }

    // ====== REGRESSION TEST ======
    @Test(groups = {"regression"})
    public void openBing() {
        driver.get("https://www.bing.com");
        System.out.println("Bing opened: " + driver.getTitle());
    }

    // ====== SANITY TEST ======
    @Test(groups = {"sanity"})
    public void openDuckDuckGo() {
        driver.get("https://www.duckduckgo.com");
        System.out.println("DuckDuckGo opened: " + driver.getTitle());
    }

    // ====== TEST BELONGING TO MULTIPLE GROUPS ======
    @Test(groups = {"smoke", "regression"})
    public void openYahoo() {
        driver.get("https://www.yahoo.com");
        System.out.println("Yahoo opened: " + driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
     //  driver.close();
        }
    }

