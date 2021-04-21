package com.test;

import com.base.BaseTest;
import com.pages.HomePage;
import com.pages.PdpPage;
import com.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PdpPageTest extends BaseTest {

    HomePage _hp;
    SearchPage _sp;
    PdpPage _pdpp;

    @BeforeClass
    public void createObj() {
        _hp = new HomePage(driver);
    }

    @Test
    public void testPriceFromPDPPage() {
        _hp.navigateToURL();
        _hp.performSearch("qa testing for beginners");
        String priceFromSearchPage = _sp.getPriceOfFirstItem();
        _pdpp = _sp.selectFirstItem();
        String priceFromPDPPage = _pdpp.getPriceFromPDPPage();
        Assert.assertEquals(priceFromSearchPage, priceFromPDPPage);
        _pdpp.clickOnAddToCart();
        _pdpp.clickOnProceedToCheckOut();
    }

    @AfterClass
    public void clearObj() {
        _hp = null;
    }

}
