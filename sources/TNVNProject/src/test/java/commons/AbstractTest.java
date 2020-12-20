package commons;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import setupBase.SetupBase;

public class AbstractTest extends SetupBase {	

	public int randomData() {
		return new Random().nextInt(99999);
	}

	public void tearDown(AndroidDriver driver) {
		driver.close();
	}

	public boolean isControlDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isControlSelected(WebElement element) {
		return element.isSelected();
	}

	public boolean isControlEnabled(WebElement element) {
		return element.isEnabled();
	}
	
	public WebElement GetWebElement(AndroidDriver driver, By byElement) {
		return driver.findElement(byElement);
	}

	public void sendKeyToElement(AndroidDriver driver, By byElement, String value) {
		WebElement elementFound = driver.findElement(byElement);
		sendKeyToElement(driver, elementFound, value);
	}
	
	public void sendKeyToElement(AndroidDriver driver, WebElement webElement, String value) {
		waitForElementVisible(driver, webElement);
		webElement.sendKeys(value);
	}
	
	public void clickToElement(AndroidDriver driver, By byElement) {
		WebElement elementFound = driver.findElement(byElement);
		clickToElement(driver, elementFound);
	}

	public void clickToElement(AndroidDriver driver, WebElement element) {
		waitForElementClickable(driver, element);
		element.click();
	}
	
	public void clearToElement(AndroidDriver driver, By byElement) {
		WebElement elementFound = driver.findElement(byElement);
		clearToElement(driver, elementFound);
	}

	public void clearToElement(AndroidDriver driver, WebElement element) {
		waitForElementVisible(driver, element);
		element.clear();
	}
	
	public void checkTheCheckbox(AndroidDriver driver, By byElement) {
		WebElement elementFound = driver.findElement(byElement);
		checkTheCheckbox(driver, elementFound);
	}

	public void checkTheCheckbox(AndroidDriver driver, WebElement element) {
		waitForElementVisible(driver, element);
		element.click();
	}
	
	public WebElement waitForElementVisible(AndroidDriver driver, By byElement) {
		WebElement elementFound = driver.findElement(byElement);
				
		return waitForElementVisible(driver, elementFound);
	}

	public WebElement waitForElementVisible(AndroidDriver driver, WebElement element) {
		WebElement webElementFound = GetWebDriverWait(driver, 30)
				.until(ExpectedConditions.visibilityOf(element));
		
		return webElementFound;
	}
	
	public WebElement waitForElementClickable(AndroidDriver driver, By byElement) {
		WebElement elementFound = driver.findElement(byElement);
		
		return waitForElementClickable(driver, elementFound);
	}

	public WebElement waitForElementClickable(AndroidDriver driver, WebElement element) {
		WebElement webElementFound = GetWebDriverWait(driver, 30)
				.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
		
		return webElementFound;
	}

	private WebDriverWait GetWebDriverWait(AndroidDriver driver, long timeInSecond) {
		return new WebDriverWait(driver, timeInSecond);
	}
}
