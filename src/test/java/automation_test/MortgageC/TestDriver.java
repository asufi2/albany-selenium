package automation_test.MortgageC;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDriver {

    // Expected title - Mortgage Calculator
    //url: https://www.mortgagecalculator.org/

    @Test
    public void verifyHomePageTitle() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        String expectedTitle = "Mortgage Calculator";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.quit();
    }
}
