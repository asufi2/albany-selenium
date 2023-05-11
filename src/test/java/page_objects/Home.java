package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
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

    private static final Logger LOGGER = LogManager.getLogger(Home.class);

    public WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public Home typeHomePrice(String value) {
        LOGGER.debug("Typing the home price: " + value);
        ActOn.element(driver, HomeValueInputField).setValue("300000");
        return this;
    }

    public Home typeDownPayment(String value) {
        LOGGER.debug("Typing the down payment: " + value);
        ActOn.element(driver, DownPaymentInputField).setValue(value);
        return this;
    }

    public Home clickOnDownPaymentInDollar() {
        LOGGER.debug("Clicking on the $ radio button");
        ActOn.element(driver, RadioButton).click();
        return this;
    }

    public Home typeLoanAmount(String value) {
        LOGGER.debug("Typing the loan amount: " + value);
        ActOn.element(driver, LoanAmountInputField).setValue(value);
        return this;
    }

    public Home typeInterestRate(String value) {
        LOGGER.debug("Typing the interest rate: " + value);
        ActOn.element(driver, InterestRateField).setValue(value);
        return this;
    }

    public Home typeLoanTermYears(String value) {
        LOGGER.debug("typing the loan terms: " + value);
        ActOn.element(driver, LoanYearInputField).setValue(value);
        return this;
    }

    public Home selectMonth(String month) {
        LOGGER.debug("Selecting the start month: " + month);
        ActOn.element(driver, StartMonthDropDown).selectValue(month);
        return this;
    }

    public Home typeYear(String year) {
        LOGGER.debug("Typing the start year: " + year);
        ActOn.element(driver, StartYear).setValue(year);
        return this;
    }

    public Home typePropertyTax(String value) {
        LOGGER.debug("Typing the property tax: " + value);
        ActOn.element(driver, PropertyTaxField).setValue(value);
        return this;
    }

    public Home typePmi(String value) {
        LOGGER.debug("Typing the PMI: " + value);
        ActOn.element(driver, PmiField).setValue(value);
        return this;
    }

    public Home typeHoi(String value) {
        LOGGER.debug("Typing the HOI: " + value);
        ActOn.element(driver, HoiField).setValue(value);
        return this;
    }

    public Home typeHoa(String value) {
        LOGGER.debug("Typing the HOA: " + value);
        ActOn.element(driver, HoaField).setValue(value);
        return this;
    }

    public Home selectLoanType(String value) {
        LOGGER.debug("Selecting the loan type: " + value);
        ActOn.element(driver, LoanTypeField).selectValue(value);
        return this;
    }

    public Home selectBuyOrRefiOption(String value) {
        LOGGER.debug("Selecting the BuyOrRefi option: " + value);
        ActOn.element(driver, BuyDropDown).selectValue(value);
        return this;
    }
    public Home clickOnCalculateButton() {
        LOGGER.debug("Clicking on Calculate Button");
        ActOn.element(driver, CalculateButton).click();
        return this;
    }

    public Home validateTotalMonthlyPayment(String expectedTotalMonthlyPayment) {
        String formattedXpath = String.format("//h3[text()='%s']", expectedTotalMonthlyPayment);
        By monthlyPayment = By.xpath(formattedXpath);

        LOGGER.debug("Validating that the total monthly payment is: " + expectedTotalMonthlyPayment);
        AssertThat.elementAssertions(driver, monthlyPayment).elementIsDisplayed();
        return this;
    }

}
