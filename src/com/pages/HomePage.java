package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.base.BasePage;
import com.util.PageDriver;

import java.util.List;
import java.util.Optional;

public class HomePage extends BasePage {

    //locators
    private static final String searchBarById = "twotabsearchtextbox";
    private static final String searchButtonById = "nav-search-submit-button";


    public HomePage(PageDriver driver) {
        super(driver);
    }


    public SearchPage performSearch(String text) {
        WebElement searchBar = driver.findElement(searchBarById, "id");
        searchBar.sendKeys(text);
        WebElement searchButtonElement = driver.findElement(searchButtonById, "id");
        searchButtonElement.click();
        return new SearchPage(driver);
    }

    public void navigateToURL() {
        driver.get();
    }

	public String getPageTitle() {
    	return driver.getTitle();
	}
}
