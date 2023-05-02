package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuiteTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    ProductPage productPage = new ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    SignInPage signInPage = new SignInPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {

        homePage.hoverOnComputer();
        homePage.clickOnDesktop();
        desktopPage.sortByZtoA();

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // Click on Computer Menu.
        homePage.hoverOnComputer();
        // Click on Desktop
        homePage.clickOnDesktop();
        //Select Sort By position "Name: A to Z"
        desktopPage.sortByAtoZ();
        // Click on "Add To Cart"
        Thread.sleep(2000);
        desktopPage.addToCart();
        //Verify the Text "Build your own computer"
        Assert.assertEquals(productPage.getBuildYourOwnComputerText(), "Build your own computer", "Build your own computer text not displayed");
        // Select GHz Intel Pentium Dual-Core E2200" using Select class
        productPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");
        //Select "8GB [+$60.00]" using Select class.
        productPage.selectRAM("8GB [+$60.00]");
        //Select HDD radio "400 GB [+$100.00]"
        productPage.clickHDD();
        // Select OS radio "Vista Premium [+$60.00]"
        productPage.clickOS();
        // Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        productPage.clickTotalCommander();
        // Verify the price "$1,475.00"
        Assert.assertEquals(productPage.getTextActualPrice(), "$1,475.00", "Price is not $1,475.00");
        // Click on "ADD TO CARD" Button.
        productPage.clickAddToCartButton();
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Assert.assertEquals(productPage.getProductAddedToCartMessage(), "The product has been added to your shopping cart", "Product not added to cart");
        //After that close the bar clicking on the cross button.
        productPage.clickCloseButton();
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(2000);
        productPage.mouseHoverOnShoppingCart();
        Thread.sleep(2000);
        productPage.clickOnGoToCart();
        Thread.sleep(2000);
        // Verify the message "Shopping cart"
        Assert.assertEquals(shoppingCartPage.getShoppingCartMessage(), "Shopping cart", "Not on shopping cart");
        // Change the Qty to "2" and Click on "Update shopping cart"
        shoppingCartPage.clearQuantity();
        shoppingCartPage.sendQuantity("2");
        shoppingCartPage.clickOnUpdateShoppingCart();
        // Verify the Total"$2,950.00"
        Assert.assertEquals(shoppingCartPage.getTotalPriceShoppingCart(), "$2,950.00", "Price not $2,950.00");
        // click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnTermsOfService();
        //Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckout();
        // Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals(signInPage.getWelcomeText(), "Welcome, Please Sign In!", "Welcome text not displayed");
        //Click on “CHECKOUT AS GUEST” Tab
        signInPage.clickCheckoutAsGuest();
        // Fill the all mandatory field
        checkoutPage.sendFirstName("DP444");
        checkoutPage.sendLastName("Patel");
        checkoutPage.sendEmail("DP123");
        checkoutPage.selectCountryName("United Kingdom");
        checkoutPage.sendCityName("London");
        checkoutPage.sendAddressName("24,DanesGate");
        checkoutPage.sendPostCode("NW10 0UP");
        checkoutPage.sendPhoneNumber("014536273811");
        // Click on “CONTINUE”
        checkoutPage.clickContinue();
        // Click on Radio Button “Next Day Air($0.00)”
        checkoutPage.chooseShipping();
        // Click on “CONTINUE”
        checkoutPage.clickContinueFromShipping();
        // Select Radio Button “Credit Card”
        checkoutPage.selectPaymentTypeRadioButton();
        //click continue
        checkoutPage.clickContinueAfterPaymentMethod();
        // Select “Master card” From Select credit card dropdown
        checkoutPage.selectCardType("Master card");
        //Fill all the details
        checkoutPage.sendCardholderName("MRS DP Patel");
        checkoutPage.sendCardNumber("0309 0000 0000 0511");
        checkoutPage.selectExpiryMonth("05");
        checkoutPage.selectExpiryYear("2025");
        checkoutPage.sendCVVCode("724");
        // Click on “CONTINUE”
        checkoutPage.clickContinueAfterBilling();
        // Verify “Payment Method” is “Credit Card”
        Assert.assertEquals(checkoutPage.getTextPaymentMethod(), "Credit Card", "Payment method not credit card");
        //Verify “Shipping Method” is “Next Day Air”
        Assert.assertEquals(checkoutPage.getTextShippingMethod(), "Next Day Air", "Shipping method not Next Day Air");
        // Verify Total is “$2,950.00”
        Assert.assertEquals(checkoutPage.getTextExpectedTotalAmount(), "$2,950.00", "total not $2,950.00");
        // Click on “CONFIRM”
        checkoutPage.clickConfirm();
        // Verify the Text “Thank You”
        Assert.assertEquals(checkoutPage.getTextThankYou(), "Thank you", "thank you not displayed");
        // Verify the message “Your order has been successfully processed!”
        Assert.assertEquals(checkoutPage.getTextOrderSuccessfullyPlaced(), "Your order has been successfully processed!", "order success message not displayed");
        // Click on “CONTINUE”
        checkoutPage.clickContinueAfterOrderPlaced();
        // Verify the text “Welcome to our store”
        Assert.assertEquals(homePage.getWelcomeToOurStoreText(), "Welcome to our store", "Welcome text not displayed");
    }
}
