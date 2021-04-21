package com.util;

import java.io.FileReader;
import java.util.Properties;

public class Configuration {

	public String BROWSER;
	
	public Configuration() {
		loadProperties();
	}
	
	public void loadProperties() {
		
		FileReader reader;
		final String FILE_PATH = Constants.ROOT_DIRECTORY + Constants.PROPERTIES_DIRECTORY;
		Properties prop = new Properties();
		try {
			reader = new FileReader(FILE_PATH);
			prop.load(reader);
			
			BROWSER = prop.getProperty(Constants.BROWSER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
