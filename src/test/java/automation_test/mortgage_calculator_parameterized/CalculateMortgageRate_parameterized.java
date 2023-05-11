package automation_test.mortgage_calculator_parameterized;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;
import utlities.DateUtils;
import utlities.ReadConfigFiles;
import utlities.SqlConnector;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CalculateMortgageRate_parameterized {
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
    private final By StartYear = By.id("start_year");
    private final By PropertyTaxField = By.id("pptytax");
    private final By PmiField = By.id("pmi");
    private final By HoiField = By.id("hoi");
    private final By HoaField = By.id("hoa");
    private final By LoanTypeField = By.name("param[milserve]");
    private final By FhaLoanSelection = By.id("FHA");
    private final By BuyDropDown = By.name("param[refiorbuy]");
    private final By BuySelect = By.id("Buy");
    private final By CalculateButton = By.name("cal");

    //I'm declaring WebDriver & Select (Which is needed for any webpage dropdown)
    //If I declare on the global lvl I don't have to keep typing WebDriver driver = new driver, etc
    //or write Select select = new select
    WebDriver driver;
    Select select;

    private static final Logger LOGGER = LogManager.getLogger(CalculateMortgageRate_parameterized.class);


    @BeforeMethod
    public void browserInitialization() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LOGGER.info("--------------Test Name: Calculate Monthly Payment---------------------");

        String browserUrl = ReadConfigFiles.getPropertyValues("Url");
        ActOn.browser(driver).openBrowser(browserUrl);
    }

// --------------------------------
// the below is used when POM(page object model) isn't used
// all the below code was removed because POM allowed us to use the elements from Home class

//    public void enterData() {
        // Enter Home Value '300000'
        // Clear the txt box first


        //ActOn.element(driver, HomeValueInputField).setValue("300000");

        //ActOn.element(driver, DownPaymentInputField).setValue("60000");
        //ActOn.element(driver, RadioButton).click();


        //ActOn.element(driver, LoanAmountInputField).setValue("240000");


        //ActOn.element(driver, InterestRateField).setValue("3");


        //ActOn.element(driver, LoanYearInputField).setValue("30");

        // This allows us to pull the current date from DateUtils & add 1 month, so we can make selecting month & year dynamic
        //String date = DateUtils.returnNextMonth();
        //String[] dates = date.split("-");
        //String month = dates[0];
        //String year = dates[1];
        //System.out.println(date);

        //Select the start date month 'Dec'
        //Select statement needs to be created whenever you work with a dropdown web element
        //ActOn.element(driver, StartMonthDropDown).selectValue(month);

        //Enter the year '2023'
        //ActOn.element(driver, StartYear).setValue(year);

        //Enter property tax '5000'
        //ActOn.element(driver, PropertyTaxField).setValue("5000");

        //Enter PMI '0.5'
        //ActOn.element(driver, PmiField).setValue(".5");

        //Enter HOI '1000'
        //ActOn.element(driver, HoiField).setValue("1000");

        //Enter monthly hoa '100'
        //ActOn.element(driver, HoaField).setValue("100");

        //Enter 'FHA' loan
        //ActOn.element(driver, LoanTypeField).selectValue("FHA");

        //Select Buy option
        //ActOn.element(driver, BuyDropDown).selectValue("Buy");

//    }


    @Test

    public void calculateMonthlyPayment() throws SQLException {
        String date = DateUtils.returnNextMonth();
        String[] dates = date.split("-");
        String month = dates[0];
        String year = dates[1];

        try {
            ResultSet rs = SqlConnector.readData("Select * from monthly_mortgage");
            while (rs.next()) {
                new NavigationBar(driver)
                        .navigateToHome()
                        .typeHomePrice(rs.getString("homevalue"))
                        .typeDownPayment(rs.getString("downpayment"))
                        .clickOnDownPaymentInDollar()
                        .typeLoanAmount(rs.getString("loanamount"))
                        .typeInterestRate(rs.getString("interestrate"))
                        .typeLoanTermYears(rs.getString("loanterm"))
                        .selectMonth(month)
                        .typeYear(year)
                        .typePropertyTax(rs.getString("propertytax"))
                        .typePmi(rs.getString("pmi"))
                        .typeHoi(rs.getString("homeownerinsurance"))
                        .typeHoa(rs.getString("monthlyhoa"))
                        .selectLoanType(rs.getString("loantype"))
                        .selectBuyOrRefiOption(rs.getString("buyorrefi"))
                        .clickOnCalculateButton()
                        .validateTotalMonthlyPayment(rs.getString("totalmonthlypayment"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }

// all the below code was added because POM allowed us to use the methods/elements from Home class
// doing the below allowed us to remove all the LoC from the @BeforeMethod

// The below isn't necessary because the values are being inputed via the SQL connector
//        new NavigationBar(driver)
//                .navigateToHome()
//                .typeHomePrice("300000")
//                .typeDownPayment("60000")
//                .clickOnDownPaymentInDollar()
//                .typeLoanAmount("240000")
//                .typeInterestRate("3")
//                .typeLoanTermYears("30")
//                .selectMonth(month)
//                .typeYear(year)
//                .typePropertyTax("5000")
//                .typePmi("0.5")
//                .typeHoi("1000")
//                .typeHoa("100")
//                .selectLoanType("FHA")
//                .selectBuyOrRefiOption("Buy")
//                .clickOnCalculateButton()
//                .validateTotalMonthlyPayment("$1,611.85");

// ----------------------------
// the below is used when POM(page object model) isn't used
// the above code is POM style so this is located on the Home class from the NavigationBar class
        //enterData();

        //Click on Calculate Button & run the Test
        //ActOn.element(driver, CalculateButton).click();

        //Validate that the monthly payment is "//h3[text()='$1,611.85']"
        //String expectedTotalMonthlyPayment = "$1,611.85";
        //String formattedXpath = String.format("//h3[text()='%s']", expectedTotalMonthlyPayment);

        // We need to create a By declaration so it can be called on
        //This allows us to no longer use the boolean or the assert.assertTrue
        //By monthlyPayment = By.xpath(formattedXpath);

        //Validate that the total monthly payment is $1,611.85
        //AssertThat.elementAssertions(driver, monthlyPayment).elementIsDisplayed();
//------------------------------
    }

    @AfterMethod
    public void quitBrowser() {
    LOGGER.info("---------End Test Case-------------");

        ActOn.browser(driver).close();
    }
}


