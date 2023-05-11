package automation_test.MortgageC;


import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;

public class CalRealAprRate {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // The below two lines are needed after using the scripts from Command_providers
//        driver.get("https://www.mortgagecalculator.org/");
//        driver.manage().window().maximize();
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }


    @Test
    public void calculateRealApr() {
        new NavigationBar(driver)
                .mouseHoverToRates()
                .navigateToRealApr()
                .waitForPageToLoad()
                .typeHomePrice("200000")
                .clickDollarRadioButton()
                .typeDownPayment("15000")
                .typeInterestRate("3")
                .clickOnCalculate()
                .validateRealAprRate("3.130%");

    }


    @AfterMethod

    public void closeWebPage() {
        //This will close the tab that we are testing on
        // if we use driver.quit(); that will shut down chrome & close all tabs
    //    driver.close();
        ActOn.browser(driver).close();
    }
}