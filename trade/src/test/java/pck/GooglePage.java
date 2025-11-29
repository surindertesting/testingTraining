package pck;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GooglePage {

    private WebDriver driver;                   // private
    private By searchBox = By.name("q");        // private

    String lastSearchText;                      // default access variable

    public GooglePage(WebDriver driver) {       // public constructor
        this.driver = driver;
    }

    public void search(String text) {           // public method
        driver.get("https://www.google.com/");
        driver.findElement(searchBox).sendKeys(text + Keys.ENTER);
        lastSearchText = text;                  // store last search
    }   

    // default method
    void printLastSearch() {
        System.out.println("Last search text: " + lastSearchText);
    }

    protected By getSearchLocator() {           // protected method
        return searchBox;
    }
}
