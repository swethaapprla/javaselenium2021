package com.pages;

import com.base.BasePage;
import com.util.PageDriver;

public class SearchPage extends BasePage {
    private static final String priceFromSearch = "//span[@cel_widget_id='MAIN-SEARCH_RESULTS-2']//span[@class='a-price']/span[1]";//"//div[@data-index='2']//span[@class='a-price']/span[1]";

    public SearchPage(PageDriver driver) {
        super(driver);
    }

    public PdpPage selectFirstItem() {
        driver.clickWithJavaScriptExecutor(priceFromSearch, "xpath");
        return new PdpPage(driver);
    }
    public String getPriceOfFirstItem() {
        String theTextIWant = driver.getTextWithJavaScriptExecutor(priceFromSearch, "xpath");
        return theTextIWant;
    }
    public String getTitle() {
        return driver.getTitle();
    }
}
