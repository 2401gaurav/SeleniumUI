package com.TestCases;

import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.helper.BrowserType;

import com.pages.CartPage;
import com.pages.LoginPage;

public class TC_Automation {
	static WebDriver driver;
	public static FileOutputStream fileOut;
	public static HSSFSheet outputWorkSheet;
	public static int rowNumber;
	public static HSSFWorkbook workBook;
	
	static String AppURL = "http://Automationpractice.com";
	static LoginPage objLogin;
	static CartPage cartPage;
	
	@Parameters({ "browserType"})
	@BeforeClass
	public static void initialize(String browserType) {

		driver = BrowserType.launchBrowser(browserType, AppURL);
		objLogin = PageFactory.initElements(driver, LoginPage.class);
		cartPage = PageFactory.initElements(driver, CartPage.class);

	}
	@Test(priority = 0)
	public static void loginAndCheckoutFunctionality() throws Exception {

		objLogin.login("jetblue@grr.la", "jetblue");
		
		Assert.assertTrue(cartPage.checkout());
		System.out.println("Validate the Amount");
		Assert.assertTrue(cartPage.amount());
		System.out.println("Validate the Attribute");
		Assert.assertTrue(cartPage.attribute());
		System.out.println("Validate the Description");
		Assert.assertTrue(cartPage.description());
		System.out.println("Validate the Quantity");
		Assert.assertTrue(cartPage.quantity());
		
		
	}
	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
	
}
