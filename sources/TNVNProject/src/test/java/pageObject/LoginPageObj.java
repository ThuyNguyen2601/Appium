package pageObject;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import io.appium.java_client.android.AndroidDriver;
import pageUI.LoginPageUI;

public class LoginPageObj extends AbstractTest{
	LoginPageUI loginPageUI = new LoginPageUI();
	
	
	public LoginPageObj(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public AndroidDriver driverFirst = initialization("4723", "1");
	public AndroidDriver driverSecond = initialization("4724", "2");
	
	public HomePageObj login(String usernameTxt, String passwordTxt) {
		waitForElementVisible(driverFirst, loginPageUI.usernameElement);
		sendKeyToElement(driverFirst, loginPageUI.usernameElement, usernameTxt);
		
		waitForElementVisible(driverFirst, loginPageUI.passwordElement);
		sendKeyToElement(driverFirst, loginPageUI.passwordElement, passwordTxt);
		
		waitForElementClickable(driverFirst, loginPageUI.btnLoginElement);
		clickToElement(driverFirst, loginPageUI.btnLoginElement);
		
		return PageGeneratorManager.getHomePageObj();
	}
	
}
