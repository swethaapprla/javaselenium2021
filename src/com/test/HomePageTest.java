package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.HomePage;

public class HomePageTest extends BaseTest {

    HomePage _hp;
    private static final String title = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";

    @BeforeClass
    public void createObj() {
        _hp = new HomePage(driver);
    }

    @Test
    public void testSearchItem() {
        _hp.navigateToURL();
        Assert.assertEquals(_hp.getPageTitle(),title,"HomePage title not matched");
    }

    @AfterClass
    public void clearObj() {
        _hp = null;
    }
//Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more

}
