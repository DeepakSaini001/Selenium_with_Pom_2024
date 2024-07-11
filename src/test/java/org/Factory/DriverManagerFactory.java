package org.Factory;

import constants.DriverType;

public class DriverManagerFactory {

	public static DriverManager getManager(DriverType driverType) {

		switch (driverType) {
		case CHROME -> {
			return new ChromeDriverManager();
		}
		case FIREFOX -> {
			return new FireFoxDriverManager();
		}
		default -> throw new IllegalStateException("Invalid Driver" + " : " + driverType);
		}

	}

}