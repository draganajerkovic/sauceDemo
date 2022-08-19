package tests;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.time.Duration;

@Getter
public class BaseTests {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private BasePage basePage;
    private LoginPage loginPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private LogoutPage logoutPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.navigate().to("https://www.saucedemo.com/");


        basePage = new BasePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        cartPage = new CartPage(driver, driverWait);
        checkoutPage = new CheckoutPage(driver, driverWait);
        logoutPage = new LogoutPage(driver, driverWait);
    }


    @AfterClass
    public void afterClass(){
        driver.close();
    }
}
