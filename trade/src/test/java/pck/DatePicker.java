package pck;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DatePicker {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void selectPastDateDirect() {
        driver.get("https://www.globalsqa.com/demo-site/datepicker/");

        // Switch to iframe
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

        // Find the datepicker input
        WebElement dateInput = driver.findElement(By.id("datepicker"));

        // Directly send date as string (MM/DD/YYYY format)
        dateInput.clear();
        dateInput.sendKeys("03/15/2018"); // March 15, 2018

        System.out.println("Selected Date: " + dateInput.getAttribute("value"));
    }


    @AfterClass
    public void tearDown() {
     //  driver.close();
        }
    }
