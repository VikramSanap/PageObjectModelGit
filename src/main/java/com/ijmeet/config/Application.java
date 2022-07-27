package com.ijmeet.config;

import com.ijmeet.util.PropertiesFile;

public class Application {
	private static final String FILE_PATH ="\\src\\test\\resources\\application.properties";
	
	public String getBrowser() {
		return PropertiesFile.getProperty(FILE_PATH, "Iris.Browser");
	}

	public String getDevAppUrl() {
		return PropertiesFile.getProperty(FILE_PATH, "Iris.dev.app.url");
	}
	public String getQaAppUrl() {
		return PropertiesFile.getProperty(FILE_PATH, "Iris.qa.app.url");
	}

	public String getDbUrl() {
		return PropertiesFile.getProperty(FILE_PATH, "Iris.dev.db.url");
	}

	public String getUserName() {
		return PropertiesFile.getProperty(FILE_PATH, "Iris.dev.app.username");
	}

	public String getPassword() {
		return PropertiesFile.getProperty(FILE_PATH, "Iris.dev.app.pasword");
	}
}