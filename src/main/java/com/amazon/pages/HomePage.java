/**
 * 
 */
package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 */
public class HomePage extends BasePage {

	// page objects
	@FindBy(id = "twotabsearchtextbox")
	private WebElement srchTxtBox;

	@FindBy(id = "nav-search-submit-button")
	private WebElement sbmtButton;

	// constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// page action methods
	public void searchProduct(String productName) {
		performSendKey(srchTxtBox, productName);
	}

	public SearchedProductPage clickSearchButton() {
		performClick(sbmtButton);
		return new SearchedProductPage(driver);
	}
}
