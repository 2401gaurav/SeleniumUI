package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//body[@id='my-account']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a[1]")
	@CacheLookup
	WebElement tShirt;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Faded Short Sleeve T-shirts')]")
	@CacheLookup
	WebElement product;

	@FindBy(how = How.XPATH, using = "//button[@name='Submit']")
	@CacheLookup
	WebElement addToCart;

	
	@FindBy(how = How.XPATH, using = "//div[@class='layer_cart_product col-xs-12 col-md-6']//h2[1]")
	@CacheLookup
	WebElement productSuccessfullMsg;
	
	@FindBy(how = How.XPATH, using = "//span[@id='layer_cart_product_title']")
	@CacheLookup
	WebElement productTitle;
	@FindBy(how = How.XPATH, using = "//span[@id='layer_cart_product_quantity']")
	@CacheLookup
	WebElement quantity;
	
	@FindBy(how = How.XPATH, using = "//span[@id='layer_cart_product_attributes']")
	@CacheLookup
	WebElement productAttributes;
	@FindBy(how = How.XPATH, using = "//span[@id='layer_cart_product_price']")
	@CacheLookup
	WebElement amount;
	
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkout() throws Exception {
		WebDriverWait webDriverWait = null;
		 webDriverWait = new WebDriverWait(driver, 20);
	
	
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body[@id='my-account']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a[1]")));
		tShirt.click();

		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]")));
		product.click();

		webDriverWait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='Submit']")));
		addToCart.click();
		System.out.println("Add to Cart page is visible");
		webDriverWait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2[1]")));
		return productSuccessfullMsg.isDisplayed();

	}
	public boolean description() {
		return productTitle.isDisplayed();
	}
	
	public boolean attribute() {
		return productAttributes.isDisplayed();
	}
	public boolean quantity() {
		return quantity.isDisplayed();
	}
	public boolean amount() {
		return amount.isDisplayed();
	}

}
