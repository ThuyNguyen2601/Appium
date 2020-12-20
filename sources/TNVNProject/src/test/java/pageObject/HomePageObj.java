package pageObject;

import org.openqa.selenium.By;

import commons.AbstractTest;
import io.appium.java_client.android.AndroidDriver;
import pageUI.HomePageUI;
import pageUI.LoginPageUI;

public class HomePageObj extends AbstractTest {

	private HomePageUI homePageUI;

	private AndroidDriver driverFirst;
	private AndroidDriver driverSecond;

	public HomePageObj() throws Exception {
		homePageUI = new HomePageUI();

		driverFirst = super.initialization("4723", "1");
		driverSecond = super.initialization("4724", "2");
	}

	public void userAClickToAvatar() {
		waitForElementVisible(driverFirst, homePageUI.avaterImageElement);
		clickToElement(driverFirst, homePageUI.avaterImageElement);
	}

	public void userBClickToAvatar() {
		waitForElementVisible(driverSecond, homePageUI.avaterImageElement);
		clickToElement(driverSecond, homePageUI.avaterImageElement);
	}
}
