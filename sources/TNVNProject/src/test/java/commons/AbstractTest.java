package commons;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import setupBase.SetupBase;

public class AbstractTest extends SetupBase {	

	public int randomData() {
		return new Random().nextInt(99999);
	}

	public void tearDown(AndroidDriver driver) {
		driver.close();
	}

	public boolean isControlDisplayed(MobileElement element) {
		return element.isDisplayed();
	}

	public boolean isControlSelected(MobileElement element) {
		return element.isSelected();
	}

	public boolean isControlEnabled(MobileElement element) {
		return element.isEnabled();
	}
	
	public MobileElement GetMobileElement(AndroidDriver driver, By byElement) {
		return (MobileElement) driver.findElement(byElement);
	}

	public void sendKeyToElement(AndroidDriver driver, By byElement, String value) {
		MobileElement elementFound = (MobileElement) driver.findElement(byElement);
		sendKeyToElement(driver, elementFound, value);
	}
	
	public void sendKeyToElement(AndroidDriver driver, MobileElement MobileElement, String value) {
		waitForElementVisible(driver, MobileElement);
		MobileElement.sendKeys(value);
	}
	
	public void clickToElement(AndroidDriver driver, By byElement) {
		MobileElement elementFound = (MobileElement) driver.findElement(byElement);
		clickToElement(driver, elementFound);
	}

	public void clickToElement(AndroidDriver driver, MobileElement element) {
		waitForElementClickable(driver, element);
		element.click();
	}
	
	public void clearToElement(AndroidDriver driver, By byElement) {
		MobileElement elementFound = (MobileElement) driver.findElement(byElement);
		clearToElement(driver, elementFound);
	}

	public void clearToElement(AndroidDriver driver, MobileElement element) {
		waitForElementVisible(driver, element);
		element.clear();
	}
	
	public void checkTheCheckbox(AndroidDriver driver, By byElement) {
		MobileElement elementFound = (MobileElement) driver.findElement(byElement);
		checkTheCheckbox(driver, elementFound);
	}

	public void checkTheCheckbox(AndroidDriver driver, MobileElement element) {
		waitForElementVisible(driver, element);
		element.click();
	}
	
	public MobileElement waitForElementVisible(AndroidDriver driver, By byElement) {
		MobileElement elementFound = (MobileElement) driver.findElement(byElement);
		return waitForElementVisible(driver, elementFound);
	}

	public MobileElement waitForElementVisible(AndroidDriver driver, MobileElement element) {
		MobileElement MobileElementFound = (MobileElement) GetWebDriverWait(driver, 50)
				.until(ExpectedConditions.visibilityOf(element));
		
		return MobileElementFound;
	}
	
	public MobileElement waitForElementClickable(AndroidDriver driver, By byElement) {
		System.out.println("driver : " + driver);
		
		MobileElement elementFound = (MobileElement) driver.findElement(byElement);
		
		System.out.println("elementFound : " + elementFound);
		
		return waitForElementClickable(driver, elementFound);
	}

	public MobileElement waitForElementClickable(AndroidDriver driver, MobileElement element) {
		MobileElement MobileElementFound = (MobileElement) GetWebDriverWait(driver, 30)
				.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
		
		return MobileElementFound;
	}

	private WebDriverWait GetWebDriverWait(AndroidDriver driver, long timeInSecond) {
		return new WebDriverWait(driver, timeInSecond);
	}
}
