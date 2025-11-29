package pck;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.*;

public class MoreKeywords {

    WebDriver driver;
    String excelPath = "C:\\Users\\surinder.kumar\\Downloads\\testDataMoreKeys.xlsx";

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @Test(dataProvider = "testdata")
    public void WampContactPage(String Name, String Email, String Phone, String Mess, String expectedResult, int rowIndex)
            throws InterruptedException, IOException {

        String actualText = "";
        String status = "";

        try {
            driver.get("https://wamptech.in/contact-us.html");
            driver.manage().window().maximize();
            
            // Take screenshot and store it as a file
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define destination file
            File destination = new File("C:\\Users\\surinder.kumar\\Documents\\seleniumTraining\\example_screenshot.png");

            // Copy screenshot to destination
            FileHandler.copy(screenshot, destination);

            WebElement name = driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div[1]/input"));
            WebElement email = driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div[2]/input"));
            WebElement phone = driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div[3]/input"));
            WebElement mess = driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div[4]/textarea"));

            JavascriptExecutor js = (JavascriptExecutor) driver;

            name.sendKeys(Name);
            js.executeScript("arguments[0].style.background='Lime'", name);
            Thread.sleep(1000);

            email.sendKeys(Email);
            js.executeScript("arguments[0].style.background='Lime'", email);

            phone.sendKeys(Phone);
            js.executeScript("arguments[0].style.background='Lime'", phone);

            mess.sendKeys(Mess);
            js.executeScript("arguments[0].style.background='Lime'", mess);

            driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div[5]/input")).click();
            Thread.sleep(2000);

            // Capture actual message from UI
            actualText = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td")).getText();

            // Compare Excel expected vs actual
            if (actualText.trim().equalsIgnoreCase(expectedResult.trim())) {
                status = "PASS";
            } else {
                status = "FAIL";
            }

        } catch (Exception e) {
            actualText = e.getMessage();
            status = "FAIL - Exception";
        } finally {
            // Write actual + status to Excel
            writeResultToExcel(rowIndex, actualText, status);
        }
    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }

    @DataProvider(name = "testdata")
    public Object[][] getData() throws IOException {
        FileInputStream fis = new FileInputStream(new File(excelPath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        Object[][] data = new Object[rowCount - 1][6]; // Now includes expectedResult + rowIndex
        DataFormatter formatter = new DataFormatter();
        Iterator<Row> rows = sheet.iterator();
        rows.next(); // Skip header
        int i = 0;

        while (rows.hasNext()) {
            Row row = rows.next();

            Cell Name = row.getCell(2);
            Cell Email = row.getCell(3);
            Cell Phone = row.getCell(4);
            Cell Mess = row.getCell(5);
            Cell Expected = row.getCell(6); // ✅ Expected Result column (F)

            data[i][0] = Name != null ? formatter.formatCellValue(Name).trim() : "";
            data[i][1] = Email != null ? formatter.formatCellValue(Email).trim() : "";
            data[i][2] = Phone != null ? formatter.formatCellValue(Phone).trim() : "";
            data[i][3] = Mess != null ? formatter.formatCellValue(Mess).trim() : "";
            data[i][4] = Expected != null ? formatter.formatCellValue(Expected).trim() : ""; // Expected result
            data[i][5] = i + 1; // Keep row index
            i++;
        }

        workbook.close();
        fis.close();
        return data;
    }

    // Write Actual Result & Status to Excel
    public void writeResultToExcel(int rowIndex, String actualResult, String status) throws IOException {
        FileInputStream fis = new FileInputStream(excelPath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(rowIndex + 0); // +1 because 1st row is header
        if (row == null)
            row = sheet.createRow(rowIndex + 0);

        Cell actualCell = row.createCell(7); // Column H → Actual Result
        actualCell.setCellValue(actualResult);

        Cell resultCell = row.createCell(8); // Column I → Pass/Fail
        resultCell.setCellValue(status);

        fis.close();

        FileOutputStream fos = new FileOutputStream(excelPath);
        workbook.write(fos);
        fos.close();
        workbook.close();

        System.out.println("Result written to Excel for Row: " + (rowIndex + 1));
    }
}
