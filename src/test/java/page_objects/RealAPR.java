package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RealAPR {
    private final By CalculatorTab = By.xpath("//label[1][text()='Calculator']");
    private final By HouseValueField = By.name("HomeValue");
    private final By DownPaymentInDollar = By.id("DownPaymentSel0");
    private final By DownPaymentField = By.name("DownPayment");
    private final By InterestRateField = By.name("Interest");
    private final By CalculateRateButton = By.name("calculate");
    private final By ActualAprRate = By.xpath("//strong[text()='Actual APR:']/../../td[2]/strong");

    private static final Logger LOGGER = LogManager.getLogger(RealAPR.class);

    public WebDriver driver;

    public RealAPR(WebDriver driver) {
        this.driver = driver;
    }

    public RealAPR waitForPageToLoad() {
        LOGGER.debug("Waiting for the Real Apr Page to load");
        ActOn.wait(driver, CalculatorTab).waitForElementTobeVisible();
        return this;
    }

    public RealAPR typeHomePrice(String value) {
        LOGGER.debug("Typing the home price: " + value);
        ActOn.element(driver, HouseValueField).setValue(value);
        return this;
    }

    public RealAPR clickDollarRadioButton() {
        LOGGER.debug("Selecting the $ radio button: ");
        ActOn.element(driver, DownPaymentInDollar).click();
        return this;
    }

    public RealAPR typeDownPayment(String value) {
        LOGGER.debug("Typing the down payment: " + value);
        ActOn.element(driver, DownPaymentField).setValue(value);
        return this;
    }

    public RealAPR typeInterestRate(String value) {
        LOGGER.debug("Typing the interest rate: " + value);
        ActOn.element(driver, InterestRateField).setValue(value);
        return this;
    }

    public RealAPR clickOnCalculate() {
        LOGGER.debug("Clicking on calculate rate button");
        ActOn.element(driver, CalculateRateButton).click();
        return this;
    }

    public RealAPR validateRealAprRate(String expectedAPRRate) {
        LOGGER.debug("Validate that the actual APR is: " + expectedAPRRate);
        String actualRealAprRate = ActOn.element(driver, ActualAprRate).getTextValue();
        Assert.assertEquals(actualRealAprRate, "3.130%");
        return this;
    }
}


