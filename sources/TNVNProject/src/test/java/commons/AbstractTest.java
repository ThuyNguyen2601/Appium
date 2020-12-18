package commons;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import setupBase.SetupBase;

public class AbstractTest extends SetupBase {
	public WebDriverWait wait;
	public WebElement webElement;
	
	public AbstractTest(AndroidDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 30);
	}
	
	public int randomData() {
		Random random = new Random();
		return random.nextInt(99999);
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

	public void sendKeyToElement(AndroidDriver driver, By byElement, String value) {
		WebElement element = driver.findElement(byElement);
		waitForElementVisible(driver, element);
		element.sendKeys(value);
	}
	
	public void sendKeyToElement(AndroidDriver driver, WebElement webElement, String value) {
		waitForElementVisible(driver, webElement);
		webElement.sendKeys(value);
	}
	
	public void clickToElement(AndroidDriver driver, By byElement) {
		WebElement element = driver.findElement(byElement);
		waitForElementClickable(driver, element);
		element.click();
	}

	public void clickToElement(AndroidDriver driver, WebElement element) {
		waitForElementClickable(driver, element);
		element.click();
	}
	
	public void clearToElement(AndroidDriver driver, By byElement) {
		WebElement element = driver.findElement(byElement);
		waitForElementVisible(driver, element);
		element.clear();
	}

	public void clearToElement(AndroidDriver driver, WebElement element) {
		waitForElementVisible(driver, element);
		element.clear();
	}
	
	public void checkTheCheckbox(AndroidDriver driver, By byElement) {
		WebElement element = driver.findElement(byElement);
		waitForElementVisible(driver, element);
		element.click();
	}

	public void checkTheCheckbox(AndroidDriver driver, WebElement element) {
		waitForElementVisible(driver, element);
		element.click();
	}
	
	public void waitForElementVisible(AndroidDriver driver, By byElement) {
		WebElement element = driver.findElement(byElement);
		wait = new WebDriverWait(driver, 30);
		webElement = wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementVisible(AndroidDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, 30);
		webElement = wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementClickable(AndroidDriver driver, By byElement) {
		WebElement element = driver.findElement(byElement);
		wait = new WebDriverWait(driver, 30);
		webElement = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
	}

	public void waitForElementClickable(AndroidDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, 30);
		webElement = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
	}

}
