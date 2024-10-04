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
public class CartPage extends BasePage {

	// page objects
	@FindBy(xpath = "//span[@class='a-truncate-cut']")
	private WebElement itemInCart;

	// constructor
	public CartPage(WebDriver driver) {
		super(driver);
	}

	// page action methods
	public String getNameOfProductInCart() {
		return performGetInnerText(itemInCart);
	}
}
