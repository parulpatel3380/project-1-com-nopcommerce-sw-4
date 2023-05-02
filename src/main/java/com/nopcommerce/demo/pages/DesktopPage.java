package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class DesktopPage extends Utility {
    By sortBy = By.xpath("//select[@id='products-orderby']");
    By addToCartButton = By.xpath("//div[@data-productid='1']//button[text()='Add to cart']");

    public void sortByZtoA() {
        selectByVisibleTextFromDropDown(sortBy, "Name: Z to A");
    }

    public void sortByAtoZ() {
        selectByVisibleTextFromDropDown(sortBy, "Name: A to Z");
    }

    public void addToCart() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(addToCartButton);
    }
}
