import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.PointOption.point;

public class TestSuit1 extends commonFunction{

    AndroidDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        System.out.println("day la beforeclass");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "ES2BB80615008293");
        cap.setCapability("app", "C:\\Users\\VIVAS\\IdeaProjects\\BasicDemo\\src\\com\\company\\Viettalk_2.0.7_02012020.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("day la beforemethod");
        /**
         *
         */
    }


    @Test
    public void TC1() {
        System.out.println("Day la tc1");
        driver.findElementById("android:id/text1").click();
        driver.findElementById("vn.vinaphone.ott:id/phone_number").clear();
        driver.findElementById("vn.vinaphone.ott:id/phone_number").sendKeys("941912591");
        driver.findElementById("vn.vinaphone.ott:id/continue_").click();
        driver.findElementById("vn.vinaphone.ott:id/password").sendKeys("123456");
        driver.findElementById("vn.vinaphone.ott:id/login").click();
        driver.findElementById("android:id/button1").click();

        //driver.findElementById("android:id/button2").click();
        driver.findElementByXPath("//android.widget.Button[@text='ĐÓNG']").click();

        String titlePage = driver.findElementByXPath("//android.widget.TextView[@text='LỊCH SỬ']").getText();

        Assert.assertEquals(titlePage, "LỊCH SỬ");
    }

    //@Test
    public void TC2() {
        System.out.println("Day la tc2");
        driver.findElementByAccessibilityId("Open navigation drawer").click();
        driver.findElementByXPath("//android.widget.TextView[@text = 'Tài khoản VietTalk']").click();
        String userName = driver.findElementById("vn.vinaphone.ott:id/user_name").getText();

        Assert.assertEquals(userName, "Nguyen Thi Thuy");
    }

    /**
     * function scroll to element
     */
    @Test
    public void TC3() {
        System.out.println("Day la tc3");
        String text = "Hailn";
        WebElement element;
        String uiSelector = "new UiSelector().textMatches(\"" + text
                + "\")";

        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + uiSelector + ");";
//        element = scrollToElementVertical(text);
//        element.click();

        driver.findElementByAndroidUIAutomator(command).click();
    }

    @AfterMethod
    public void afterClass() {
        System.out.println("day la aftermethod");
    }

    @AfterClass
    public void afterMethod() {
        System.out.println("day la afterclass");
    }

//    public WebElement scrollToElementVertical(String textElement){
//        WebElement element;
//        String uiSelector = "new UiSelector().textMatches(\"" + textElement
//                + "\")";
//
//        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
//                + uiSelector + ");";
//
//        element = driver.findElementByAndroidUIAutomator(command);
//        return  element;
//    }

    public WebElement scrollToElementHorizontal(String textElement){
        WebElement element;
        element = driver.findElementByAndroidUIAutomator(new StringBuilder().append("new UiScrollable(new UiSelector().scrollable(true).").append("resourceId(\"<id of scrollable control>\"))").append(".setAsHorizontalList().scrollIntoView(new UiSelector().textContains(\"").append(textElement).append("\"))").toString());
        return element;
    }

}
