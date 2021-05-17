package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user_login")
	private WebElement username;
	
	@FindBy(id = "user_password")
	private WebElement password;
	
	@FindBy(css = "input[type=submit]")
	private WebElement signIn;
	
	@FindBy(css = "div.alert.alert-error")
	private WebElement invalidLoginMessage;
	
	public void applicationLogin(String username, String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		this.signIn.click();
	}
	
	public String invalidLoginMessage() {
		return this.invalidLoginMessage.getText();
	}
}
