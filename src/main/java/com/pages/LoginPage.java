package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	@CacheLookup
	WebElement email;

	@FindBy(how = How.XPATH, using = "//input[@id='passwd']")
	@CacheLookup
	WebElement password;

	@FindBy(how = How.XPATH, using = "//a[@class='login']")
	@CacheLookup
	WebElement SignIn;
	
	@FindBy(how = How.XPATH, using = "//p[@class='submit']//span[1]")
	@CacheLookup
	WebElement Submit;

	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String uname, String pwd) throws Exception {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='login']")));
		SignIn.click();
		
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		email.click();
		email.sendKeys(uname);
		password.click();
		password.sendKeys(pwd);
		Submit.click();
		System.out.println("Login is Successfull");

	}

}
