package basetest;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;

import java.util.Random;

public class AbstractTest extends BaseSetup{
    public static WebElement webElement;
    public static WebDriverWait wait;

    public AbstractTest(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
        PageFactory.initElements(driver, this);
    }

//    protected final Log log;
//
//    // Contructor
//    protected AbstractTest() {
//        log = LogFactory.getLog(getClass());
//    }
//
//    private boolean checkPassed(boolean condition) {
//        boolean pass = true;
//        try {
//            if (condition == true)
//                log.info("===PASSED==");
//            else
//                log.info("===FAILED==");
//            AssertJUnit.assertTrue(condition);
//        } catch (Throwable e) {
//            pass = false;
//
//            // Add lỗi vào ReportNG
//            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
//            Reporter.getCurrentTestResult().setThrowable(e);
//        }
//        return pass;
//    }
//
//    protected boolean verifyTrue(boolean condition) {
//        return checkPassed(condition);
//    }
//
//    private boolean checkFailed(boolean condition) {
//        boolean pass = true;
//        try {
//            if (condition == false)
//                log.info("===PASSED===");
//            else
//                log.info("===FAILED===");
//            AssertJUnit.assertFalse(condition);
//        } catch (Throwable e) {
//            pass = false;
//            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
//            Reporter.getCurrentTestResult().setThrowable(e);
//        }
//        return pass;
//    }
//
//    protected boolean verifyFalse(boolean condition) {
//        return checkFailed(condition);
//    }
//
//    private boolean checkEquals(Object actual, Object expected) {
//        boolean pass = true;
//        boolean status;
//        try {
//            if (actual instanceof String && expected instanceof String) {
//                actual = actual.toString().trim();
//                log.info("Actual = " + actual);
//                expected = expected.toString().trim();
//                log.info("Expected = " + expected);
//                status = (actual.equals(expected));
//            } else {
//                status = (actual == expected);
//            }
//
//            log.info("Compare value = " + status);
//            if (status) {
//                log.info("===PASSED===");
//            } else {
//                log.info("===FAILED===");
//            }
//            Assert.assertEquals(actual, expected, "Value is not matching!");
//        } catch (Throwable e) {
//            pass = false;
//            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
//            Reporter.getCurrentTestResult().setThrowable(e);
//        }
//        return pass;
//    }
//
//    protected boolean verifyEquals(Object actual, Object expected) {
//        return checkEquals(actual, expected);
//    }

    public int randomData() {
        Random random = new Random();
        return random.nextInt(99999);
    }

    public void tearDown() {
        driver.close();
    }

//    public String getPageTitle() {
//        return driver.getTitle();
//    }

    public boolean isControlDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public boolean isControlSelected(WebElement element){
        return element.isSelected();
    }

    public boolean isControlEnabled(WebElement element){
        return element.isEnabled();
    }

    public void sendKeyToElement(WebElement element, String value){
        waitForElementVisible(element);
        element.sendKeys(value);
    }

    public void clickToElement(WebElement element){
        waitForElementClickable(element);
        element.click();
    }

    public void clearToElement(WebElement element){
        waitForElementVisible(element);
        element.clear();
    }

    public void checkTheCheckbox(WebElement element){
        waitForElementVisible(element);
        element.click();
    }

    public void waitForElementVisible(WebElement element){
        wait = new WebDriverWait(driver, 30);
        webElement = wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable(WebElement element){
        wait = new WebDriverWait(driver, 30);
        webElement = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }
}
