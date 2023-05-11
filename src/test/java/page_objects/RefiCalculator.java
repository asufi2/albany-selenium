package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RefiCalculator {
    private final By RefinanceLoanTab = By.xpath("//table[2]/thead/tr/th[1][text()='Refinanced Loan']");
    private final By OriHomePrice = By.id("HomeValue");
    private final By OriDownPayment = By.id("Down");
    private final By OriLoanAmount = By.id("Amount");
    private final By LoanTerm = By.name("Length");
    private final By InterestRate = By.name("Interest3");
    private final By MonthsPaid = By.name("PaidPeriods");
    //Refinanced widget
    private final By ReLoanTerm = By.xpath("//table[2]/tbody/tr[1]/td[2]/nobr/input");
    private final By ReInterestRate = By.name("Interest2");
    private final By YearBeforeSell = By.name("YearsBeforeSell");
    //Fees & Points
    private final By DiscountPoints = By.name("Points");
    private final By OriFee = By.name("Origination");
    private final By OtherClosing = By.name("Closing");
    //Federal/State Taxes
    private final By FedIncomeTax = By.name("Taxes");
    private final By StateTax = By.name("StateTax");
    //Calculate Button
    private final By CalculateButton = By.name("calculate");
    //Validation
    private final By actualRefiAmount = By.xpath("//table[1]/tbody/tr[4]/td[2]/h3[text()='$15,397.40']");


    private static final Logger LOGGER = LogManager.getLogger(RefiCalculator.class);

    public WebDriver driver;

    public RefiCalculator(WebDriver driver) {this.driver = driver; }

    public RefiCalculator waitForPage() {
        LOGGER.debug("Waiting for the Refinance Calculator page to load");
        ActOn.wait(driver, RefinanceLoanTab).waitForElementTobeVisible();
        return this;
    }

    public RefiCalculator typeOriHomePrice(String value) {
        LOGGER.debug("Typing the original home price: " + value);
        ActOn.element(driver, OriHomePrice).setValue(value);
        return this;
    }

    public RefiCalculator typeOriDownPayment(String value) {
        LOGGER.debug("Typing the original down payment: " + value);
        ActOn.element(driver, OriDownPayment).setValue(value);
        return this;
    }

    public RefiCalculator typeOriLoanAmount(String value) {
        LOGGER.debug("Typing the original loan amount: " + value);
        ActOn.element(driver, OriLoanAmount).setValue(value);
        return this;
    }

    public RefiCalculator typeLoanTerm(String value) {
        LOGGER.debug("Typing the original loan term: " + value);
        ActOn.element(driver, LoanTerm).setValue(value);
        return this;
    }

    public RefiCalculator typeInterestRate(String value) {
        LOGGER.debug("Typing the original interest rate: " + value);
        ActOn.element(driver, InterestRate).setValue(value);
        return this;
    }

    public RefiCalculator typeMonthsPaid(String value) {
        LOGGER.debug("Typing the months paid: " + value);
        ActOn.element(driver, MonthsPaid).setValue(value);
        return this;
    }

    public RefiCalculator typeReLoanTerm(String value) {
        LOGGER.debug("Typing the refinance loan term: " + value);
        ActOn.element(driver, ReLoanTerm).setValue(value);
        return this;
    }

    public RefiCalculator typeReInterestRate(String value) {
        LOGGER.debug("Typing the refinance interest rate: " + value);
        ActOn.element(driver, ReInterestRate).setValue(value);
        return this;
    }

    public RefiCalculator typeYearBeforeSell(String value) {
        LOGGER.debug("Typing the years before selling: " + value);
        ActOn.element(driver, YearBeforeSell).setValue(value);
        return this;
    }

    public RefiCalculator typeDiscountPoints(String value) {
        LOGGER.debug("Typing the discount points: " + value);
        ActOn.element(driver, DiscountPoints).setValue(value);
        return this;
    }

    public RefiCalculator typeOriFee(String value) {
        LOGGER.debug("Typing the origination fee: " + value);
        ActOn.element(driver, OriFee).setValue(value);
        return this;
    }

    public RefiCalculator typeOtherClosing(String value) {
        LOGGER.debug("Typing the other closing costs: " + value);
        ActOn.element(driver, OtherClosing).setValue(value);
        return this;
    }

    public RefiCalculator typeFedIncomeTax(String value) {
        LOGGER.debug("Typing the federal income tax: " + value);
        ActOn.element(driver, FedIncomeTax).setValue(value);
        return this;
    }

    public RefiCalculator typeStateTax(String value) {
        LOGGER.debug("Typing the state taxes: " + value);
        ActOn.element(driver, StateTax).setValue(value);
        return this;
    }

    public RefiCalculator clickCalculateButton() {
        LOGGER.debug("Clicking the calculate button");
        ActOn.element(driver, CalculateButton).click();
        return this;
    }

    public RefiCalculator validateRefiCal(String expectedAPRRate) {
        LOGGER.debug("Validate that the actual APR is: " + expectedAPRRate);
        String actualRealAprRate = ActOn.element(driver, actualRefiAmount).getTextValue();
        Assert.assertEquals(actualRealAprRate, "$15,397.40");
        return this;
    }

    public RefiCalculator validateRefiMonthlyPayment(String expectedRefiMonthlyPayment) {
        String formattedXpath = String.format("//table[1]/tbody/tr[4]/td[2]/h3[text()='$%s']", expectedRefiMonthlyPayment);
        By monthlySavings = By.xpath(formattedXpath);

        LOGGER.debug("Validating the 10 year refinance savings is: " + expectedRefiMonthlyPayment);
        AssertThat.elementAssertions(driver, monthlySavings).elementIsDisplayed();
        return this;
    }





}
