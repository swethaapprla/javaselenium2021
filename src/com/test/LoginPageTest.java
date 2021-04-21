package com.test;

import com.base.BaseTest;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PdpPage;
import com.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    private static final String title = "Amazon Sign-In";
    HomePage _hp;
    SearchPage _sp;
    PdpPage _pdpp;
    LoginPage _lp;

    @BeforeClass
    public void createObj() {
        _hp = new HomePage(driver);
    }

    @Test
    @Parameters({"email","passw"})
    public void testLoginPageTitle(String email, String passw) {
        _hp.navigateToURL();
        _hp.performSearch("qa testing for beginners");
        _sp.getPriceOfFirstItem();
        _pdpp = _sp.selectFirstItem();
        _pdpp.getPriceFromPDPPage();
        _pdpp.clickOnAddToCart();
        _lp = _pdpp.clickOnProceedToCheckOut();
        _lp.loginToCheckOut(email, passw);
        Assert.assertEquals(_lp.getTitle(), title, "LoginPage is Not matching");
    }

    @AfterClass
    public void clearObj() {
        _hp = null;
    }
//Amazon Sign-In
}
