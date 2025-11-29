package pck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class ConstructorTest {

    private WebDriver driver;
    private ContructorPage contructorPage; // Page object we will use

    // Constructor to initialize ContructorPage object (optional)
    public ConstructorTest(ContructorPage contructorPage) {
        this.contructorPage = contructorPage;
    }

    // Default constructor
    public ConstructorTest() {
        // empty
    }

    @BeforeClass
    public void setupClass() {
        // Initialize WebDriver
        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        // Initialize page object if not passed via constructor
        if (contructorPage == null) {
            contructorPage = new ContructorPage(driver);
        }
    }

    @Test
    public void searchGoogle() {
        contructorPage.openGoogle();                   // Use instance method
        contructorPage.search("Selenium WebDriver");  // Use instance method
        System.out.println("Search completed for: Selenium WebDriver");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
