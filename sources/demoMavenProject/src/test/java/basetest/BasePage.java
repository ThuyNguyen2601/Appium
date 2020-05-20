package basetest;

import basetest.Log;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;

import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class BasePage extends AbstractTest{

    public BasePage(AndroidDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='LỊCH SỬ']")
    private WebElement pageTitle;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation drawer']")
    private WebElement menuIcon;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView[1]")
    private WebElement accountName;

    public String getPageTitle(){
        waitForElementVisible(pageTitle);
        String title = pageTitle.getText();
        return title;
    }

    public String getAccountName(){
        waitForElementClickable(menuIcon);
        clickToElement(menuIcon);
        String accountNameTxt = accountName.getText();
        return accountNameTxt;
    }

//    public void dragAndDrop(WebElement element1, WebElement element2){
//        TouchAction action = new TouchAction((MobileDriver) driver);
//        action.longPress(longPressOptions().withElement(ElementOption.element(element1)).withDuration(Duration.ofMillis(10000))).moveTo(element2).release().perform();
//    }


}
