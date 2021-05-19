package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {
	
	@Test
	public void verifyInvalidLogin() throws IOException{
		
		Methods method = new Methods();
		String[][] data = GenericMethods.getData("src/test/resources/testDataResources/KeywordDrivenDevelopment.xlsx", "Sheet 1");
		
		for(int i=1;i<data.length;i++) {
			switch (data[i][3]) {
			case "openBrowser":
				method.openBrowser();
				break;
			case "maxWindow":
				method.maximizeWindow();
				break;
			case "implicitlyWait":
				method.setImplicitlyWait();
				break;
			case "openApp":
				method.openApplication(data[i][6]);
				break;
			case "enterTextbox":
				method.enterInTextbox(data[i][4], data[i][5], data[i][6]);
				break;
			case "clickButton":
				method.clickButton(data[i][4], data[i][5]);
				break;
			case "verifyErrorMsg":
				String actualMsg = method.getErrorMessage(data[i][4], data[i][5]);
				String expectedMsg = data[i][6];
				Assert.assertEquals(actualMsg, expectedMsg);
				break;
			case "closeApp":
				method.closeApplication();
				break;
			default:
				break;
			}
		}
		
	}
	
}
