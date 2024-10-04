/**
 * 
 */
package com.amazon.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * 
 */
public class TestUtils {
	
	// methor takes screenshot
	public static String captureScreen(String name, WebDriver driver) {
		String dt = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss").format(new Date());
		String fileName = name + dt;
		String destPath = System.getProperty("user.dir") + "/screenshots/" + fileName + ".png";
		
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File sourcePath = scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourcePath, new File(destPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destPath;
	}
}
