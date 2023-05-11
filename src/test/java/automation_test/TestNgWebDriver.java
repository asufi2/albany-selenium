package automation_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgWebDriver {
    WebDriver driver;

    @BeforeMethod
    public void browserInitialization() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://phptravels.com/demo");
    }

@Test
    // Expected title - Book Your Free Demo Now - Phptravels
    public void verifyHomePageTitle() {
        String expectedTitle = "Book Your Free Demo Now - Phptravels";
        String actualTitle = driver.getTitle();
        //Assert is used for validation.  It will check the actualtitle matches the expectedtile.
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void closeBrowser() {
        //close down Chrome window with driver.quit
        driver.quit();
    }
}
