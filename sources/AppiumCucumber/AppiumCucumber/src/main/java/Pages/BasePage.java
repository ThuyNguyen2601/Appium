package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import jdk.nashorn.internal.ir.WhileNode;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.PointOption.point;

public class BasePage {
/*
chứa các method dùng chung cho các page
các page khác dùng lại thì chỉ việc extend
 */

    AppiumDriver<MobileElement> driver;
    WebDriverWait wait;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 15);
    }

    public void waitForVisiable(MobileElement element) {
//        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    /*
    custom lại method click mới. wait element xuất hiện trước khi click
     */
    public void waitAndClick(MobileElement element) {
        waitForVisiable(element);
        element.click();
    }

    /*
    custom lại method gettext mới. đảm bảo trước khi get text thì element đã xuất hiện
     */
    public void waitAndGettext(MobileElement element) {
        waitForVisiable(element);
        element.getText();
    }

    /*
    để đảm bảo textbox null trước khi input value, mình sẽ cần clear nó đi.
     */
    public void waitAndSendkey(MobileElement element, String value) {
        waitForVisiable(element);
        element.clear();
        element.sendKeys(value);
    }

    /*
    click to text of element
     */
    public void clickToTextView(String text) {
        WebElement element = driver.findElementByXPath("//android.widget.TextView[@text=\"" + text + "\"]");
        waitForVisiable((MobileElement) element);
        element.click();

    }

    public boolean elemenetDisplay(MobileElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("element khong xuat hien");
            return false;
        }
    }

    public void scrollByPercent(double start, double end) {

        TouchAction touchAction = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int height = size.getHeight();
        int width = size.getWidth();

        System.out.println("height is " + height + " width is " + width);
        int startY = (int) (height * start);
        int endY = (int) (height * end);
        int startX = (width / 2);
        System.out.println("start Y is " + startY);
        System.out.println("end Y is " + endY);
        touchAction.press(point(startX, startY)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000))) //you can change wait durations as per your requirement
                .moveTo(point(startX, endY)).release().perform();

        System.out.println("end scroll ...");

    }

    public boolean scrollToTextView(MobileElement element, long timeout) {
        long startTime = System.currentTimeMillis();
        long duration = 0;
        System.out.println("start time is " + startTime);
        boolean isDisplay = false;
        int numberOfSCroll = 0;
        while (timeout > duration) {
            System.out.println("start while loop");
            if (elemenetDisplay(element)) {
                isDisplay = true;
                break;
            }

            scrollByPercent(0.8, 0.4);
            duration = System.currentTimeMillis() - startTime;
            numberOfSCroll++;
            System.out.println("duration is " + duration);


        }
        System.out.println("number scroll " + numberOfSCroll);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return isDisplay;


    }

}
