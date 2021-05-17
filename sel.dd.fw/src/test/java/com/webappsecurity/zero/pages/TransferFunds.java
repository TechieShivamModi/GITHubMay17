package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFunds {
	
	public TransferFunds(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "tf_fromAccountId")
	private WebElement selectFromAccount;
	
	@FindBy(id = "tf_toAccountId")
	private WebElement selectToAccount;
	
	@FindBy(id = "tf_amount")
	private WebElement amountToSend;
	
	@FindBy(id = "tf_description")
	private WebElement description;
	
	@FindBy(id = "btn_submit")
	private WebElement btnContinue;
	
	public void sendAmount(String amount, String description) {
		this.amountToSend.sendKeys(amount);
		this.description.sendKeys(description);
		this.btnContinue.click();
	}
}
