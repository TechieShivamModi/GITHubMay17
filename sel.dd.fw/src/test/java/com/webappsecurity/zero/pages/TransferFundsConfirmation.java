package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsConfirmation {
	
	public TransferFundsConfirmation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.alert.alert-success")
	private WebElement confirmationText;
	
	@FindBy(css = "#settingsBox > ul > li:nth-child(3) > a")
	private WebElement settingsDropdown;

	@FindBy(id = "logout_link")
	private WebElement logout;
	
	public String getconfirmationText() {
		return confirmationText.getText();
	}
	
	public void logoutAccount() {
		settingsDropdown.click();
		logout.click();
	}

}
