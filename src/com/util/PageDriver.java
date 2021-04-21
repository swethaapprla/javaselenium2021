package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageDriver {

	private WebDriver driver;
	Configuration _config;
	
	public PageDriver(Configuration _config) {
		this._config = _config;
		initializeDriver();
	}
	
	private void initializeDriver() {
		String browser = _config.BROWSER;
		
		switch(browser) 
		{
		case "chrome" :
			driver = startChrome();
			break;
		case "firefox" :
			driver = startFireFox();
			break;
		default :
			driver = startIEDriver();
		}
	}

	private WebDriver startIEDriver() {
		return new InternetExplorerDriver();
	}

	private WebDriver startFireFox() {
		System.setProperty("webdriver.driver.chrome","drivers/geckodriver.exe");
		return new FirefoxDriver();
	}

	private WebDriver startChrome() {
		System.setProperty("webdriver.chrome.driver", Constants.ROOT_DIRECTORY+"/resources/drivers/chromedriver.exe");
		return new ChromeDriver();
	}

	public void quit()
	{
		driver.quit();
	}

	public WebElement findElement(String locator, String locatorType)
	{
		switch(locatorType) {
		
			case "id":
				return driver.findElement(By.id(locator));
			case "xpath":
				return driver.findElement(By.xpath(locator));
			case "css":
				return driver.findElement(By.cssSelector(locator));
			case "name":
				return driver.findElement(By.name(locator));
		}
		return null;

	}
	
	public void get() {
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public List<WebElement> findElements(String locator, String locatorType) {
		switch(locatorType) {
			case "id":
				return driver.findElements(By.id(locator));
			case "xpath":
				return driver.findElements(By.xpath(locator));
			case "css":
				return driver.findElements(By.cssSelector(locator));
			case "name":
				return driver.findElements(By.name(locator));
		}
		return null;
	}

	public String getTextWithJavaScriptExecutor(String locator,String locatorType) {
		return ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;", findElement(locator,locatorType)).toString();
	}
	public void clickWithJavaScriptExecutor(String locator,String locatorType) {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", findElement(locator,locatorType));
	}

	public String getTitle() {
		return driver.getTitle();
	}
}
