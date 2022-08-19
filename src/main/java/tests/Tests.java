package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BaseTests{
    @Test(priority = 1)
    public void loginTest(){
        getLoginPage().userLogin("standard_user","secret_sauce");
        Assert.assertEquals(getLoginPage().confirmationText(), "PRODUCTS");
        Assert.assertTrue(getLoginPage().logoutPresent());
    }

    @Test(priority = 2)
    public void verifyCartBadge(){
        getCartPage().addToCartBackpack();
        Assert.assertEquals(getCartPage().numberCartBadge(), "1");
    }

    @Test(priority = 3)
    public void twoItemsInCart(){
        getCartPage().clickOnBikeLight();
        getCartPage().addToCartBikeLight();
        getCartPage().openTheCart();
        Assert.assertEquals(getCartPage().confirmBackpack(),"Sauce Labs Backpack");
        Assert.assertEquals(getCartPage().confirmBikeLight(),"Sauce Labs Bike Light");
    }

    @Test(priority = 4)
    public void removeOneItemFromCart(){
        getCartPage().removeProduct();
        Assert.assertEquals(getCartPage().confirmBikeLight(),"Sauce Labs Bike Light");
    }

    @Test(priority = 5)
    public void orderCompleted(){
        getCheckoutPage().fillInForm("David","Budd","123NDB");
        getCheckoutPage().clickFinish();
        Assert.assertEquals(getCheckoutPage().thankYouConfirmation(),"THANK YOU FOR YOUR ORDER");
    }

    @Test(priority = 6)
    public void logout(){
        getLogoutPage().logout();
        Assert.assertTrue(getLogoutPage().loginIsVisible());
    }
}
