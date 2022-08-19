package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    private By username=By.id("user-name");
    private By password=By.id("password");
    private By loginButton=By.id("login-button");
    private By productText=By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    private By menu=By.id("react-burger-menu-btn");
    private By logoutSidebar=By.id("logout_sidebar_link");

    public LoginPage(WebDriver driver, WebDriverWait driverWait){
        super(driver, driverWait);
    }

    public void enterUsername(String username){
        getDriver().findElement(this.username).sendKeys(username);
    }

    public void enterPassword(String password){
        getDriver().findElement(this.password).sendKeys(password);
    }

    public void clickLoginButton(){
        getDriver().findElement(loginButton).click();
    }

    //login form fill in method
    public void userLogin(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    //method for moving to products page
    public String confirmationText(){
        return getDriver().findElement(productText).getText();
    }

    //confirmation that the logout button is visible after logging in
    public boolean logoutPresent(){
        getDriver().findElement(menu).click();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        return getDriver().findElement(logoutSidebar).isDisplayed();
    }
}
