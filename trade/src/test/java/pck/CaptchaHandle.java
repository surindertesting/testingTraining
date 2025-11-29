package pck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Scanner;

public class CaptchaHandle {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Set EdgeDriver path
        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @SuppressWarnings("resource")
	@Test
    public void handleCaptcha() throws InterruptedException {
        // Open CAPTCHA demo page
      //  driver.get("https://captcha.com/demos/features/captcha-demo.aspx");
    	driver.get("https://2captcha.com/demo/recaptcha-v2?utm_source=chatgpt.com");
     
//        // Pause for user to solve CAPTCHA manually
//        System.out.println("Please solve the CAPTCHA manually, then press Enter in the console...");
//        new Scanner(System.in).nextLine();
//        
//       // driver.findElement(By.id("captchaCode")).sendKeys(null)
//        // Click submit after solving CAPTCHA
//        driver.findElement(By.id("validateCaptchaButton")).click();
//
//        // Wait a few seconds to see the result
//        Thread.sleep(3000);
//
//        System.out.println("Form submitted. Page title: " + driver.getTitle());
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
        
     // Wait until captcha is solved (captcha element disappears)
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("captchaImage")));
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div/div[1]/section/div/form/div[2]/button[1]")));

        System.out.println("CAPTCHA solved → Submit button enabled.");
        
        
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
