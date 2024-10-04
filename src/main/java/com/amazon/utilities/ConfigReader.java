/**
 * 
 */
package com.amazon.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 */
public class ConfigReader {

	public Properties pro;

	public ConfigReader() {
		File path = new File(System.getProperty("user.dir") + "/configurations/config.properties");
		try {
			FileInputStream ip = new FileInputStream(path);
			pro = new Properties();
			pro.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getUrl() {
		return pro.getProperty("url");
	}
	
	public String getBrowserName() {
		return pro.getProperty("browser");
	}
	
	public int getWaitDuration() {
		return Integer.parseInt(pro.getProperty("wait_duration"));
	}
}