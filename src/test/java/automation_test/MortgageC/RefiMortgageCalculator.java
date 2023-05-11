package automation_test.MortgageC;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;

public class RefiMortgageCalculator {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }

    @Test
    public void calRefiMortgage() {
        new NavigationBar(driver)
                .mouseHoverToRefi()
                .navigateToRefiPage()
                .waitForPage()
                .typeOriHomePrice("320000")
                .typeOriDownPayment("60000")
                .typeOriLoanAmount("260000")
                .typeMonthsPaid("60")
                .typeLoanTerm("30")
                .typeInterestRate("5")
                .typeReLoanTerm("15")
                .typeReInterestRate("3.5")
                .typeYearBeforeSell("10")
                .typeDiscountPoints("2")
                .typeOriFee("0")
                .typeOtherClosing("2500")
                .typeFedIncomeTax("30")
                .typeStateTax("20")
                .clickCalculateButton()
                .validateRefiCal("15,397.40")
                .validateRefiMonthlyPayment("15,397.40");
    }

    //at 1:30 from week 11 POM

    @AfterMethod
    public void quitBrowser() {


        ActOn.browser(driver).close();
    }
}
