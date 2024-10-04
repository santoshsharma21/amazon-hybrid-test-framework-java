package com.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.base.BaseClass;
import com.amazon.pages.CartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.SearchedProductPage;

public class AddToCartTest extends BaseClass {

	// class instances
	private HomePage homePage;
	private SearchedProductPage searchedProductPage;
	private CartPage cartPage;

	@Test(groups = {"Master"})
	public void addProductToCartTest() {

			log.info("***** addProductToCartTest Started *****");
			homePage = new HomePage(driver);
			log.info("Product name entered for search");
			homePage.searchProduct("iPhone 15 Pro Max");
			searchedProductPage = homePage.clickSearchButton();
			searchedProductPage.clickSearchedProduct();
			cartPage = searchedProductPage.clickToAddProductToCart();
			String expectedProductName = "iPhone 15 Pro Max";
			String actualProductName = cartPage.getNameOfProductInCart();
			boolean flag = actualProductName.contains(expectedProductName);
			
			if(flag) {
				Assert.assertTrue(flag);
				log.info("Test Passed");
			} else {
				log.error("Test Failed");
				log.info("***** addProductToCartTest Ended *****");
				Assert.assertTrue(flag);
			}
		}

	}