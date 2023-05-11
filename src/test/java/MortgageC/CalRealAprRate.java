package MortgageC;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.PublicKey;
import java.time.Duration;

public class CalRealAprRate {

    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By CalculatorTab = By.xpath("//label[1][text()='Calculator']");
    private final By HouseValueField = By.name("HomeValue");
    private final By DownPaymentInDollar = By.id("DownPaymentSel0");
    // Both DownPaymentField & InterestRateField have been globally declared, but never called
    // These actions were done manually in the script
    private final By DownPaymentField = By.name("DownPayment");
    private final By InterestRateField = By.name("Interest");
    private final By CalculateRateButton = By.name("calculate");
    private final By ActualAprRate = By.xpath("//strong[text()='Actual APR:']/../../td[2]/strong");

    WebDriver driver;


    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
    }

    public void navigateToRealAprRatePage() {
        //Mouse over to Rates Link
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(RatesLink)).perform();

        //Click on Real APR Link
        driver.findElement(RealAprLink).click();

        //Wait 5 seconds for the page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Validate that Calculator Tab is visible on the Real APR webpage
        wait.until(ExpectedConditions.visibilityOfElementLocated(CalculatorTab));

    }

    public void aprPageData() {
        //Another way to Validate that actual APR webpage is displayed
        String expectedPage = "Calculator";
        String formattedXpath = String.format("//label[1][text()='Calculator']", expectedPage);
        boolean present = driver.findElement(By.xpath(formattedXpath)).isDisplayed();

        //Validate that the Calculator Tab is displayed
        Assert.assertTrue(present, "Calculator");
        System.out.println("Real APR Page is displayed: " + expectedPage);

    }

    public void enterInfo() {

        //Enter 200000 for Home value
        driver.findElement(HouseValueField).clear();
        driver.findElement(HouseValueField).sendKeys("200000");

        //Enter $ radio button for Down Payment option
        driver.findElement(DownPaymentInDollar).click();

        //Enter 15000 for Down Payment
        driver.findElement(By.name("DownPayment")).clear();
        driver.findElement(By.name("DownPayment")).sendKeys("15000");

        //Enter Interest Rate 3%
        driver.findElement(By.name("Interest")).clear();
        driver.findElement(By.name("Interest")).sendKeys("3");

    }

    @Test

    public void calculateAprButton() {
        //No need to call openBrowser() again here in test, if you do it will just open up another page with mortagecalculator homepage
//        openBrowser();
        navigateToRealAprRatePage();
        aprPageData();
        enterInfo();


        //click on calculate button & verify results
        driver.findElement(CalculateRateButton).click();

        // The below is an implicit wait.  This slows down the test for 5 seconds so Real APR page loads
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Validate that the actual APR is '3.130%'
        String actualRealAprRate = driver.findElement(ActualAprRate).getText();
        Assert.assertEquals(actualRealAprRate, "3.130%");

    }


    @AfterMethod

    public void closeWebPage() {
        //This will close the tab that we are testing on
        // if we use driver.quit(); that will shut down chrome & close all tabs
    //    driver.close();
    }
}