package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import io.appium.java_client.MobileElement;
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
			//driverSecond = super.initialization("4724", "2");
		} catch (Exception e) {
			System.out.println("LoginPageObj contructor error : " + e.getMessage());
			throw e;
		}
	}

	public HomePageObj login(String usernameTxt, String passwordTxt) throws Exception {
		waitForElementVisible(driverFirst, (MobileElement) driverFirst.findElement(By.id(loginPageUI.usernameElement)));
		Thread.sleep(3000);
		sendKeyToElement(driverFirst, (MobileElement) driverFirst.findElement(By.id(loginPageUI.usernameElement)), usernameTxt);
		
		waitForElementVisible(driverFirst, loginPageUI.passwordElement);
		Thread.sleep(3000);
		sendKeyToElement(driverFirst, loginPageUI.passwordElement, passwordTxt);
		
		waitForElementClickable(driverFirst, loginPageUI.btnLoginElement);
		Thread.sleep(3000);
		clickToElement(driverFirst, loginPageUI.btnLoginElement);
		
		return PageGeneratorManager.getHomePageObj();
	}
	
	public void loginByOTP(String phoneNumber) throws Exception {
		System.out.println(">>> Wait btn");
		
		waitForElementClickable(driverFirst, loginPageUI.otpLoginButton);
		
		Thread.sleep(5000);
		
		System.out.println(">>> Click btn");
		
		clickToElement(driverFirst, loginPageUI.otpLoginButton);
		
		waitForElementVisible(driverFirst, loginPageUI.phoneNumberText);
		sendKeyToElement(driverFirst, loginPageUI.phoneNumberText, phoneNumber);
		
		waitForElementClickable(driverFirst, loginPageUI.confirmBtn);
		clickToElement(driverFirst, loginPageUI.confirmBtn);
		
		//return PageGeneratorManager.getHomePageObj();
	}
}
