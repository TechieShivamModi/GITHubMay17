package com.webappsecurity.zero.kdf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Methods {
	
	WebDriver driver;
	
	public void openBrowser() {
		driver = new ChromeDriver();
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void setImplicitlyWait() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	public void openApplication(String url) {
		driver.get(url);
	}
	
	public void enterInTextbox(String locator, String locatorValue, String data) {
		switch (locator) {
		case "id":
			driver.findElement(By.id(locatorValue)).sendKeys(data);
			break;
		case "name":
			driver.findElement(By.name(locatorValue)).sendKeys(data);;
			break;
		case "cssSelector":
			driver.findElement(By.cssSelector(locatorValue)).sendKeys(data);
			break;
		default:
			break;
		}
	}
	
	public void clickButton(String locator, String locatorValue) {
		switch (locator) {
		case "id":
			driver.findElement(By.id(locatorValue)).click();
			break;
		case "name":
			driver.findElement(By.name(locatorValue)).click();
			break;
		case "cssSelector":
			driver.findElement(By.cssSelector(locatorValue)).click();
			break;
		default:
			break;
		}
	}
	
	public String getErrorMessage(String locator, String locatorValue) {
		switch (locator) {
		case "id":
			return driver.findElement(By.id(locatorValue)).getText();
		case "name":
			return driver.findElement(By.name(locatorValue)).getText();
		case "cssSelector":
			return driver.findElement(By.cssSelector(locatorValue)).getText();
		default:
			return "";
		}
	}
	
	public void closeApplication() {
		driver.close();
	}
	
}
