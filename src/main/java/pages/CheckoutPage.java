package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage{
    private By checkoutButton=By.id("checkout");
    private By firstName=By.id("first-name");
    private By lastName=By.id("last-name");
    private By zipCode=By.id("postal-code");

    private By continueButton=By.id("continue");
    private By finishButton=By.id("finish");

    private By thankYouMessage=By.xpath("//*[@id=\"checkout_complete_container\"]/h2");

    public CheckoutPage(WebDriver driver, WebDriverWait driverWait){
        super(driver, driverWait);
    }

    public void clickCheckoutButton(){
        getDriver().findElement(checkoutButton).click();
    }

    public void enterFirstName(String firstName){
        getDriver().findElement(this.firstName).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        getDriver().findElement(this.lastName).sendKeys(lastName);
    }

    public void enterZipCode(String zipCode){
        getDriver().findElement(this.zipCode).sendKeys(zipCode);
    }

    public void clickContinue(){
        getDriver().findElement(continueButton).click();
    }

    //filling in the form and clicking checkout
    public void fillInForm(String firstName, String lastName, String zipCode){
        clickCheckoutButton();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterZipCode(zipCode);
        clickContinue();
    }

    public void clickFinish(){
        getDriver().findElement(finishButton).click();
    }

    //confirmation message Thank you after the purchase
    public String thankYouConfirmation(){
        return getDriver().findElement(thankYouMessage).getText();
    }
}
