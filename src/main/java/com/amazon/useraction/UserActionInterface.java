/**
 * 
 */
package com.amazon.useraction;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 */
public interface UserActionInterface {

	// click action
	public void performClick(WebElement element);
	
	// javascript click
	public void performJavaScriptExeClick(WebElement element, WebDriver driver);

	// sendKeys action
	public void performSendKey(WebElement element, String key);

	// drop-down action
	public void performSelectByVisibleText(WebElement element, String vlaue);

	// select value from list
	public void performSelectFromOption(List<WebElement> elements, String key);

	// return text from element
	public String performGetInnerText(WebElement element);

	// return current page url
	public String performGetCurrentPageUrl(WebDriver driver);
	
	// return array of windows handles
	public Object[] performGetWindowhandles(WebDriver driver);
	
	// return current handle
	public String performGetCurrentWindowhandle(WebDriver driver);
}
