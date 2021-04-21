package com.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.util.Configuration;
import com.util.PageDriver;

public abstract class BaseTest {

	public PageDriver driver;
	public static final Configuration _config;
	
	static
	{
		_config = new Configuration();

	}
	
	@BeforeSuite
	public void setup()
	{
		driver = new PageDriver(_config);
	}
	
	@AfterSuite
	public void clear()
	{
		driver.quit();
	}
}
