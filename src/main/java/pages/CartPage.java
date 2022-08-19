package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{
    private By addToCartButtonSauceLabsBackpack=By.id("add-to-cart-sauce-labs-backpack");
    private By cartWithOneItem=By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");

    private By bikeLight=By.xpath("//*[@id=\"item_0_title_link\"]/div");
    private By addToCartButtonBikeLight=By.id("add-to-cart-sauce-labs-bike-light");
    private By cartBadge=By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    private By productNameBackpack=By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private By productNameBikeLight=By.xpath("//*[@id=\"item_0_title_link\"]/div");

    private By removeButtonBackpack=By.id("remove-sauce-labs-backpack");
    public CartPage(WebDriver driver, WebDriverWait driverWait){
        super(driver, driverWait);
    }


    //method for adding the initial product (backpack) to the cart
    public void addToCartBackpack(){
        getDriver().findElement(addToCartButtonSauceLabsBackpack).click();
    }

    //method to get the number of products shown on the cart badge
    public String numberCartBadge(){
        return getDriver().findElement(cartWithOneItem).getText();
    }


    //method for clicking on a bike light product and see the details
    public void clickOnBikeLight(){
        getDriver().findElement(bikeLight).click();
    }

    //method for clicking on add to cart for bike light
    public void addToCartBikeLight(){
        getDriver().findElement(addToCartButtonBikeLight).click();
    }

    //method for opening the cart
    public void openTheCart(){
        getDriver().findElement(cartBadge).click();
    }

    //confirmation that the items are in the cart
    public String confirmBackpack(){
        return getDriver().findElement(productNameBackpack).getText();
    }

    public String confirmBikeLight(){
        return getDriver().findElement(productNameBikeLight).getText();
    }


    //method for removing the first product from cart
    public void removeProduct(){
        getDriver().findElement(removeButtonBackpack).click();

    }
}
