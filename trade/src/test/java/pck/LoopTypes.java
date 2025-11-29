package pck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class LoopTypes {

    public static void main(String[] args) throws InterruptedException {

        // Set path to EdgeDriver
        System.setProperty("webdriver.edge.driver", "C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        // ===============================
        // FOR LOOP EXAMPLE Known number of iterations
        // ===============================
        driver.get("https://tradedepot.co.nz/");
        
        
        System.out.println("\n=== FOR LOOP EXAMPLE ===");

        // Click "Search" button 3 times using for loop
        for (int i = 1; i <= 4; i++) {
            driver.findElement(By.xpath("//*[@id=\"mr-header-desktopIS-container\"]/form/input")).click();
            Thread.sleep(2000);
            System.out.println("Clicked search button " + i + " time(s)");
        }

        Thread.sleep(2000); // small delay to observe

        // ===============================
        // FOR-EACH LOOP EXAMPLE Iterate over collections
        // ===============================
        System.out.println("\n=== FOR-EACH LOOP EXAMPLE ===");
        driver.get("https://tradedepot.co.nz/"); // simple page with some links

        // Get all links and print text
        List<WebElement> links = driver.findElements(By.tagName("nav"));
        for (WebElement link : links) {
            System.out.println("Link Text: " + link.getText());
        }

        Thread.sleep(2000);

        // ===============================
        // WHILE LOOP EXAMPLE Repeat until a condition becomes true
        // ===============================
        System.out.println("\n=== WHILE LOOP EXAMPLE ===");
        driver.get("https://tradedepot.co.nz/");

        // Click the Start button
        driver.findElement(By.xpath("//*[@id=\"mr-header-desktopIS-container\"]/form/input")).click();

        int seconds = 0;
        // Wait (up to 10 sec) for element to appear
        while (driver.findElements(By.xpath("//*[@id=\"main-content\"]/div[2]/h1/div/div")).isEmpty() && seconds < 10) {
            Thread.sleep(1000);
            seconds++;
            System.out.println("Waiting... " + seconds + " sec");
        }
        String resultText = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/h1/div/div")).getText();
        System.out.println("Result appeared: " + resultText);

        // ===============================
        // DO-WHILE LOOP EXAMPLE Must execute at least once
        // ===============================
        System.out.println("\n=== DO-WHILE LOOP EXAMPLE ===");
        
        driver.get("https://tradedepot.co.nz/");

        int count = 0;
        // Do-while: always executes at least once
        do {
            driver.findElement(By.xpath("//*[@id=\"mr-header-desktopIS-container\"]/form/input")).click();
            count++;
            System.out.println("Clicked on Search button " + count + " time(s)");
        } while (count < 2);

        // ===============================
        // Done
        // ===============================
        System.out.println("\n All loop examples executed successfully!");
        driver.quit();
    }
}
