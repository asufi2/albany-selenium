package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By MortgageCalculatorLogo = By.xpath("//a/img[@alt='Logo']");
    private final By RefinanceLink = By.linkText("Refinance");
    private final By RefinanceRateLink = By.linkText("Refi Calculator");

    private static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);

    public WebDriver driver;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    public NavigationBar mouseHoverToRates() {
        LOGGER.debug("Mouse hover to Rates Link");
        ActOn.element(driver, RatesLink).mouseHover();
        return this;
    }

    public RealAPR navigateToRealApr() {
        LOGGER.debug("Navigating to Real Apr Page");
        ActOn.element(driver, RealAprLink).click();
        return new RealAPR(driver);
    }

    public Home navigateToHome() {
        LOGGER.debug("Navigating to Home Page");
        ActOn.element(driver, MortgageCalculatorLogo).click();
        return new Home(driver);
    }

    public NavigationBar mouseHoverToRefi() {
        LOGGER.debug("Mouse hover to refinance link");
        ActOn.element(driver, RefinanceLink).mouseHover();
        return this;
    }

    public RefiCalculator navigateToRefiPage() {
        LOGGER.debug("Navigating to refinance mortgage page");
        ActOn.element(driver, RefinanceRateLink).click();
        return new RefiCalculator(driver);
    }

}
