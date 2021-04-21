package com.test;

import com.base.BaseTest;
import com.pages.HomePage;
import com.pages.PdpPage;
import com.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchPageTest extends BaseTest {
    HomePage _hp;
    SearchPage _sp;
    PdpPage _pdpp;
    private String title = "Amazon.com : qa testing for beginners";

    @BeforeClass
    public void createObj() {
        _hp = new HomePage(driver);
    }

    @Test
    public void testSearchPageTitle() {
        _hp.navigateToURL();
        _sp = _hp.performSearch("qa testing for beginners");
        Assert.assertEquals(_sp.getTitle(), title, "Search Page title not matching");
        _sp.getPriceOfFirstItem();
        _pdpp = _sp.selectFirstItem();
    }

    @AfterClass
    public void clearObj() {
        _hp = null;
    }
//Amazon.com : qa testing for beginners
}
