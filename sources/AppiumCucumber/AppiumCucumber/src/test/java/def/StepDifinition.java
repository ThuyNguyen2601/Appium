package def;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class StepDifinition {

    AppiumDriver driver;

    @Given("khi tôi mở app lên")
    public void khi_tôi_mở_app_lên() throws MalformedURLException {
        System.out.println(" ->>>> init driver");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("DeviceName", "emulator-5554");
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.vnpt.tnvn");
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.vnpt.tnvn.MainActivity");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\hainv26\\Downloads\\TNVN-Staging-20201204-1.0.6.apk");
//        capabilities.setCapability("newCommandTimeout", 60000);
        capabilities.setCapability("autoGrantPermissions", true);


        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @When("tôi đóng popup")
    public void tôi_đóng_popup() {
        System.out.println("close popup");
        driver.findElementById("com.touchboarder.android.api.demos:id/buttonDefaultPositive").click();

    }

    @When("click vào menu DemoAPI")
    public void click_vào_menu_demo_api() {
        WebElement menuAPI = driver.findElementByXPath("//android.widget.TextView[@text=\"API Demos\"]");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(menuAPI));

        menuAPI.click();
    }

    @Then("I see title is {string}")
    public void i_see_title_is(String string) {
        WebElement menuAPI = driver.findElementByXPath("//android.widget.ImageButton/following-sibling::android.widget.TextView  | //android.widget.ImageView/following-sibling::android.widget.TextView ");
        WebDriver driver1;
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(menuAPI));
        System.out.println("title is " + menuAPI.getText());
        Assert.assertEquals(string, menuAPI.getText());


    }

    @And("click vào menu Supportv")
    public void clickVàoMenuSupportv() {
        WebElement supportV4 = driver.findElementByXPath("//android.widget.TextView[@text=\"Support v4 Demos\"]");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(supportV4));

        supportV4.click();
    }

    @And("click vào menu {string}")
    public void clickVàoMenuMenu(String value) {
        WebElement menuAPI = driver.findElementByXPath("//android.widget.TextView[@text=\"" + value + "\"]");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(menuAPI));

        menuAPI.click();
    }


    @When("click two time to add button")
    public void clickTwoTimeToAddButton(DataTable dataTable) {

        List<List<String>> lists = dataTable.asLists(String.class);

        for (List<String> data : lists) {
            String value = data.get(0);
            System.out.println("current value is " + value);
            driver.findElementByXPath("//android.widget.Button[@text=\"" + value + "\"]").click();
        }


    }

    @Then("I see {int} row added")
    public void iSeeRowAdded(int numberOfRow) {
        String txt = driver.findElementById("com.touchboarder.android.api.demos:id/text").getText();


        String str[] = txt.split("\n");
        List<String> al;
        al = Arrays.asList(str);
        int leng = al.size();
        System.out.println("leng of array is " + leng);
        Assert.assertEquals(numberOfRow, leng);
    }

    @When("click two time to add button using list of map")
    public void clickTwoTimeToAddButtonUsingListOfMap(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps();

        for (Map<String, String> stringMap : maps) {

            String value = stringMap.get("Button Name");
            System.out.println("current value is " + value);
            driver.findElementByXPath("//android.widget.Button[@text=\"" + value + "\"]").click();


        }

    }
}
