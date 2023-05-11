package automation_test.mortgage_calculator_parameterized;


import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.NavigationBar;
import parameters.DataProviderClass;
import utlities.ReadConfigFiles;

public class CalRealAprRateParameterized {
    private static final Logger LOGGER = LogManager.getLogger(CalculateMortgageRate_parameterized.class);
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LOGGER.info("--------------Test Name: Calculate Real Apr Rate---------------------");

        String browserUrl = ReadConfigFiles.getPropertyValues("Url");
        ActOn.browser(driver).openBrowser(browserUrl);
    //    ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/"); --This line is removed because "Url" above has the actual url address from Database Connection Properties
    }


    @Test(dataProvider = "RealAprRates", dataProviderClass = DataProviderClass.class)
    public void calculateRealApr(String homePrice, String downPayment, String interestRate, String expectedApr) {
        new NavigationBar(driver)
                .mouseHoverToRates()
                .navigateToRealApr()
                .waitForPageToLoad()
                .typeHomePrice(homePrice)
                .clickDollarRadioButton()
                .typeDownPayment(downPayment)
                .typeInterestRate(interestRate)
                .clickOnCalculate()
                .validateRealAprRate(expectedApr);

    }


    @AfterMethod

    public void closeWebPage() {
        //This will close the tab that we are testing on
        // if we use driver.quit(); that will shut down chrome & close all tabs
    //    driver.close();
        LOGGER.info("--------------End Test: Calculate Real Apr Rate---------------------");
        ActOn.browser(driver).close();
    }
}