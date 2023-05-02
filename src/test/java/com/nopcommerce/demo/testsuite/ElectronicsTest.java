package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElectronicsTest extends BaseTest {
    HomePage homePage = new HomePage();
    CellPhonePage cellPhonesPage = new CellPhonePage();
    ProductPage productPage = new ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    SignInPage signInPage = new SignInPage();
    RegisterPage registerPage = new RegisterPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        homePage.hoverOnElectronics();
        //1.2 Mouse Hover on “Cell phones” and click
        homePage.clickOnCellPhones();
        //1.3 Verify the text “Cell phones”
        Assert.assertEquals(cellPhonesPage.getCellPhonesText(), "Cell phones", "Cell phones text not displayed");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //Mouse Hover on “Electronics” Tab
        homePage.hoverOnElectronics();
        //Mouse Hover on “Cell phones” and click
        homePage.clickOnCellPhones();
        // Verify the text “Cell phones”
        Assert.assertEquals(cellPhonesPage.getCellPhonesText(), "Cell phones", "Cell phones text not displayed");
        //Click on List View Tab
        Thread.sleep(2000);
        cellPhonesPage.clickListTab();
        //Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        cellPhonesPage.clickOnNokiaLumia();
        //Verify the text “Nokia Lumia 1020”
        Assert.assertEquals(productPage.getNokiaLumiaText(), "Nokia Lumia 1020", "Nokia Lumia Text not displayed");
        //Verify the price “$349.00”
        Assert.assertEquals(productPage.getNokiaLumiaPrice(), "$349.00", "Price not $349.00");
        //Change quantity to 2
        productPage.clearQuantity();
        productPage.sendQuantity("2");
        // Click on “ADD TO CART” tab
        productPage.clickAddToCartNokia();
        // Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(2000);
        Assert.assertEquals(productPage.getSuccessfullyAddedMessage(), "The product has been added to your shopping cart", "Successfully added message not displayed");

        productPage.closeSuccessMessage();
        // Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        productPage.mouseHoverOnShoppingCart();
        productPage.clickOnGoToCart();
        //Verify the message "Shopping cart"
        Assert.assertEquals(shoppingCartPage.getShoppingCartMessage(), "Shopping cart", "Not on shopping cart");
        //Verify the quantity is 2
        Assert.assertEquals(shoppingCartPage.getQuantity(), "2", "Quantity not 2");
        // Verify the Total $698.00
        Assert.assertEquals(shoppingCartPage.getTotalPriceShoppingCart(), "$698.00", "Price not $698.00");
        // click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnTermsOfService();
        // Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckout();
        //Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals(signInPage.getWelcomeText(), "Welcome, Please Sign In!", "Welcome text not displayed");
        // Click on “REGISTER” tab
        signInPage.clickOnRegister();
        // Verify the text “Register”
        Assert.assertEquals(registerPage.getRegisterText(), "Register", "Register page not displayed");
        // Fill the mandatory fields
        Thread.sleep(2000);
        registerPage.enterFirstName("Hello");
        Thread.sleep(2000);
        registerPage.enterLastName("Patel");
        Thread.sleep(2000);
        registerPage.enterEmail("DPPatel123");
        Thread.sleep(2000);
        registerPage.enterPassword("AimHigh123");
        Thread.sleep(2000);
        registerPage.enterConfirmPassword("AimHigh123");
        Thread.sleep(2000);
        // Click on “REGISTER” Button
        registerPage.clickRegisterButton();
        // Verify the message “Your registration completed”
        Assert.assertEquals(registerPage.registrationCompleteMessage(), "Your registration completed", "Register message not displayed");
    }

}
