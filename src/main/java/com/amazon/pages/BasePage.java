/**
 * 
 */
package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.amazon.useraction.UserActions;

/**
 * 
 */
public class BasePage extends UserActions {
	
	// webdriver instances
	public WebDriver driver;
	
	// constructor
	public BasePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
