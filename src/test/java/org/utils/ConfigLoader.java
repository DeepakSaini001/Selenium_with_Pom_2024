package org.utils;

import java.util.Properties;

public class ConfigLoader {

	private final Properties properties;
	private static ConfigLoader configLoader;
	// we created a variable configLoader here and type of this variable is
	// ConfigLoader

	// SingleTon design pattern--- means it cannot be access outside of this class

	// Private constructor to prevent instantiation --- SingleTon Design patter
	// private---- constructor cannot be access outside of this class and only 1 instance can be created 
	private ConfigLoader() {

		properties = PropertyUnitls.propertyLoader(
				"//Users//deepaksaini//eclipse-workspace//Selenium_DS_POM_May2024//src//test//resources//config_CT.properties");
	}

	// Public method to provide access to the singleton instance
	// only 1 instance is created--- as it is a singleton class
	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}

		/*
		 * in If condition---if configLoader is null, that means there is no instance of
		 * this class, then we are creating a new instance of this class
		 * 
		 * and when this getInstance(), is called again it will not be null then no new instance
		 * object will be created
		 */
		return configLoader;
	}

	public String getBaseUrl() {
		String prop = properties.getProperty("baseurl");
		if (prop != null)
			return prop;
		else
			throw new RuntimeException("property baseURL is not specified in the config.properties file");

	}

}
