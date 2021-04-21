package com.test;

import com.base.BaseTest;
import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class E2ETest extends BaseTest {
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
    public void testAllPrices(String email,String pass) {
        _hp.navigateToURL();
        _hp.performSearch("qa testing for beginners");
        String priceFromSearchPage = _sp.getPriceOfFirstItem();
        _pdpp = _sp.selectFirstItem();
        String priceFromPDPPage = _pdpp.getPriceFromPDPPage();
        _pdpp.clickOnAddToCart();
        _lp = _pdpp.clickOnProceedToCheckOut();
        _cp = _lp.loginToCheckOut(email, pass);
        String finalPrice = _cp.getFinalPrice();
        Assert.assertEquals(priceFromSearchPage, priceFromPDPPage, "PDP Page Price in not matching");
        Assert.assertEquals(priceFromSearchPage, finalPrice, "Final price is not matching");
    }

    @AfterClass
    public void clearObj() {
        _hp = null;
        _sp= null;
    }

}
