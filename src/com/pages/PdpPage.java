package com.pages;

import com.base.BasePage;
import com.util.PageDriver;
import org.openqa.selenium.WebElement;

public class PdpPage extends BasePage {
    private static final String priceAtPdp = "//*[contains(text(),'Buy new:')]/parent::*/following-sibling::*";
    private static final String addToCartButton = "//input[@id='add-to-cart-button']";
    private static final String proceedToCheckOut = "//a[@id='hlb-ptc-btn-native']";

    public PdpPage(PageDriver driver) {
        super(driver);
    }


    public String getPriceFromPDPPage() {
        WebElement priceAtPdpElem = driver.findElement(priceAtPdp, "xpath");
        return priceAtPdpElem.getText();
    }
    public void clickOnAddToCart(){
        WebElement addToCart = driver.findElement(addToCartButton, "xpath");
        addToCart.click();
    }
    public LoginPage clickOnProceedToCheckOut(){
        WebElement addToCart = driver.findElement(proceedToCheckOut, "xpath");
        addToCart.click();
        return new LoginPage(driver);
    }

}
