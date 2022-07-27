package com.ijmeet.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	public static void main(String[] args) {
 		 
			String dir = System.getProperty("user.dir");
			System.out.println(dir);
	}
	public static String getProperty(String fileName, String key) {
		String dir = System.getProperty("user.dir");
		String value = "";
		try {
			FileInputStream fis = new FileInputStream(dir + fileName);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String getObject(String key) {
		return getProperty("/src/test/resources/ObjectRepository.properties", key);
	}

}
