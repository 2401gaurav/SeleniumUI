package com.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author h.sengar
 *
 *         This class loads the different browsers
 */
public class BrowserType {

	static WebDriver driver;

	public static WebDriver launchBrowser() {
		
		return driver;
		
	}
	
	public static WebDriver launchBrowser(String broType, String url) {

		if (broType.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (broType.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\workspace\\AutomationStore\\src\\com\\helper\\IEDriverServer.exe");
			/*
			 * DesiredCapabilities capabilities =
			 * DesiredCapabilities.internetExplorer();
			 * capabilities.setCapability("ignoreProtectedModeSettings", true);
			 * capabilities.setCapability("ie.forceCreateProcessApi", true);
			 * capabilities.setCapability("ie.ensureCleanSession", true);
			 * capabilities.setCapability("ie.setProxyByServer", true);
			 */
		
			driver = new InternetExplorerDriver();
		}

		else if (broType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\helper\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}

		//driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);

		return driver;
	}
}
