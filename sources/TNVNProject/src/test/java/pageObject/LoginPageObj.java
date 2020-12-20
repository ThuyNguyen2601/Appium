package pageObject;

import org.openqa.selenium.WebElement;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import io.appium.java_client.android.AndroidDriver;
import pageUI.LoginPageUI;

public class LoginPageObj extends AbstractTest {
	private LoginPageUI loginPageUI;
	
	private AndroidDriver driverFirst;
	private AndroidDriver driverSecond;

	public LoginPageObj() throws Exception {
		try {
			loginPageUI = new LoginPageUI();
			
			driverFirst = super.initialization("4723", "1");
			driverSecond = super.initialization("4724", "2");
		} catch (Exception e) {
			System.out.println("LoginPageObj contructor error : " + e.getMessage());
			throw e;
		}
	}

	public HomePageObj login(String usernameTxt, String passwordTxt) throws Exception {
		waitForElementVisible(driverFirst, loginPageUI.usernameElement);
		sendKeyToElement(driverFirst, loginPageUI.usernameElement, usernameTxt);
		
		waitForElementVisible(driverFirst, loginPageUI.passwordElement);
		sendKeyToElement(driverFirst, loginPageUI.passwordElement, passwordTxt);
		
		waitForElementClickable(driverFirst, loginPageUI.btnLoginElement);
		clickToElement(driverFirst, loginPageUI.btnLoginElement);
		
		return PageGeneratorManager.getHomePageObj();
	}
}
