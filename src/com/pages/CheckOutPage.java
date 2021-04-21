package com.pages;

import com.base.BasePage;
import com.util.PageDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage extends BasePage {
    private static final String finalPrice = "//div/span[@class='a-color-price']";
    private static final String deliverToAddress = "//div[@id='address-book-entry-0']//div[2]/span/a";

    public CheckOutPage(PageDriver driver) {
        super(driver);
    }

    public String getFinalPrice() {
        driver.findElement(deliverToAddress, "xpath").click();
        WebElement f_price = driver.findElement(finalPrice, "xpath");
        return f_price.getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
