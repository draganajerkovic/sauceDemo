package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage extends BasePage{
    private By menu=By.id("react-burger-menu-btn");
    private By logoutSidebar=By.id("logout_sidebar_link");

    private By loginButton=By.id("login-button");

    public LogoutPage(WebDriver driver, WebDriverWait driverWait){
        super(driver, driverWait);
    }

    //method for clicking on the logout button
    public void logout(){
        getDriver().findElement(menu).click();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        getDriver().findElement(logoutSidebar).click();
    }

    //confirmation that the login button is visible after logging out

    public boolean loginIsVisible(){
        return getDriver().findElement(loginButton).isDisplayed();
    }
}
