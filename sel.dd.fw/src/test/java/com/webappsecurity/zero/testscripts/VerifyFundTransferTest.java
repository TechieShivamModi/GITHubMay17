package com.webappsecurity.zero.testscripts;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.webappsecurity.zero.pages.AccountSummary;
import com.webappsecurity.zero.pages.HomePage;
import com.webappsecurity.zero.pages.LoginPage;
import com.webappsecurity.zero.pages.TransferFunds;
import com.webappsecurity.zero.pages.TransferFundsConfirmation;
import com.webappsecurity.zero.pages.TransferFundsVerify;

import utils.GenericMethods;

public class VerifyFundTransferTest extends Base {

	@Test
	public void verifyFundTransfer() throws IOException {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		AccountSummary accountSummary = new AccountSummary(driver);
		TransferFunds transferFunds = new TransferFunds(driver);
		TransferFundsVerify transferFundsVerify = new TransferFundsVerify(driver);
		TransferFundsConfirmation transferFundsConfirmation = new TransferFundsConfirmation(driver);
		
		String[][] data = GenericMethods.getData("src/test/resources/testDataResources/TestDataFrameworksSelenium.xlsx", "Sheet 1");
		for(int i = 1; i < data.length;i++) {
			homePage.clickSignInButton();
			
			loginPage.applicationLogin(data[i][0], data[i][1]);
			accountSummary.clickTransferFunds();
			transferFunds.sendAmount(data[i][2], data[i][3]);
			transferFundsVerify.verifyTransfer();
			
			String actualConfirmationMsg = transferFundsConfirmation.getconfirmationText();
			String exepctedConfirmationMsg = data[i][4];
			
			System.out.println(exepctedConfirmationMsg);
			
			AssertJUnit.assertEquals(actualConfirmationMsg, exepctedConfirmationMsg);
			
			transferFundsConfirmation.logoutAccount();
			
		}
		
	}

}
