package pageObject;

import org.openqa.selenium.By;

import commons.AbstractTest;
import io.appium.java_client.android.AndroidDriver;
import pageUI.HomePageUI;

public class HomePageObj extends AbstractTest {
	HomePageUI homePageUI = new HomePageUI();
	
	public HomePageObj() {
		
	}
	
	public AndroidDriver driverFirst = initialization("4723", "1");
	public AndroidDriver driverSecond = initialization("4724", "2");
	
	public void userAClickToAvatar() {
		waitForElementVisible(driverFirst, homePageUI.avaterImageElement);
		clickToElement(driverFirst, homePageUI.avaterImageElement);
	}
	
	public void userBClickToAvatar() {
		waitForElementVisible(driverSecond, homePageUI.avaterImageElement);
		clickToElement(driverSecond, homePageUI.avaterImageElement);
	}

}
