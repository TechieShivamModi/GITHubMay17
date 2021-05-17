package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummary {
	
	public AccountSummary(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Transfer Funds")
	private WebElement transferFunds;
	
	@FindBy(css = "div.wrapper:nth-child(1) div.navbar.navbar-fixed-top div.navbar-inner div.container div:nth-child(2) ul.nav.float-right li.dropdown:nth-child(3) > a.dropdown-toggle")
	private WebElement usernameDropdown;
	
	public void clickTransferFunds() {
		transferFunds.click();
	}
	
	public String getProfileUser() {
		return usernameDropdown.getText();
	}
	
}
