package com.selenium.utils;

import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	public static Properties loadProperties(String loadPropertiesFile) {
		Properties configuration = new Properties();
		InputStream input;
		try {
			input = Configuration.class.getClassLoader().getResourceAsStream(loadPropertiesFile);
			configuration.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return configuration;
	}
}
