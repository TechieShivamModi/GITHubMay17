package com.webappsecurity.zero.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
	
	WebDriver driver;
	
	@BeforeClass
	public void openBrowser() {

		ChromeOptions capability = new ChromeOptions();
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		capability.setCapability(CapabilityType.SUPPORTS_LOCATION_CONTEXT, false);

		driver = new ChromeDriver(capability);
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
}
