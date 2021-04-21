package com.pages;

import com.base.BasePage;
import com.util.PageDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(PageDriver driver) {
        super(driver);
    }
    private static final String email = "//input[@id='ap_email']";
    private static final String _continue = "//input[@id='continue']";
    private static final String password = "//input[@id='ap_password']";
    private static final String signIn = "//input[@id='signInSubmit']";

    public CheckOutPage loginToCheckOut(String username, String passw){
        driver.findElement(email, "xpath").sendKeys(username);
        driver.findElement(_continue, "xpath").click();
        driver.findElement(password, "xpath").sendKeys(passw);
        driver.findElement(signIn, "xpath").click();
        return new CheckOutPage(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
