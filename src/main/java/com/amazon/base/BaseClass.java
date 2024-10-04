/**
 * 
 */
package com.amazon.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.amazon.utilities.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 */
public class BaseClass {

	// webdriver instances
	public static WebDriver driver;
	
	// config reader instance
	private ConfigReader cfg;
	
	// instances
	public Logger log;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Master"})
	public void setupBrowser(String browser) {
		
		log = LogManager.getLogger(this.getClass());

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		// maximize window
		driver.manage().window().maximize();

		// delete cookies
		driver.manage().deleteAllCookies();

		// launch url
		cfg = new ConfigReader();
		driver.get(cfg.getUrl());
	}
	
	@AfterMethod(groups = {"Master"})
	public void teardownBrowser() {
		driver.quit();
	}
}
