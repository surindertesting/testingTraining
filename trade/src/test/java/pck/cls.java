package pck;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Iterator;


public class cls {


    WebDriver driver;
    
//Priyanka
    
    //Rishab

    @BeforeMethod

    public void setup() {

       System.setProperty("webdriver.edge.driver", "C:\\Users\\surinder.kumar\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        driver = new EdgeDriver();

    }


    @Test(dataProvider = "keywordData")

    public void searchGoogle(String keyword) throws InterruptedException {
    	
    	//Step-1 Open the Trade Depot url
        driver.get("https://tradedepot.co.nz/");
        
//        // Step-2 Input search data in search field and click on search button
//        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"search_query_new\"]"));
//        searchBox.sendKeys(keyword);
//     
//        // Step- 3 Click on Search Button
//        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"mr-header-desktopIS-container\"]/form/input"));
//        searchButton.click();
//        
//        // Step 4: Wait for results to load
//        Thread.sleep(3000);
//
//        // Step 5: Get the body text to analyze the result
//        String bodyText = driver.findElement(By.xpath("//*[@id='ss__facet--categories_hierarchy']/section/div/div[1]/a")).getText();
//        String expText = keyword;
//        
//        Assert.assertEquals(bodyText, expText, "Text validated and TC pass");
       
        
        
//        // Step 6: Assert the result
//        if (bodyText.contains("No products found")) {
//            System.out.println("No results found for keyword: " + keyword);
//            Assert.fail("Search failed: No products found for keyword: " + keyword);
//        } else if (bodyText.contains(keyword)) {
//            System.out.println("Valid results found for keyword: " + keyword);
//            Assert.assertTrue(true, "Search successful for keyword: " + keyword);
//        } else {
//            System.out.println("Results loaded, but keyword not matched in visible text: " + keyword);
//            Assert.fail("Search result unclear for keyword: " + keyword);
//        }
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {

           driver.quit();

        }

    }


    @DataProvider(name = "keywordData")
    public Object[][] getData() throws IOException {

        FileInputStream fis = new FileInputStream(new File("C:\\Users\\surinder.kumar\\Downloads\\testData.xlsx"));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows();
        Object[][] data = new Object[rowCount - 1][1]; // exclude header
        Iterator<Row> rows = sheet.iterator();
        rows.next(); // skip header
        int i = 0;
        while (rows.hasNext()) {
            Row row = rows.next();
            data[i][0] = row.getCell(0).getStringCellValue();
            i++;

        }
        workbook.close();
        fis.close();
        return data;

    }

}