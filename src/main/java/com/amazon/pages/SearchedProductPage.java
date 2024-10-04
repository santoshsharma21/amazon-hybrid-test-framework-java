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
public class SearchedProductPage extends BasePage {

	// page objects
	@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal'][normalize-space()='Apple iPhone 15 Pro Max (1 TB) - Black Titanium']")
	private WebElement searchedProduct;

	@FindBy(xpath = "//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']")
	private WebElement addToCartBtn;

	@FindBy(xpath = "//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")
	private WebElement goToCartBtn;

	// constructor
	public SearchedProductPage(WebDriver driver) {
		super(driver);
	}

	// page action methods
	public void clickSearchedProduct() {
		performJavaScriptExeClick(searchedProduct, driver);
		Object[] handles = performGetWindowhandles(driver);
		driver.switchTo().window((String) handles[1]);
	}

	// page action methods
	public CartPage clickToAddProductToCart() {
		performJavaScriptExeClick(addToCartBtn, driver);
		performJavaScriptExeClick(goToCartBtn, driver);
		return new CartPage(driver);
	}
}
