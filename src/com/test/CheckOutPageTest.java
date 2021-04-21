package com.test;

import com.base.BaseTest;
import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckOutPageTest extends BaseTest {
    private static final String title = "Select Shipping Options - Amazon.com Checkout";
    HomePage _hp;
    SearchPage _sp;
    PdpPage _pdpp;
    LoginPage _lp;
    CheckOutPage _cp;

    @BeforeClass
    public void createObj() {
        _hp = new HomePage(driver);
        _sp = new SearchPage(driver);
    }

    @Test
    @Parameters({"email","passw"})
    public void testFinalPrice(String email, String passw) {
        _hp.navigateToURL();
        _hp.performSearch("qa testing for beginners");
        String priceFromSearchPage = _sp.getPriceOfFirstItem();
        _pdpp = _sp.selectFirstItem();
        _pdpp.getPriceFromPDPPage();
        _pdpp.clickOnAddToCart();
        _lp = _pdpp.clickOnProceedToCheckOut();
        _cp = _lp.loginToCheckOut(email, passw);
        String finalPrice = _cp.getFinalPrice();
        Assert.assertEquals(priceFromSearchPage, finalPrice,"Final price is not matching");
        Assert.assertEquals(_cp.getTitle(), title, "Checkout page is not matching");
    }

    @AfterClass
    public void clearObj() {
        _hp = null;
    }
//Amazon.com Shopping Cart
}
