package MortgageC;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class CalculateMortgageRate {
    //Instead of writing like the below multiple times we can declare these values on the global lvl to reduce the # of lines
    //        driver.findElement(By.id("homeval")).clear();
    //        driver.findElement(By.id("homeval")).sendKeys("300000");

    private final By HomeValueInputField = By.id("homeval");
    private final By DownPaymentInputField = By.id("downpayment");
    private final By RadioButton = By.name("param[downpayment_type]");
    private final By LoanAmountInputField = By.id("loanamt");
    private final By InterestRateField = By.id("intrstsrate");
    private final By LoanYearInputField = By.id("loanterm");
    private final By StartMonthDropDown = By.name("param[start_month]");

    //I'm declaring WebDriver & Select (Which is needed for any webpage dropdown)
    //If I declare on the global lvl I don't have to keep typing WebDriver driver = new driver, etc
    //or write Select select = new select
    WebDriver driver;
    Select select;

    @BeforeMethod
    public void browserInitialization() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
    }

    public void enterData() {
        // Enter Home Value '300000'
        // Clear the txt box first
        driver.findElement(HomeValueInputField).clear();
        driver.findElement(HomeValueInputField).sendKeys("300000");

        //This is a hard stop (it's not recommended, but it can be used to stop the script from a particular line)
 //       Thread.sleep(3000);

        //Enter down payment '60000'
        driver.findElement(DownPaymentInputField).clear();
        driver.findElement(DownPaymentInputField).sendKeys("60000");
        driver.findElement(RadioButton).click();

        //Enter loan amount '240000'
        driver.findElement(LoanAmountInputField).clear();
        driver.findElement(LoanAmountInputField).sendKeys("240000");

        //Enter interest rate '3%'
        driver.findElement(InterestRateField).clear();
        driver.findElement(InterestRateField).sendKeys("3");

        //Enter loan term 30 years
        driver.findElement(LoanYearInputField).clear();
        driver.findElement(LoanYearInputField).sendKeys("30");

        //Select the start date month 'Dec'
        //Select statement needs to be created whenever you work with a dropdown web element
        select = new Select(driver.findElement(StartMonthDropDown));
        select.selectByVisibleText("Dec");

        //Enter the year '2023'
        driver.findElement(By.id("start_year")).clear();
        driver.findElement(By.id("start_year")).sendKeys("2023");

        //Enter property tax '5000'
        driver.findElement(By.id("pptytax")).clear();
        driver.findElement(By.id("pptytax")).sendKeys("5000");

        //Enter PMI '0.5'
        driver.findElement(By.id("pmi")).clear();
        driver.findElement(By.id("pmi")).sendKeys(".5");

        //Enter HOI '1000'
        driver.findElement(By.id("hoi")).clear();
        driver.findElement(By.id("hoi")).sendKeys("1000");

        //Enter monthly hoa '100'
        driver.findElement(By.id("hoa")).clear();
        driver.findElement(By.id("hoa")).sendKeys("100");

        //Enter 'FHA' loan
        select = new Select(driver.findElement(By.name("param[milserve]")));
        select.selectByVisibleText("FHA");

        //Select Buy option
        select = new Select(driver.findElement(By.name("param[refiorbuy]")));
        select.selectByVisibleText("Buy");

    }


    @Test

    public void calculateMonthlyPayment() {

        // The below is an implicit wait.  This slows down the test & for 15 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        enterData();

        //Click on Calculate Button & run the Test
        driver.findElement(By.name("cal")).click();

        //Validate that the monthly payment is "//h3[text()='$1,611.85']"
        String expectedTotalMonthlyPayment = "$1,611.85";
        String formattedXpath = String.format("//h3[text()='%s']", expectedTotalMonthlyPayment);
        boolean present = driver.findElement(By.xpath(formattedXpath)).isDisplayed();

        //Validate that the total monthly payment is $1,611.85
        Assert.assertTrue(present,"Total Monthly Payment is presented");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
