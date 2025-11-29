package pck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContructorPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public ContructorPage(WebDriver driver) {
        this.driver = driver;
        // Initialize WebDriverWait for 10 seconds
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Open Google.com
    public void openGoogle() {
        try {
            driver.get("https://www.google.com/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search for a query
    public void search(String query) {
        try {
            // Wait until search box is visible
            WebElement searchBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.name("q"))
            );
            searchBox.sendKeys(query);
            searchBox.submit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
